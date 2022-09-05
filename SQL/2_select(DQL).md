# select 语句 (DQL)

## 简单的查询语句 (DQL)
语法格式： 
Select 字段名1, 字段名2，…… from 表名;

提示:
1. 任何一条sql语句以 ; 结尾
2. sql语句不区分大小写
3. 字段可以参与数学运算
4. 重命名

查询员工的年薪？
`select ename, sal * 12 from emp;`

查询结果重命名：
`Select ename,sal * 12 as 'yearsal' from emp;`
字符串：Mysql中单双引号都可以用 其他数据库只认单引号
`Select ename,sal * 12  'yearsal' from emp;`
as可以省略

查询全部字段： *代表所有
select * from emp; 效率低 不能写在java程序里
查询所有字段的标准写法： 写上所有字段名

## DQL语句规则
Select 5
….
From 1
… （只能跟表）
Where 2
…
Group by 3
…
Having 4
…
Order by 6
…
Limit   7
…
;

可删 但一定要这个顺序

## 条件查询和模糊查询
语法格式：
select 字段，字段…
from 表名
where 条件;

执行顺序：先from 然后where 最后select

### Between and: 数字：全闭 字符串：左闭右开

查询工资等于5000的员工姓名：
`select ename from emp where sal = 5000;`

查询smith的工资：
`select sal from emp where ename = 'SMITH';`

查询工资大于等于3000的员工：
`select ename from emp where sal >= 3000;`

查找哪些人没有津贴：
`select ename from emp where comm is null;`


查找薪资大于1000并且部门编号是20或30的员工：
`select ename,sal,deptno from emp where sal > 1000 and  (deptno = 20 or deptno = 30) ;`
and优先级大于or 不加括号就是错的

查找工作岗位是MANAGER和SALESMAN的员工：
```
select ename,job from emp where job = 'SALESMAN' or job = 'MANAGER';
select ename,job from emp where job in ( 'SALESMAN' , 'MANAGER');
```
`select ename,job from emp where sal in (800,5000); `找出工资是1000或5000的人
### in 等同于 or in后面不是区间 是值    not in：不是这几个值的

### 模糊查询 like 
在模糊查询中：% 和 _ 
%：任意多个字符      
_：任意一个字符

找出名字里含有O的：
`select ename from emp where ename like '%O%';`
找出第二个字母是A的：
`select ename from emp where ename like '_A%';`
找出名字中有下划线的：转义符：\
`select ename from emp where ename like '%\_%;`
找出名字中最后一个字母是T的：
`select ename from emp where ename like '%T';`

## 排序 order by
按照工资升序找出员工名和薪资：
select ename, sal
from emp
**order by** sal;

<big>**默认升序 asc表示升序 desc表示降序**<small>
`select ename, sal from emp order by sal; `升序
`select ename, sal from emp order by sal asc; `升序
`select ename, sal from emp order by sal desc;` 降序

按照工资的降序排列，当工资相同时再按名字的升序排：
`select ename, sal from emp order by sal desc, ename asc;`
<big>**前面字段主导，前面字段相等时，后面的字段才可以用得到**<small>

按照第二列排序：
`select ename, sal from emp order by 2; `
当列表字段更改时 出错

找出工作是SALESMAN的员工，并且要求按照薪资的降序排列：
`select ename,job,sal from emp where job = 'SALESMAN' order by sal desc, ename asc;`
执行顺序：where - from -select - order by
e.g: `select from name,sal as salary from emp order by salary;`
order by最后执行

## 分组函数（多行处理函数）和 单行处理函数
对一组数据进行操作
多行处理函数的特点：输入多行 输出一行 <big>**自动忽略null**<small>
e.g.: 查询去过该超市6次的人
有些人没有去过，次数为null，此时要单独加一个判断null的语句

count 取得记录数
sum 求和
avg 取平均
max 取最大的数
min 取最小数


找出员工的工资总和：
`select sum(sal) from emp;`
找出总人数：
`select count(ename) from emp;`
找出薪资大于平均薪资的：
`select ename,sal from emp where sal >= (select avg(sal) from emp);`
<big>**SQL语句当中有一个语法规则，分组函数不可直接使用在where子句当中。**<small>

count(*)和count(字段)的区别：
count(*)：总记录条数 与字段无关
count(comm): 表示统计comm字段中不为NULL的数据总数量

分组函数也能组合起来用：
`select count(*), sum(sal), avg(sal),max(sal),min(sal) from emp;`

