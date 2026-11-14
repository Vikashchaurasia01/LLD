CREATE TABLE expense_group (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    NAME VARCHAR(255) NOT NULL,
    owner BIGINT,
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    foreign key (owner) references user(ID)
);

create table expense_group_members (
    expense_group_id bigint,
    member_id bigint,
    foreign key (expense_group_id) references expense_group(ID) on delete cascade,
    foreign key (member_id) references user(ID) on delete cascade
);