package com.lld.splitwise.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lld.splitwise.models.ExpenseGroup;

@Repository
public interface ExpenseGroupRepository extends JpaRepository<ExpenseGroup, Long> {
}
