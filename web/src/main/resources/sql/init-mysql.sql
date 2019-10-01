ALTER TABLE user ENGINE = MYISAM;

call insert_data_user(10000);

ALTER TABLE user ENGINE = Innodb;
