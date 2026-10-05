create table expense (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    description VARCHAR(255),
    total_amount DOUBLE,
    split_type varchar(20),
    created_by_id BIGINT,
    group_id BIGINT,
    foreign key (created_by_id) references user(ID),
    foreign key (group_id) references expense_group(ID)
);

create table expense_split (
    ID BIGINT AUTO_INCREMENT PRIMARY KEY,
    expense_id BIGINT,
    user_id BIGINT,
    paid DOUBLE,
    owed DOUBLE,
    foreign key (expense_id) references expense(ID),
    foreign key (user_id) references user(ID)
);