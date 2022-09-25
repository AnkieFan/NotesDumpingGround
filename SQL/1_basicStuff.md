# Databases

DB：database 数据库 在硬盘中以文件形式存在
DBMS： Database Management System 数据库管理系统 Mysql oracle 
SQL：结构化查询语言 是一门通用的语言 属于高级语言
         SQL语句在执行的时候 内部进行编译再执行sql（由DBMS完成）
DBMS(执行） -SQL - DB
 
表 table:
行： 数据/记录 data
列： 字段 column 属性：字段名、数据类型、相关的约束（非0）
 
字符串：varchar 可变字符串
long类型： bigint
UNSIGNED: double the positive range
 
DQL数据查询语言: 查询语句 select语句都是DQL
DML数据操作语言： insert/delete/update 对表中数据进行增删改
DDL数据定义语言: create/drop/alter 对表结构的增删改
TCL事务控制语言: commit提交事务 rollback回滚事务 （T: Transaction 事务）
DCL数据控制语言: grant授权 revoke撤销权限
 
使用步骤：
一 登录 ： mysql -uroot -p12345687
二 查看有哪些数据库（不是SQL语句，是mysql命令） show databases;
三 创建数据库 create database xxxxxxxx;（不是SQL语句，是mysql命令）
四 使用xxxxx数据：use xxxxxxx;（不是SQL语句，是mysql命令）
五  查看当前数据库中的表 show tables; （不是SQL语句，是mysql命令）
六 初始化数据 source +文件路径; 
删除数据库： drop database xxxxxxxx; DROP DATABASE IF EXISTS xxxxx;
 
当一个文件的扩展名是.sql，并且该文件中编写了大量的sql语句，我们称这样的文件为sql脚本

SQL语句当中有一个语法规则，分组函数不可直接使用在where子句当中。
group by是在where执行之后再执行
where sal > avg(sal) 先执行where才能执行group by，但分组函数一定要先执行一次group by（没写就是group by所有数据）

CRUD操作：增删改查
Create Retrieve Update Delete

## 表的三范式
第一范式：任何一张表都应该有主键

## SQL常用命令
***只能在mysql中使用***
1.  查看mysql版本 mysql -version
2. 创建数据库 create database xxxxxxxx;
3. 查询数据库 select database(); 查询数据库版本 select version();
4. \c 结束语句
5. 退出 exit
6. 查看创建表的时候使用的sql语句： show create table xxxxxx;
7. 查看当前库中表：show tables;
查看其他库中表: show tables from xxxxxxx;

## Notations
+ Entity: 表格
+ Cell: 一个格子
+ Field: 列/ a property of an entity
+ Row/record: 一行数据
+ Result set