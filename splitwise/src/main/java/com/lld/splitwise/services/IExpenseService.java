package com.lld.splitwise.services;

import java.util.List;
import java.util.Map;

import com.lld.splitwise.models.Expense;

public interface IExpenseService {
    Expense addExpenseWithStrategy(Expense expense, Map<Long, Double> paidMap, Map<Long, Double> percentageMap);

    List<Expense> getUserExpenses(Long userId);

}
