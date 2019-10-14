-- 2019-10-01
select * from  user;

SHOW VARIABLES LIKE 'character_set_%';

SELECT random_str(3);

SELECT UUID();

SELECT replace(UUID(), '-', '');

SELECT MD5(RAND());

CALL insert_data_user(1000);

select * from  user where user_id < 1000;

delete from user where user_id < 1000;

call insert_data_user(1000);

select * from user where email like 'tom10%';

select * from user where email like 'tom10%' order by user_id;

delete from user where user_id < 10000;

select * from user where user_id < 1000;

ALTER TABLE user_info DROP FOREIGN KEY fk_user_id;

ALTER TABLE user ENGINE = MYISAM;

call insert_data_user(10000);

select * from user where user_id order by user_id limit 10000;

select * from user where user_id order by user_id DESC limit 10000;

ALTER TABLE user ENGINE = Innodb;

select count(*) from user;

select substr('abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ', 2, 1);

show variables like '%slow%';

set global slow_query_log = on;

show variables like '%long%';

set long_query_time = 1;

select username, (
    case sex when '0' then '女' when '1' then '男' else 'un' end
) as '性别' from user;

select (
    if(sex = '0', '女', '男')
) as '性别' from user;

show create table user;

show variables like '%char%';

show variables like '%log_output%';

select * from user order by user_id desc;

select length(uuid());

select uuid();

show create table user;

alter table user modify email varchar(128);

select * from user where nickname != '';

set @a = (select username from user limit 1, 1);

select @a;

call insert_data_article(3, @a);

select @a;

select 10 mod 4;

select username from user limit 0, 1;

select * from article;

alter table article drop index ix_title;

alter table article drop index uk_username;

show index from article;

select u.user_id, u.username, n.title, n.content from user u join article n using(username) order by u.user_id;

select * from user;

select * from article;

-- 2019-10-07 慢查询

show variables like '%log%';

show global status like '%slow_queries%';

show variables like '%slow_query%';

set global slow_query_log = off;

show variables like '%long_query_time%';

set long_query_time = 2;

show variables like '%log_output%';

set global log_output = 'file,table';

select sleep(5);

select * from mysql.slow_log;

set global general_log = off;

select * from user limit 1;

select argument from mysql.general_log;

select * from user;