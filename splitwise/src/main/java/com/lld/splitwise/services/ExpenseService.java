package com.lld.splitwise.services;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.lld.splitwise.models.Expense;
import com.lld.splitwise.models.ExpenseGroup;
import com.lld.splitwise.models.Split;
import com.lld.splitwise.models.User;
import com.lld.splitwise.repositories.ExpenseGroupRepository;
import com.lld.splitwise.repositories.ExpenseRepository;
import com.lld.splitwise.repositories.SplitRepository;
import com.lld.splitwise.repositories.UserRepository;
import com.lld.splitwise.services.SplitStrategies.SplitStrategy;

@Service
public class ExpenseService implements IExpenseService {

    private final ExpenseRepository expenseRepo;
    private final SplitRepository splitRepo;
    private final UserRepository userRepo;
    private final ExpenseGroupRepository groupRepo;
    private final Map<String, SplitStrategy> strategyMap;

    public ExpenseService(ExpenseRepository expenseRepo, SplitRepository splitRepo, UserRepository userRepo,
            ExpenseGroupRepository groupRepo, Map<String, SplitStrategy> strategyMap) {
        this.expenseRepo = expenseRepo;
        this.splitRepo = splitRepo;
        this.userRepo = userRepo;
        this.groupRepo = groupRepo;
        this.strategyMap = strategyMap;
    }

    @Override
    public Expense addExpenseWithStrategy(Expense expense, Map<Long, Double> paidMap, Map<Long, Double> percentageMap) {
        List<User> users;

        if (expense.getGroup() != null && expense.getGroup().getId() != null) {
            ExpenseGroup group = groupRepo.findById(expense.getGroup().getId())
                    .orElseThrow(() -> new IllegalArgumentException("Expense group not found"));
            users = group.getMembers();
            expense.setGroup(group);
        } else if (expense.getUserIds() != null && !expense.getUserIds().isEmpty()) {
            users = userRepo.findAllById(expense.getUserIds());
        } else {
            throw new IllegalArgumentException("Either group or userIds must be provided");
        }

        if (expense.getSplitType() == null) {
            throw new IllegalArgumentException("Split type is required");
        }

        SplitStrategy strategy = strategyMap.get(expense.getSplitType().name());
        if (strategy == null) {
            throw new IllegalArgumentException("Invalid split type: " + expense.getSplitType());
        }

        expense = expenseRepo.save(expense);

        List<Split> splits = strategy.calculateSplits(expense, users, paidMap, percentageMap);
        splitRepo.saveAll(splits);
        expense.setSplits(splits);

        return expense;
    }

    @Override
    public List<Expense> getUserExpenses(Long userId) {
        return expenseRepo.findAll().stream()
                .filter(expense -> expense.getSplits() != null && expense.getSplits().stream()
                        .anyMatch(split -> split.getUser() != null && split.getUser().getId() != null
                                && split.getUser().getId().equals(userId)))
                .collect(Collectors.toList());
    }

}
