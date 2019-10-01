DROP TABLE IF EXISTS user_info;

CREATE TABLE user_info (
    user_info_id INT UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '主键',
    user_id INT UNSIGNED NOT NULL COMMENT '用户 ID',
    field_name VARCHAR(32) NOT NULL COMMENT '字段名',
    field_value VARCHAR(64) NOT NULL DEFAULT '' COMMENT '字段值',
    label VARCHAR(32) NOT NULL DEFAULT '' COMMENT '标签，用来标识一组相关的字段',
    ord INT NOT NULL COMMENT '字段顺序'
) ENGINE=InnoDB DEFAULT CHARSET=utf8
COMMENT '用户信息表';

-- 外键约束，级联删除
# ALTER TABLE user_info
#     ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id)
#         REFERENCES user (user_id)
#         ON DELETE CASCADE;


ALTER TABLE user_info
    ADD CONSTRAINT uk_order UNIQUE (ord);



