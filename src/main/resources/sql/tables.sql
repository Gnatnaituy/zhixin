drop table if exists banner;
create table banner
(
    id          int primary key auto_increment not null,
    image       varchar(255)                   not null,
    sort        tinyint                        not null,
    deleted     char(1)                        not null default '0',
    create_time datetime                       not null default now(),
    update_time datetime                       not null default now()
);

drop table if exists company;
create table company
(
    id          int primary key auto_increment not null,
    name        varchar(255)                   not null,
    bio         varchar(255)                   null,
    description text                           null,
    logo        varchar(255)                   not null,
    location    varchar(255)                   null,
    lng         double                         null,
    lat         double                         null,
    is_primary  char(1)                        not null default '0',
    sort        tinyint                        not null,
    deleted     char(1)                        not null default '0',
    create_time datetime                       not null default now(),
    update_time datetime                       not null default now()
);

drop table if exists contact;
create table contact
(
    id          int primary key auto_increment not null,
    company_id  int                            not null,
    title       varchar(255)                   not null,
    name        varchar(255)                   not null,
    position    varchar(255)                   null,
    sort        tinyint                        not null,
    deleted     char(1)                        not null default '0',
    create_time datetime                       not null default now(),
    update_time datetime                       not null default now()
);

drop table if exists contact_item;
create table contact_item
(
    id          int primary key auto_increment not null,
    company_id  int                            not null,
    contact_id  int                            not null,
    name        varchar(255)                   null,
    value       varchar(255)                   null,
    sort        tinyint                        not null,
    deleted     char(1)                        not null default '0',
    create_time datetime                       not null default now(),
    update_time datetime                       not null default now()
);

drop table if exists module;
create table module
(
    id          int primary key auto_increment not null,
    type_id     int                            not null,
    sub_type_id int                            not null,
    title       varchar(255)                   not null,
    description varchar(255)                   null,
    cover       varchar(255)                   null,
    content     text                           not null,
    deleted     char(1)                        not null default '0',
    create_time datetime                       not null default now(),
    update_time datetime                       not null default now()
);

drop table if exists module_type;
create table module_type
(
    id                int primary key auto_increment not null,
    name              varchar(255)                   not null,
    background        varchar(255)                   not null,
    path              varchar(255)                   not null,
    show_in_home_page char(1)                        not null default '0',
    show_sub_type_all char(1)                        not null default '0',
    sort              tinyint                        not null,
    deleted           char(1)                        not null default '0',
    create_time       datetime                       not null default now(),
    update_time       datetime                       not null default now()
);

drop table if exists module_sub_type;
create table module_sub_type
(
    id                    int primary key auto_increment not null,
    module_type_id        int                            not null,
    name                  varchar(255)                   not null,
    expand_module_content char(1)                        not null default '0',
    sort                  tinyint                        not null,
    deleted               char(1)                        not null default '0',
    create_time           datetime                       not null default now(),
    update_time           datetime                       not null default now()
);

drop table if exists sys_user;
create table sys_user
(
    id          int primary key auto_increment not null,
    name        varchar(16)                    null,
    username    varchar(16)                    not null,
    password    varchar(255)                   not null,
    position    varchar(64)                    null,
    email       varchar(64)                    null,
    phone       varchar(64)                    null,
    deleted     char(1)                        not null default '0',
    create_time datetime                       not null default now(),
    update_time datetime                       not null default now()
);

drop table if exists job;
create table job
(
    id          int primary key auto_increment not null,
    title       varchar(255)                   null,
    content     text                           null,
    deleted     char(1)                        not null default '0',
    create_time datetime                       not null default now(),
    update_time datetime                       not null default now()
);

# 文章添加排序
alter table module add sort tinyint default 0 not null after content;
alter table module add show_in_home_page char(1) default '0' not null after sort;

# 添加主页模块布局
alter table module_type add home_page_layout char default '1' not null after show_in_home_page;
