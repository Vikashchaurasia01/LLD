package com.lld.splitwise.services;

import java.util.List;

import com.lld.splitwise.models.ExpenseGroup;

public interface IGroupService {
    
    ExpenseGroup createGroup(String name, Long creatorId, List<Long> memberIds);

    ExpenseGroup addMember(Long groupId, Long creatorId, Long userId);

    ExpenseGroup removeMember(Long groupId, Long creatorId, Long userId);

    ExpenseGroup getGroupById(Long groupId);
}
