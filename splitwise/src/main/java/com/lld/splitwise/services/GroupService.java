package com.lld.splitwise.services;

import java.util.List;

import com.lld.splitwise.models.ExpenseGroup;
import com.lld.splitwise.models.User;
import com.lld.splitwise.repositories.UserRepository;
import com.lld.splitwise.repositories.ExpenseGroupRepository;
import org.springframework.stereotype.Service;

@Service 
public class GroupService implements IGroupService {

    private UserRepository userRepository;
    private ExpenseGroupRepository expenseGroupRepository;

    public GroupService(UserRepository userRepository, ExpenseGroupRepository expenseGroupRepository) {
        this.userRepository = userRepository;
        this.expenseGroupRepository = expenseGroupRepository;
    }

    @Override
    public ExpenseGroup createGroup(String name, Long creatorId, List<Long> memberIds) {
        User owner = userRepository.findById(creatorId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + creatorId));
            
        List<User> members = userRepository.findAllById(memberIds);

        members.add(owner);

        ExpenseGroup group = ExpenseGroup.builder()
                .name(name)
                .owner(owner)
                .members(members)
                .build();

        return expenseGroupRepository.save(group);
    }

    @Override
    public ExpenseGroup addMember(Long groupId, Long creatorId, Long userId) {
        ExpenseGroup expenseGroup = expenseGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found with id: " + groupId));
        
        if(!expenseGroup.getOwner().getId().equals(creatorId)) {
            throw new RuntimeException("Only the group owner can add members");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        expenseGroup.getMembers().add(user);
        return expenseGroupRepository.save(expenseGroup);
    }

    @Override
    public ExpenseGroup removeMember(Long groupId, Long creatorId, Long userId) {
        ExpenseGroup expenseGroup = expenseGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found with id: " + groupId));
        
        if(!expenseGroup.getOwner().getId().equals(creatorId)) {
            throw new RuntimeException("Only the group owner can remove members");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));

        expenseGroup.getMembers().remove(user);
        return expenseGroupRepository.save(expenseGroup);
    }

    @Override
    public ExpenseGroup getGroupById(Long groupId) {
        return expenseGroupRepository.findById(groupId)
                .orElseThrow(() -> new RuntimeException("Group not found with id: " + groupId));
    }
    
}
