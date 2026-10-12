package com.lld.splitwise.services.SplitStrategies;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.lld.splitwise.models.Expense;
import com.lld.splitwise.models.Split;
import com.lld.splitwise.models.User;

public class PercentageSplitStrategy implements SplitStrategy {

    @Override
    public List<Split> calculateSplits(Expense expense, List<User> users, Map<Long, Double> paidMap,
            Map<Long, Double> percentageMap) {

        if (users == null || users.isEmpty()) {
            throw new IllegalArgumentException("User list cannot be null or empty");
        }
        if (percentageMap == null || percentageMap.isEmpty()) {
            throw new IllegalArgumentException("Percentage map cannot be null or empty");
        }

        return users.stream().map(user -> {
            double percent = percentageMap.getOrDefault(user.getId(), 0.0);
            
            double owed = (percent / 100.0) * expense.getTotalAmount();

            return new Split(expense, user, paidMap.getOrDefault(user.getId(), 0.0), owed);
        }).collect(Collectors.toList());


    }

}
