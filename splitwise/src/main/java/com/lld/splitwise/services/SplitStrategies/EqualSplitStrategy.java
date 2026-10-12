package com.lld.splitwise.services.SplitStrategies;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.lld.splitwise.models.Expense;
import com.lld.splitwise.models.Split;
import com.lld.splitwise.models.User;

@Component("EQUAL")
public class EqualSplitStrategy implements SplitStrategy {
    
    @Override
    public List<Split> calculateSplits(
        Expense expense,
        List<User> users,
        Map<Long, Double> paidMap,
        Map<Long, Double> percentageMap
    ) {
        if(users == null || users.isEmpty()) {
            throw new IllegalArgumentException("User list cannot be null or empty");
        }

        double totalAmount = expense.getTotalAmount();
        int numberOfUsers = users.size();

        double equalShare = totalAmount / numberOfUsers;

        List<Split> splits = new java.util.ArrayList<>();

        for(User user : users) {
            double paid = paidMap != null ? paidMap.getOrDefault(user.getId(), 0.0) : 0.0;
            splits.add(new Split(expense, user, paid, equalShare));
        }
        
        return splits;
    }
    
}
