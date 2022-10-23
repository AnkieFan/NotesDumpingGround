# Databases for Big Data

## Big Data
Data that cannot reasonably be stored and processed on a singled device
### 2 aspects
- Distributed storage (Distributed File Systems / Sharding)
- Distributed processing (and handling Derived data)
### Processing on Big-Data (main topic)
- Not as easy as writing an SQL query and expecting fast results
- Exploration, Analytics, Processing, Publishing

## Database Architecture
+ Model View Controller
  + View --SDK/API-- controller --Database API/SQL-- database/model
  + Single DBMS
+ Adding BI
  + View --SDK/API-- controller --Database API/SQL-- database/model --DATABASE API/SQL-- 可视化软件

### Data Warehousing 仓库
+ Collecting data for reporting purposes    
  + Make static snapshots to send to a central data warehouse
  + Extract, Transform, Load (**ETL**)
  + Staging - preparing data for reporting an integration 缓存
  + Takes load off operational systems 减轻运营系统的负担
  + Enriches information by combining systems 通过整合系统来丰富信息

### main challenge in scalability
- Buy bigger machines (vertical scaling)
- Buy more machine (Horizantal scaling)

### Properties:
将许多数据库结合起来：e.g.: Netflix, Amazon, MORPG game, Government systems
+ Architecture must scale
+ Fault tolerance can be built-in
+ There is not necessarily a single “truth”
+ Global coverage
+ Redundancy is allowed

### Data Processing: ETL to Big Data
Relational databases -> ETL -> Big Data -> Cloud Solution


## Hadoop Distributed File System (HDFS)
### illustration
+ HDFS is the storage layer for Hadoop BigData System
+ Based on the Google File System (GFS)
+ Fault-tolerant distributed file system
+ Designed to turn a computing cluster (a large collection of loosely connected compute nodes) into a massively scalable pool of storage
+ Provides redundant storage for massive amounts of data -- scales up to 
100PB and beyond

### Properties
+ Made to be resilient & fail proof, when each **datanode** writes its memory to **disk data blocks**, it also replicates that memory to another server 
+ **Datanodes** can be made rack aware, since redundancy does not work when you write data to two disk drives in the same rack
+ The **namenode** tells the datanodes where to write data, also tells your application **which data nodes hold the file**

## HBASE
+ Used like a NoSQL database. It maps directly to HDFS
+ It holds tables with **column families**, a table can have thousands of columns
+ HBase has a weak **consistency** model, but there are ways to use it safely
### Pros:
+ Sorted rows: support billions of rows
+ Columns: Supports millions of columns
+ Cell: intersection of row and column
  + Can have multiple values (which are time-stamped)
  + Can be empty. No storage/processing overheads
### Not idea for
+ Large objects like videos
+ Storing time-series, like logs, organized by time-stamps cause write hot-spots

## Streaming Data
Netflix, MORPG game... 流数据
In many cases we need real-time processing, and process messages 1 by 1

### Apache Kafka
+ Functions like a distributed publish-subscribe messaging system (or a distributed streaming platform)
+ Features: Durability, Scalability, High Availability, High Throughput

## Batch & Stream Processing

#### Batch:
处理已经储存了一段时间的数据**块**
实际写入硬盘
Processing of **blocks** of data that have already been stored over a period of time.
  + Often on disk
  + Hadoop & MapReduce

#### Stream:
实时处理，暂存在缓存里
Process data in real-time as they arrive and 
detect conditions within a small period of time from the point of receiving the data.
  + Often in-memory
  + Multiple publishers & subscribers
  + Concurrency
  + Kafka & Spark Streaming

## Data Exploration
Describing the data by means of statistical and visualization techniques
With big data:
  + We cannot load all data in memory
  + Some operations take too much time to run on a single machine

### Examples:
+ **Pandas** is an implementation of the DataFrame data structure
+ **PySpark** uses the same data structure to distribute computation in a cluster.
Dask provides another distributed DataFrame alternative