package com.lld.splitwise.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import com.lld.splitwise.dto.BalanceDTO;
import com.lld.splitwise.models.Split;
import com.lld.splitwise.repositories.SplitRepository;
import com.lld.splitwise.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service 
public class SettleUpService implements ISettleUpService {

    private final SplitRepository splitRepository;
    private final UserRepository userRepository;

    public SettleUpService(SplitRepository splitRepository, UserRepository userRepository) {
        this.splitRepository = splitRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<BalanceDTO> settleUpUser(Long userId) {
        List<Split> splits = splitRepository.findAll().stream()
                .filter(s -> s.getUser().getId().equals(userId) ||
                        s.getExpense().getCreatedBy().getId().equals(userId))
                .toList();
        return getTransactionsToSettle(splits);
        
    }

    @Override
    public List<BalanceDTO> settleUpGroup(Long groupId) {
        List<Split> splits = splitRepository.findAll().stream()
                .filter(s -> s.getExpense().getGroup() != null &&
                        s.getExpense().getGroup().getId().equals(groupId))
                .toList();

        return getTransactionsToSettle(splits);
    }

    @Override
    public List<BalanceDTO> getTransactionsToSettle(List<Split> splits) {
        Map<Long, Double> netApp = new HashMap<>();
        for(Split split : splits) {
            Long userId = split.getUser().getId();
            double net = split.getPaid() - split.getOwed();
            netApp.put(userId, netApp.getOrDefault(userId, 0.0) + net);
        }

        PriorityQueue<Map.Entry<Long, Double>> debtors = new PriorityQueue<>(Map.Entry.comparingByValue());
        PriorityQueue<Map.Entry<Long, Double>> creditors = new PriorityQueue<>((a, b) -> Double.compare(b.getValue(), a.getValue()));

        for(Map.Entry<Long, Double> entry : netApp.entrySet()) {
            if(entry.getValue() < 0) debtors.add(entry);

            else if(entry.getValue() > 0) creditors.add(entry);
        }

        List<BalanceDTO> txns = new ArrayList<>();
        while(!debtors.isEmpty() && !creditors.isEmpty()) {
            var debtor = debtors.poll();
            var creditor = creditors.poll();

            double settled = Math.min(-debtor.getValue(), creditor.getValue());
            txns.add(new BalanceDTO(
                userRepository.findById(debtor.getKey()).orElseThrow(),
                userRepository.findById(creditor.getKey()).orElseThrow(),
                settled
            ));

            double remainingDebtor = debtor.getValue() + settled;
            double remainingCreditor = creditor.getValue() - settled;

            if(remainingDebtor < 0) debtors.add(Map.entry(debtor.getKey(), remainingDebtor));
            if(remainingCreditor < 0) debtors.add(Map.entry(creditor.getKey(), remainingCreditor));
        }

        return txns;
    }

}
