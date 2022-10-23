# Database Internals / Conditionals /  Transactions / NoSQL

## Case
case when语句，用于计算条件列表并返回多个可能结果表达式之一。
CASE 具有两种格式：简单 CASE 函数将某个表达式与一组简单表达式进行比较以确定结果。 CASE 搜索函数计算一组布尔表达式以确定结果。  两种格式都支持可选的 ELSE 参数。

## Transactions
Make state transitions independent from atomic operations.

### Ending Transactions
+ you **COMMIT** or **ROLLBACK** the transaction
+ The server shuts down, this **roll back** the transaction when the server is restarted
+ You use a chema statement (ALTER TABLE, CREATE TABLE etc.). Your transaction is committed and a new one started.
+ You use another **START TRANSACTION** command. Your transaction is committed and a new one started.
+ A ***deadlock*** is detected and your transaction is caising it. Your transaction is rolled back.

### Transactions and ACID
#### Atomicity
1. Transactions are often composed of 
multiple statements.
2. Each transaction is treated as a 
single "unit", which either **succeeds** 
completely, or **fails** completely

#### Consistency
A transaction can only bring the database from one **valid state** to another valid 
state.
+ Foreign Keys
+ Unique Constraints
+ Cascades
+ Triggers
Apart from this, an application needs to ensure that the database is and remains in 
a valid state

#### Isolation: Concurrent transactions should not interfere with each other.
+ Avoid dirty read/write
+ Avoid non repeatable read
  + Within a transaction, the same data read any number of times should yield consistent results
+ Avoid phantom read
    a. If you have already read a range of data based upon a key value 
    b. Another transaction inserts a new row which happens to have a value between this range. 
    c. The original range which was referred to would now become invalid

### Multi-User Transactions
We use locks to prevent access to data undergoing transactions
- Write/Read Lock

Locking can occur at different levels:
- Table locks
- Page locks *(a collection of rows/columns of a given size)*
- Row locks

### Transaction lock
In general, don’t hold a transaction open for a user-interaction 
Each HTTP request should start and end a transaction 

## Transaction example
```
SET AUTOCOMMIT = 0
START TRANSACTION
    <execute SQL statements>
SAVEPOINT <name>
    <more SQL statements>
ROLLBACK (TO <name>)
    <more SQL statements>
COMMIT
```

# Database Internals

## On-line Transaction/Analytical Processing (OLTP/OLAP)
### OLTP (transactional app) = Row Store
+ Hign volumn of transactions
+ fast processing
+ normalized data
+ many tables
+ 'who bought X?'

#### N-ARY Storage Model (NSM, row-store) 
The DBMS stores all attributes for a single row contiguously in a page. 
Pros:
+ Fast inserts, updates and deletes
+ Good for queries that need the entire tuple
Cons:
Not good for scanning large portions of the table and/or a subset of the attributes

### OLAP (analytics, reporting) = Column Store
+ High volumn of data
+ slow queries
+ denormalized data
+ fewer tables
+ "How many people bought X?"

#### Decomposition Storage Model (DSM)
The DBMS stores the values of a single attribute (column) for all tuples contiguously in a page.
Pros:
+ reduces the amount wasted I/O because the DBMS only reads the data it needs
+ better query processing and data compression
Cons:
Slow for point queries, inserts, update and delites because of tuple splitting/stitching

## Database Files

### Pages
Every page contains a header of metadata about the page's contents.
+ page size
+ checksum
+ DBMS version
+ transaction visibility
+ compression information
For any page storage architecture， there are also different way to organize the data stored inside of the page.
+ e.g.: Slotted and Log-Structured

# NoSQL
非关系型数据库: 不提前做好架构
类似JSON

## Flexibility
+ We can add data without altering the schema
+ The application is then required to handle old vs new data
+ If you have full control of the data and application this is not an issue
+ We can also integrate data from a multitude of sources without the need to fit the data to a schema.

## Aggregate-Oriented Databases
When modelling things we often combine concepts together into natural 
aggregates
Like a document

## Schemaless Transactions
Atomic:
+ We cannot lock a table or row, only a document
+ The aggregate is the boundary of the transaction

## SQL / NoSQL guidelines:
SQL:
+  Strict schema
+  Relations
+  Distribution of data over tables
+  difficult horizontal scaling
+  Vertical scaling is easier than horizontal scaling

NoSQL:
+ No schema limitations
+ No (or limited relations)
+ Aggregated data
+ Handles horizontal and vertical scaling well
+ High data volume
+ Large data storage

## MongoDB
+ Document-store
+ stores documents as BSON(Binary JSON)
+ Querying power of SQL
  + Aggregate
  + Joins
  + Grouping
+ Indexing
+ Replication / Sharding
+ Load balancing 
+ Enterprise-ready NoSQL

## Redis
#### Properties:
+ Key-value store
+ simple to use
+ supports replication/scalability
+ OpenSource
#### Use-cases:
- Caching
- Messaging
- Queues
- Gaming
- Session store
- Streaming
- Machine Learning
- Real-time analytics

## InfluxDB
#### Properties
+ Column-store
+ specific for time series
+ Automatic timing
+ Optimized for inserting ordered data
+ not optimized: updates/deletes
+ Automatic retention / deletion
+ Streaming
+ Easy development
#### Applications
+ Systems  monitoring
+ Real-time processing
+ Analytics
+ Scraping multiple sources
+ Machine learning