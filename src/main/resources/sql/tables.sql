drop table if exists banner;
create table banner
(
    id          int primary key auto_increment not null,
    is_deleted  tinyint(1)                     not null default 0,
    image       varchar(255)                   not null,
    sort        int                            not null,
    create_time datetime                       not null default now(),
    update_time datetime                       not null default now()
);

drop table if exists company;
create table company
(
    id          int primary key auto_increment not null,
    name        varchar(255)                   not null,
    description text                           null,
    location    varchar(255)                   null,
    sort        int                            not null,
    is_deleted  tinyint(1)                     not null default 0,
    create_time datetime                       not null default now(),
    update_time datetime                       not null default now()
);

drop table if exists contact;
create table contact
(
    id          int primary key auto_increment not null,
    name        varchar(255)                   not null,
    position    varchar(255)                   null,
    phone       varchar(255)                   null,
    email       varchar(255)                   null,
    sort        int                            not null,
    is_deleted  tinyint(1)                     not null default 0,
    create_time datetime                       not null default now(),
    update_time datetime                       not null default now()
);

drop table if exists module;
create table module
(
    id          int primary key auto_increment not null,
    type        long                           not null,
    sub_type    long                           not null,
    title       varchar(255)                   not null,
    description varchar(255)                   null,
    image       varchar(255)                   null,
    content     text                           not null,
    is_deleted  tinyint(1)                     not null default 0,
    create_time datetime                       not null default now(),
    update_time datetime                       not null default now()
);

drop table if exists module_type;
create table module_type
(
    id          int primary key auto_increment not null,
    name        varchar(255)                   not null,
    background  varchar(255)                   not null,
    sort        int                            not null,
    is_deleted  tinyint(1)                     not null default 0,
    create_time datetime                       not null default now(),
    update_time datetime                       not null default now()
);

drop table if exists module_sub_type;
create table module_sub_type
(
    id          int primary key auto_increment not null,
    type_id     long                           not null,
    name        varchar(255)                   not null,
    sort        int                            not null,
    is_deleted  tinyint(1)                     not null default 0,
    create_time datetime                       not null default now(),
    update_time datetime                       not null default now()
);

