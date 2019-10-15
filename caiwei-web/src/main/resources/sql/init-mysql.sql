-- 插入用户表数据
ALTER TABLE user ENGINE = MyISAM;
alter table user disable keys;

call insert_data_user(10);

ALTER TABLE user ENGINE = InnoDB;
alter table user enable keys;

-- 插入 article 表数据
alter table article engine = MyISAM;
alter table article disable keys;

call insert_data_article(10);

alter table article engine = InnoDB;
alter table article enable keys;