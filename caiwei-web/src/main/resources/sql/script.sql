-- ****************** function ********************
-- replace(uuid(), '-', '');
-- md5(rand());

-- 生成定长字符串
DROP FUNCTION IF EXISTS random_str;
DELIMITER $$
CREATE FUNCTION random_str(n INT) RETURNS VARCHAR(255)
    NO SQL
BEGIN
    DECLARE chars_str VARCHAR(100)
        DEFAULT 'abcdefghijklmnopqrstuvwxyz';
    DECLARE return_str VARCHAR(255) DEFAULT "";
    DECLARE i INT DEFAULT 0;
    WHILE i < n DO
        SET return_str = concat(return_str, substring(chars_str, floor(1 + rand() * 26), 1));
        SET i = i + 1;
    END WHILE;
    RETURN return_str;
END $$
DELIMITER ;


-- ****************** procedure ********************

-- 生成 user 表测试数据
DROP PROCEDURE IF EXISTS `insert_data_user`;
CREATE PROCEDURE `insert_data_user`(IN num INT)
BEGIN
    DECLARE n INT DEFAULT 1;
    DECLARE str VARCHAR(32) DEFAULT '';
    WHILE n <= num DO
        SET str = replace(uuid(), '-', '');
        INSERT INTO user(username, password, nickname, email, mobile_phone)
        VALUES (str, md5(rand()), random_str(4), concat(str, '@qq.com'), ceil(rand() * 1e11));
        SET n = n + 1;
    END WHILE;
ENd;

drop procedure if exists `insert_data_article`;
create procedure `insert_data_article`(in num int)
begin
   declare n int default 1;
   declare author varchar(32) default '';
   declare i int default 0;
   while n < num do
       # 获取用户表前 10 个用户中的 ID
       set i = mod(n, 10);
       select username into author from user order by user_id limit i, 1;

       insert into article (title, content, author)
       values (md5(rand()), uuid(), author);

       set n = n + 1;
   end while;
end;


-- ****************** trigger ********************

drop trigger if exists `tri_insert_user`;
delimiter ;;
create trigger `tri_insert_user` after insert on `user` for each row begin

end ;;
delimiter ;