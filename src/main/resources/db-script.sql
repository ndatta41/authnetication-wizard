create table user(
    account_id bigint not null auto_increment primary key,
    email varchar(100) not null,
    name varchar(100) not null,
    password varchar(100) not null,
    is_email_verified tinyint not null,
    created_at bigint not null,
    updated_at bigint not null
);

create table email_verification(
    id bigint not null auto_increment primary key,
    account_id bigint not null,
    verification_code varchar(100) not null,
    is_active tinyint not null,
    created_at bigint not null,
    updated_at bigint not null,
    constraint fk_user_account_id foreign key(account_id) references user(account_id)
);
