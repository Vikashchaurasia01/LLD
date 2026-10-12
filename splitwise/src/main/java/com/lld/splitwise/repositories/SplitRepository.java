package com.lld.splitwise.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lld.splitwise.models.Split;

@Repository
public interface SplitRepository extends JpaRepository<Split, Long> {
}