单行处理函数： 输入一行 输出一行
计算年薪：
e.g: `select ename,(sal+comm)*12 as yearsal from emp;`
所有数据库都是这样规定的 只要有NULL参与的运算 结果一定是NULL
`select ename,(sal+ifnull(comm,0))*12 as yearsal from emp;`

ifnull() 空处理函数：（单行处理函数）
ifnull(可能为null的数据，被当做什么来处理)
e.g: select ename, ifnull(comm,0) from emp; 如果comm是null，当做0看待

## GROUP BY / HAVING
group by: 按照某个字段或者某些字段进行分组
having: having是对分组之后的数据进行再次过滤
没有group by不能用having
能在where过滤就先过滤

分组函数一般会和group by联合使用 where先执行 再 group by先执行分组函数再执行
当一条sql语句没有group by的话，整张表的数据自成一组。

e.g: 找出每个工作岗位的最高薪资：
select job,max(sal) as maxsal from emp group by job;
当后面有group by的时候 select后面只能跟分组函数与参加分组的字段
如果有其他的字段：Oracle直接报错 mysql中随机抽取字段中元素（无意义）

### 多个字段联合分组：
找出每个部门不同工作岗位的最高薪资：
`select deptno,job,max(sal) as maxsal from emp group by deptno,job;`

找出每个部门的最高薪资，要求显示薪资大于2900的数据：
`select deptno, max(sal) from emp group by deptno having sal>2900; `效率低
`select deptno,max(sal) from emp where sal > 2900 group by deptno;` where先执行

找出每个部门的平均薪资，显示薪资大于2000的
`Select deptno, avg(sal) from emp group by deptno having avg(sal)>2000;`

## 去除查询结果集重复记录
distinct：去除结果中的重复记录 只能出现在所有字段的最前方
后面有多个字段：多个字段连续去重
E.g: `select distinct job from emp;`

统计岗位个数：
`Select count(distinct job) from emp;`

## 连接查询
大部分情况都不是从单表中查询数据，一般是多张表联合查询，取出最终结果

连接查询的分类：
1. 根据语法出现的年代来分：SQL92/SQL99
2. 根据表的连接方式来划分：
	+ 内连接：等值连接 非等值连接 自连接
	+ 外连接： 左外连接（左连接） 右外连接（右连接）
	+ 全连接（很少用）
	
### 在表的连接查询方面，有一种现象：笛卡尔积现象。
+ 笛卡尔积现象：当两张表进行连接查询时，如果没有任何限制条件，查询结果条数会是两张表的记录条数的乘积。

### 内连接 等值连接
E.g: 找出每一个员工的部门名称，要求显示员工名和部门名。
`Select ename,dname from emp,dept;` ename和dname要联合显示 会产生14*4条记录 笛卡尔乘积现象

关于表的别名：
`Select e.ename,d.dname from emp e,dept d;`
如果不起别名：先在emp中找ename，再在dept中找ename
别名merits：执行效率高 可读性好
	
### 如何避免笛卡尔积现象：加条件进行过滤（但不能提高匹配效率）
避免了笛卡尔积现象不会减少记录的匹配次数，但只显示有效次数。
 `Select e.ename,d.dname from emp e,dept d where e.deptno = d.deptno;`（sql92，以后不用 连接和过滤）
`Select e.ename, d.dname from emp e (inner) join dept d on e.deptno = d.deptno;` sql99
语法：
… A (inner) join B on 连接条件 where…;
99语法merit： 更清晰 表的连接条件和后来where过滤分开
inner可省略 带inner可读性更高

### 内连接 非等值连接：
最大特点：连接条件中的关系是非等量关系。
E.g: 找出员工的工资等级，要求显示员工名，工资，工资等级。
`select e.ename,e.sal,s.grade from emp e join salgrade s on e.sal between s.losal and s.hisal;`

### 内连接 自连接
自连接最大的特点：一张表看作两张表 自己连自己
E.g: 找出每个员工的上级领导，要求显示员工名和对应的领导名
`Select a.ename,b.ename from emp a join emp b  on a.mgr = b.empno;`

### 外连接（使用居多）
内连接：假设A和B表进行连接，使用内连接，凡是A表和B表能够匹配的记录：查询出来
AB两表无主副之分，两张表地位平等
外连接：假设A和B表进行连接，使用外连接，AB两表中有一表为主表。查询时主要查询主表中的数据，携带查询副表。当副表中数据没有和主表匹配时，副表自动模拟NULL与之匹配
重要特点：主表的数据无条件全部查询出来
E.g: 找出哪个部门没有员工？
`Select d.dname,e.empno from dept d left join emp e on d.deptno = e.deptno where e.empno is null;`

