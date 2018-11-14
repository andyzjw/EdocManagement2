/* create a database */
DROP DATABASE IF EXISTS EdocManagement;
CREATE DATABASE EdocManagement DEFAULT CHARACTER SET utf8;
USE EdocManagement;
/* create  tables */
DROP TABLE IF EXISTS edoc_user;-- 管理用户
DROP TABLE IF EXISTS edoc_gender;-- 性别表
DROP TABLE IF EXISTS edoc_entry;-- 电子文档条目
DROP TABLE IF EXISTS edoc_category;-- 电子文档分类表
-- 电子文档条目
CREATE TABLE edoc_category(
	id INT PRIMARY KEY AUTO_INCREMENT,-- 分类编号
	`name` VARCHAR(20) NOT NULL-- 分类名称
);
-- 电子文档分类表
CREATE TABLE edoc_entry(
	id  BIGINT PRIMARY KEY AUTO_INCREMENT, -- 文档编号
	categoryId INT NOT NULL, -- 分类编号
	FOREIGN KEY(categoryId) REFERENCES edoc_category(id),
	title VARCHAR(100) NOT NULL, -- 文档名称
	summary VARCHAR(200), -- 摘要
	uploadUser VARCHAR(20), -- 上传人
	createDate DATE NOT NULL -- 上传时间
);
-- 性别
CREATE TABLE edoc_gender(
	id  INT PRIMARY KEY,-- 性别编号
	sex VARCHAR(10) -- 性别
);

-- 用户表格
CREATE TABLE edoc_user(
	id BIGINT PRIMARY KEY AUTO_INCREMENT,-- 用户编号
	userName VARCHAR(20) NOT NULL,-- 用户名
	pwd VARCHAR(20) NOT NULL,-- 用户密码
	gender INT DEFAULT -1,-- 用户性别
	FOREIGN KEY(gender) REFERENCES edoc_gender(id),
	createDate DATE NOT NULL -- 创建时间
)AUTO_INCREMENT=10001;

/* 数据插入 */
INSERT INTO edoc_category(`name`) VALUES('java'),('前端'),('数据库'); 
-- truncate edoc_category;
-- set foreign_key_checks = 1;
INSERT INTO edoc_entry(categoryId,title,summary,uploadUser,createDate) VALUES
(3,'Oracle学习','Orecle精品','李小明','2018-5-3'),
(1,'java经典入门','java经典入门教程更新','王小明','2018-4-6'),
(2,'JavaScript学习笔记','javaScript笔记','小兰','2018-6-1');

INSERT INTO  edoc_gender VALUES(0,'女'),(1,'男'),(-1,'保密');
INSERT INTO edoc_user(userName,pwd,gender,createDate) VALUES('admin',9999,1,'2016-5-6');

SELECT * FROM 
/*
	查询
    select * from edoc_entry
	
*/
