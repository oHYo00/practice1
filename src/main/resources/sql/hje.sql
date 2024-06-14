-- CONNECTION: url=jdbc:mysql://localhost:3306/
-- New script in localhost 2.
-- Connection Type: dev 
-- Url: jdbc:mysql://localhost:3306/
-- workspace : C:\workspace\multi\03_db
-- Date: 2024. 5. 31.
-- Time: 오전 10:11:51

USE SCOTT;

drop table user cascade constraints;
create table user(
	user_id varchar(20) primary key,
	pw varchar(100) not null,
	name varchar(20) not null,
	phone varchar(20) not null,
	create_date timestamp DEFAULT CURRENT_TIMESTAMP,
	isdeleted char(2) default 'N',
	del_date timestamp,
	authority_code int(10) NOT NULL DEFAULT 2
);

INSERT INTO `user` 
(user_id, pw, name, phone) 
VALUES ("test11", "$2a$10$8IZAMYMdnr.vMgsB74QfPuwPOruRYcSchSs20kOkln6YO2fXM70hW", "테스트11", "010");

COMMIT;

SELECT * FROM USER;

COMMIT;

drop table task cascade constraints;
create table task(
	user_id varchar(20),
	task_id varchar(100),
	content varchar(100) not null,
	complete char(2) DEFAULT 'N',
	create_date timestamp DEFAULT current_timestamp NOT NULL,
	CONSTRAINT pk_task PRIMARY KEY (task_id),
    CONSTRAINT fk_task FOREIGN KEY (USER_ID) REFERENCES user(USER_ID)
);

SELECT *
FROM task;

drop table user_authority cascade constraints;
CREATE TABLE user_authority (
	authority_code int(10) PRIMARY key,
	authority_name varchar(100) NOT NULL,
	authority varchar(100) NOT NULL
	); 

ALTER TABLE USER ADD FOREIGN KEY fk_user (authority_code) REFERENCES user_authority(authority_code) on delete cascade;

INSERT INTO user_authority 
VALUES (1, "ROLE_ADMIN", "모든 권한을 가진 슈퍼 관리자 권한");
INSERT INTO user_authority 
VALUES (2, "ROLE_MEMBER", "관리자 권한 없이 사용자 권한을 가지는 권한");

SELECT * FROM user_authority;
COMMIT;

drop table diary cascade CONSTRAINT;
create table diary(
	user_id varchar(20),
	dno int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
	create_date timestamp default CURRENT_TIMESTAMP,
	title varchar(100) not null,
	content varchar(200) not null,
	img varchar(100),
    CONSTRAINT fk_diary FOREIGN KEY (USER_ID) REFERENCES user(USER_ID)
);

SELECT * FROM diary;
COMMIT;
