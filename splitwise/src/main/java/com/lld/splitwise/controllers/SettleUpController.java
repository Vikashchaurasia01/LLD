package com.lld.splitwise.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lld.splitwise.dto.BalanceDTO;
import com.lld.splitwise.services.ISettleUpService;

import java.util.List;

@RestController
@RequestMapping("/api/settleup")
@RequiredArgsConstructor
public class SettleUpController {

    private final ISettleUpService settleUpService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BalanceDTO>> settleUser(@PathVariable Long userId) {
        return ResponseEntity.ok(settleUpService.settleUpUser(userId));
    }

    @GetMapping("/group/{groupId}")
    public ResponseEntity<List<BalanceDTO>> settleGroup(@PathVariable Long groupId) {
        return ResponseEntity.ok(settleUpService.settleUpGroup(groupId));
    }
}
