DROP TABLE IF EXISTS user;

CREATE TABLE user
(
    user_id INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户id',
    username VARCHAR(32) NOT NULL COMMENT '用户名',
    password VARCHAR(32) NOT NULL COMMENT '密码',
    nickname VARCHAR(32) NOT NULL DEFAULT '' COMMENT '昵称',
    sex ENUM('0', '1') NOT NULL DEFAULT 1 COMMENT '性别',
    email VARCHAR(32) NOT NULL DEFAULT '' COMMENT '邮箱',
    mobile_phone VARCHAR(16) NOT NULL DEFAULT '' COMMENT '手机号码',
    create_time DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
    update_time TIMESTAMP NOT NULL DEFAULT now() ON UPDATE now() COMMENT '更新时间',
    PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
COMMENT='用户表' ;

ALTER TABLE user ADD INDEX ix_username (username);
ALTER TABLE user ADD UNIQUE uk_email (email);