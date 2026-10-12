package com.lld.splitwise.models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseGroup extends BaseEntity {
    
    private String name;

    @ManyToOne
    @JoinColumn(name="owner")
    private User owner;

    @ManyToMany
    @JoinTable(
        name = "expense_group_members",
        joinColumns = @JoinColumn(name = "expense_group_id"),
        inverseJoinColumns = @JoinColumn(name = "member_id")
    )
    private List<User> members;
    
}
