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
        DEFAULT 'abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ';
    DECLARE return_str VARCHAR(255) DEFAULT "";
    DECLARE i INT DEFAULT 0;
    WHILE i < n DO
    SET return_str = concat(return_str, substring(chars_str, floor(1 + rand() * 52), 1));
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
    WHILE n <= num DO
    INSERT INTO user(username, password, email, mobile_phone)
    VALUES (concat('maria', n), md5(rand()), concat('maria', n, '@qq.com'), ceil(rand() * 1e11));
    SET n = n + 1;
    END WHILE;
ENd;
