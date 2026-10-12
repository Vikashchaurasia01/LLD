package com.lld.splitwise.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class CreateGroupRequestDTO {
    public String name;
    public Long ownerId;
    public List<Long> memberIds;
}
