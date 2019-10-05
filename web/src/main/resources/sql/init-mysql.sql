-- 插入用户表数据
ALTER TABLE user ENGINE = MyISAM;

call insert_data_user(10);

ALTER TABLE user ENGINE = InnoDB;

-- 插入 news 表数据

alter table news engine = MyISAM;

call insert_data_news(10);

alter table news engine = InnoDB;