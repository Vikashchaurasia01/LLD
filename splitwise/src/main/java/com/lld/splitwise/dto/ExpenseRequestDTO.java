package com.lld.splitwise.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

import com.lld.splitwise.models.Expense;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseRequestDTO {
    private Expense expense;
    private Map<Long, Double> paidMap;
    private Map<Long, Double> percentageMap;
}
