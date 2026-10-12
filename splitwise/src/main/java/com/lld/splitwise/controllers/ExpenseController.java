package com.lld.splitwise.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lld.splitwise.dto.ExpenseRequestDTO;
import com.lld.splitwise.models.Expense;
import com.lld.splitwise.services.ExpenseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/expense")
@RequiredArgsConstructor
class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping("/add")
    public ResponseEntity<Expense> addExpense(@RequestBody ExpenseRequestDTO request) {
        Expense saved = expenseService.addExpenseWithStrategy(
            request.getExpense(),
            request.getPaidMap(),
            request.getPercentageMap()
        );
        return ResponseEntity.ok(saved);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Expense>> getUserExpenses(@PathVariable Long userId) {
        return ResponseEntity.ok(expenseService.getUserExpenses(userId));
    }
}