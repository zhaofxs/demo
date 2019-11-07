DROP TABLE IF EXISTS user;

CREATE TABLE user (
  user_id int(11) NOT NULL,
  user_name varchar(50) NOT NULL,
  password varchar(100) NOT NULL,
  phone varchar(50) DEFAULT NULL,
  id_card varchar(50) DEFAULT NULL,
  PRIMARY KEY (user_id)
);