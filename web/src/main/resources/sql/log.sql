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

