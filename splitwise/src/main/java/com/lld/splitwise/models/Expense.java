package com.lld.splitwise.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Expense extends BaseEntity {
    
    private String description;

    @Column(name = "total_amount")
    private Double totalAmount;

    @Column(name = "split_type")
    @Enumerated(EnumType.STRING)
    private SplitType splitType;
    
    @ManyToOne
    @JoinColumn(name = "group_id")
    private ExpenseGroup group;

    @ManyToOne
    @JoinColumn(name = "created_by_id", nullable = false)
    private User createdBy;

    @OneToMany(mappedBy = "expense", cascade = jakarta.persistence.CascadeType.ALL)
    @JsonManagedReference
    private List<Split> splits = new ArrayList<>();

    @Transient
    private List<Long> userIds;

}
