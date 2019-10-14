DROP TABLE IF EXISTS article;

CREATE TABLE article (
    article_id INT NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
    title VARCHAR(32) NOT NULL DEFAULT '' COMMENT '主题',
    content VARCHAR(256) NOT NULL DEFAULT '' COMMENT '内容',
    author VARCHAR(32) NOT NULL DEFAULT '' COMMENT '作者',
    location VARCHAR(32) NOT NULL DEFAULT '' COMMENT '发送消息位置',
    visible BOOL NOT NULL DEFAULT FALSE COMMENT '文章是否可见',
    create_time DATETIME NOT NULL DEFAULT now() COMMENT '创建时间',
    update_time TIMESTAMP NOT NULL DEFAULT now() ON UPDATE now() COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8
COMMENT '文章列表';

ALTER TABLE article ADD INDEX uk_author (author);

ALTER TABLE article ADD INDEX ix_create_time (create_time);
