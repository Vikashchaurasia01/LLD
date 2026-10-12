package com.lld.splitwise.services.SplitStrategies;

import java.util.List;
import java.util.Map;

import com.lld.splitwise.models.Expense;
import com.lld.splitwise.models.Split;
import com.lld.splitwise.models.User;

public interface SplitStrategy {
    
    List<Split> calculateSplits(
        Expense expense,
        List<User> users,
        Map<Long, Double> paidMap,
        Map<Long, Double> percentageMap
    );
}
