DROP TABLE IF EXISTS hello_world;

CREATE TABLE hello_world (
    hello_world_id INT NOT NULL PRIMARY KEY,
    message VARCHAR(32) NOT NULL DEFAULT '' COMMENT 'SHU'
)