### 左外连接 左连接：左边的为主表
### 右外连接 右连接：右边的为主表
左右连接一定可以互换 不同写法

E.g: 找出每个员工的上级领导，要求显示员工名和对应的领导名
`Select a.ename,b.ename from emp a left (outer) join emp b  on a.mgr = b.empno;`
a为主表 左连接
`Select a.ename,b.ename from emp b right (outer) join emp a  on a.mgr = b.empno;`
a为主表 右连接

### 全连接：既左连接也右连接

### 三张表的连接查询
E.g: 找出每个员工的工资等级与部门名称：
`Select e.ename,d.dname,s.grade from emp e join dept d on e.deptno = d.deptno join salgrade s on e.sal between s.losal and s.hisal;`
E.g: 找出每个员工的工资等级与上级领导：
`Select e.ename,d.dname,s.grade,e1.ename as leader from emp e join dept d on e.deptno = d.deptno join salgrade s on e.sal between s.losal and s.hisal left join emp e1 on e.mgr = e1.empno;`

A join B join C on 表示A和B先进行连接 连接结果与C继续连接

## 子查询
Select语句中可以嵌套select语句，被嵌套的select语句叫做子查询
Select
 ….(select)
From
…(select)
Where
…(select)

Where子句中使用子查询：
e.g: 找出高于平均薪资的员工信息
第一步：找出平均薪资
`Select avg(sal) from emp;`
第二部：where过滤
`Select * from emp where (Select avg(sal) from emp);`

From后嵌套子查询：
e.g:找出每个部门平均薪水的薪资等级：
找出每个部门平均薪资： `select deptno,avg(sal) as avgSal from emp group by deptno;`
将以上查询结果当作临时表d，让表d和salgrade做连接查询。
找出平均薪资的薪资等级： 
`select d.deptno,d.avgSal,s.grade from (select deptno,avg(sal) as avgSal from emp group by deptno) d,salgrade s where d.avgSal between s.losal and s.hisal;`

e.g:找出每个部门平均的薪资等级：
`Select e.deptno,avg(s.grade) from emp e join salgrade s on e.sal between s.losal and s.hisal group by e.deptno;`

Select后嵌套子查询：
e.g: 找出每个员工所在的部门名称，要求显示部门名称和员工名。
`Select e.name,d.dname from emp e join dept d on e.deptno = d.deptno;`
`Select e.ename, (select d.dname from dept d where e.deptno = d.deptno) as dname from emp e;`

## Union 将查询结果集相加
**两个表的列的数量要一样**
e.g:找出工作岗位是SALESMAN和MANAGER的员工
```
Select ename,job from emp where job = 'SALESMAN' or job = 'MANAGER';
SELECT ename,job from emp where job in ('SALESMAN', 'MANAGER');
SELECT enam,job from emp where job = 'SALESMAN' union slect ename,job from emp where job = 'MANAGER';
```

两张不相干的表中的数据拼接在一起显示：
`Select ename from emp union select dname from dept;`
```
+------------+
| ename      |
+------------+
| SMITH      |
| ALLEN      |
| WARD       |
| JONES      |
| MARTIN     |
| BLAKE      |
| CLARK      |
| SCOTT      |
| KING       |
| TURNER     |
| ADAMS      |
| JAMES      |
| FORD       |
| MILLER     |
| ACCOUNTING |
| RESEARCH   |
| SALES      |
| OPERATIONS |
+------------+
18 rows in set (0.00 sec)
```
Union join 就是全连接

## LIMIT (only in mySQL)
Limit是mysql中特有的  最后执行的一个环节
Oracle中有相同的机制rownum
Limit取结果集中的部分数据
语法机制：
Limit startIndex, length
StartIndex 起始位置索引值（可省略，默认为0）
length表示取几个

e.g: 取出工资前五名的员工
`Select ename,sal from emp order by sal desc;`
取前五个：
`Select ename,sal from emp order by sal desc limit 0,5;`
`Select ename,sal from emp order by sal desc limit 5;`
第四到第九名：
`Select ename, sal from emp order by sal desc limit 3,6;`

### 通用的标准分页sql
Java代码：
Int pageNo = 2; //页码是2
Int pageSize = 10; //每页显示10条
… limit, (pageNo-1)*pageSize, pageSize;