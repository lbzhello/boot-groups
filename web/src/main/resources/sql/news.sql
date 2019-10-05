DROP TABLE IF EXISTS news;

CREATE TABLE news (
    news_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
    title VARCHAR(32) NOT NULL DEFAULT '' COMMENT '主题',
    content VARCHAR(256) NOT NULL DEFAULT '' COMMENT '内容',
    username VARCHAR(32) NOT NULL DEFAULT '' COMMENT '用户',
    location VARCHAR(32) NOT NULL DEFAULT '' COMMENT '发送消息位置',
    visible BOOL NOT NULL DEFAULT FALSE COMMENT '消息是否可见',
    create_time DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
    update_time TIMESTAMP NOT NULL DEFAULT now() ON UPDATE now() COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8
COMMENT '广播消息表';

ALTER TABLE news ADD INDEX uk_username (username);

ALTER TABLE news ADD INDEX ix_create_time (create_time);


