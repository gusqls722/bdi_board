SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS Comment_info;
DROP TABLE IF EXISTS Board_info;
DROP TABLE IF EXISTS User_info;




/* Create Tables */

CREATE TABLE Board_info
(
	biNum int unsigned NOT NULL AUTO_INCREMENT,
	biTable varchar(3000) NOT NULL,
	biTest text NOT NULL,
	biFile varchar(50),
	biCredate datetime NOT NULL,
	biModat datetime NOT NULL,
	biCnt int unsigned DEFAULT 0 NOT NULL,
	biActive tinyint DEFAULT 1 NOT NULL,
	uiNum int unsigned NOT NULL,
	PRIMARY KEY (biNum)
);


CREATE TABLE Comment_info
(
	ciNum int unsigned NOT NULL AUTO_INCREMENT,
	ciCredat datetime NOT NULL,
	ciModat datetime NOT NULL,
	ciText varchar(3000) NOT NULL,
	uiNum int unsigned NOT NULL,
	biNum int unsigned NOT NULL,
	PRIMARY KEY (ciNum)
);


CREATE TABLE User_info
(
	uiNum int unsigned NOT NULL AUTO_INCREMENT,
	uiId varchar(30) NOT NULL,
	uiPwd varchar(30) NOT NULL,
	uiName varchar(30) NOT NULL,
	uiEmail varchar(100),
	PRIMARY KEY (uiNum),
	UNIQUE (uiId)
);



/* Create Foreign Keys */

ALTER TABLE Comment_info
	ADD FOREIGN KEY (biNum)
	REFERENCES Board_info (biNum)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Board_info
	ADD FOREIGN KEY (uiNum)
	REFERENCES User_info (uiNum)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE Comment_info
	ADD FOREIGN KEY (uiNum)
	REFERENCES User_info (uiNum)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



