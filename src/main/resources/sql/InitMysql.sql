# 初始化数据库
drop database if exists 'smDb';
create database 'smDb';
use 'smDb';
drop table if exists 'user';
create table 'user'(
    'id' bigint(20) not null,
    'username' varchar(50) collate utf8_bin not null,
    'password' varchar(50) not null,
    'status' int(11) not null default 1,
    'create_time' datetime not null,
    'update_time' datetime not null,
    'create_user' varchar(50) not null,
    'update_user' varchar(50) not null,
    primary key (`id`) using btree,
    unique key `idx_username` (`username`)
) engine=InnoDB default charset=utf8;
drop table if exists 'sensor_data';
create table 'sensor_data'(
    'id' bigint(11) not null,
    'sensor_id' int(11) not null,
    'water_value' varchar(50) not null,
    'lux_value' varchar(50) not null,
    'temperature_value' varchar(50) not null,
    'create_time' datetime not null,
    'update_time' datetime not null,
    'create_user' varchar(50) not null,
    'update_user' varchar(50) not null
) engine=InnoDB default charset=utf8;
insert into user values('1', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 1, now(), now(), 'admin', 'admin');