package com.lld.splitwise.dto;

import com.lld.splitwise.models.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BalanceDTO {
    private User from;
    private User to;
    private Double amount;
}
