# Normalization
+ Goal: Remove any possibility of redundancy when designing a database.
+ Split up tabular data until we’ve sufficiently reduced the chance of insert, delete and update anomalies.

## Definitions:

### Redundancy:
+ Direct Redundancy: If data in the database exist in two or more places  
+ Data Redundancy: if data can be calculated from other data items 
+ Data Integrity: The data in the database is consistent and satisfy integrity constraints
Redundancy is a bad thing because when you modify data in case of redundancy, then you must to do so in more than one place. 
Which opens up the possibility that the data becomes inconsistent across the 
database

### Key
+ Primary Key: column or set of columns that identify a particular row in a table. 可以识别出一行
+ Candidate Key: A set of attributes which identify tuples of a table uniquely. It is 
essentially a super key without repeated attributes可以识别出一些行，不能有重复
+ Super Key: single key or set of multiple keys that identifies rows of a table. Super 
key is a superset of a candidate key. 可以识别出一些行，可以有重复
  + A Candidate Key is a super key from which you cannot remove any fields
  + The Primary Key is the minimum candidate key

### Dependency
+ Functional Dependency: 
  + Column A is said to be functionally dependent on column B if changing the value of A requires a change in the value of B
  + Or knowing the value of attribute A you can immediately look up the value of attribute B
+ Categorical data: a collection of information that is divided into distinct groups.

## Normal Form
### First Normal Form 1NF 每一格只有一个数据
An entity is in 1NF iff:
1. it contains no composite values or multi-valued columns
2. It contains no repeating groups of attributes
3. The order in which data is stored does not matter / i.e. tables have no repeating columns
All of the data items in a column must mean the same thing. 

### 2NF 属性完全依赖于主键
+ Any non-prime attribute (i.e. attribute that is not part of any candidate key) should not be dependent on the proper subset of the table’s candidate key.
  + The data must be in First Normal Form
  + Each non key field must reference the same thing as the primary key
  + Each table must contain data about only one type of thing
+ E.g.: ID, Student's name, student's age, course title, course qualification
  + student's info and course's info cannot be referenced to one ID

### 3NF 任何非主属性不依赖于其它非主属性
+ In the third normal form, the following conditions are required:
  + The table should be in the second normal form.
  + A relation has no transitive functional dependencies on the primary key
+ i.e. there is no other non-key attribute that you would need to change in a table if  you changed a non-key attribute
+ E.g.: In table *employee*: ID, name, **dept_id**
  + Then any information in *department* cannot appear here -> can be retrieved by *dept_id*

### Boyce-Codd Normal Form (BCNF)
+ After the third normal form, the following conditions are required:
+ The database is in third normal form
+ Prime attributes should not depend on a non-prime attribute

### 4NF
已经是BCNF，并且不包含多值依赖关系。

## Denormalization
Normalization的数据少，写入快，复杂度低，但读取数据很慢（一个表连到另一个）
+ Maintaining history
  + store values that were calide when a record was created
+ improving query performance
+ seeding up reporting
+ computing commonly-needed values up front

### how
+ Actually undo normalization putting integrity at risk
+ Create duplicates of tables which are periodically filled with source data. If we  can accept the time-delay

# Indexing / Views

## clustered indexes
+ The unique index per table that uses the primary key to organize the data that is within the table.
+ Ensures that the primary key is stored in increasing order, which is also the order 
the table holds in memory.
  + Clustered indexes do not have to be explicitly declared. (in MySQL)
  + Created when the table is created. (in MySQL)
  + Uses the primary key sorted in ascending order. (in MySQL)

## Non-clustered indexes
Sorted references for a specific field, from the main table, that hold pointers back 
to the original entries of the table. 
+ Point to memory addresses instead of storing data themselves
区别：通过聚集索引可以查到需要查找的数据， 而通过非聚集索引可以查到记录对应的主键值 ， 再使用主键的值通过聚集索引查找到需要的数据
### Value pointers
Non-clustered indexes store value pointers, not values themselves.
The pointers with the key can be used to immediately locate a record in the indexed table

## B +/- trees
+ B- tree: each node contains **key values, value pointers**, and **pointers to child nodes** with smaller and larger values than the value in the parent node
  + Pros:
    + Can find values that lie close to the root fairly quickly
    + The B- tree will perform better when the data accessed most frequently lies closer to the **root** node

### B+ tree:
  + The internal nodes only store values
  + Leaf nodes in the B+ tree are linked
#### Property:
+ It is perfectly balanced
+ Every inner node other than the root is at least half full (M / 2 − 1 <= num of keys <= M − 1). 
+ Every inner node with k keys has k+1 non-null children
#### How:
Every node in a B+ Tree contains an array of key/value pairs:
+ Arrays at every node are sorted by the keys
+ The value array for inner nodes will contain pointers to other nodes
#### Two approaches for leaf node values:
1. Record IDs: a pointer to the location of the tuple
2. Tuple data: the actual contents of the tuple is stored in the leaf node

## Hash table indexes
+ Very fast (average O(1)) when querying 
for equality (= or <>)
+ A hash table can’t help us when we want 
to find range, use the < or > operators, 
or speed up the ORDER BY part of the 
clause.

## Indexes
查询变快，写入修改删除变慢
### Use an index on:
+ Foreign Keys, to speed up JOINS
+ often queries fields, dates are ofter good candidates
+ columns that have many different values
### Cons:
+ indexes need to be maintained
  + insertion / deletion / search & update in a B+ tree is still O(log n)
  + insertion / deletion / search & update in a Hash table average O(n)
+ Indexes need to be sorted
### When changing large amounts of data:
1. DROP the INDEX
2. RUN many statements
3. Recreate the index
This prevents the database from rebuilding the index for each transaction.

## Explain
模拟优化器执行SQL查询语句，从而知道MYSQL是如何处理你的SQL语句的。分析你的查询语句或是表结构的性能瓶颈。
EXPLAIN works with SELECT, DELETE, INSERT, REPLACE, and UPDATE statements.

## Views
视图是从一个或几个基本表（或视图）导出的表。
它与基本表不同，是一个虚表。数据库只存放视图的定义，而不存放视图对应的数据，这些数据仍存放在原来的基本表中。
Views give you the ability to store query results as if they were tables.
### why use views:
- security, compliance and privacy
- Data aggregation
- hiding complexity
- Joining partitioned data