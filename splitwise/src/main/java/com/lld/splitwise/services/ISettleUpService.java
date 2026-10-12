package com.lld.splitwise.services;

import java.util.List;

import com.lld.splitwise.dto.BalanceDTO;
import com.lld.splitwise.models.Split;

public interface ISettleUpService {
    
    List<BalanceDTO> settleUpUser(Long userId);

    List<BalanceDTO> settleUpGroup(Long groupId);

    List<BalanceDTO> getTransactionsToSettle(List<Split> splits);
}
