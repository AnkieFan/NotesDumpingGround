# Distributed Databases

## Scaling
### Horizontal scaling
搞更多的设备一起跑。没上线，性能牛逼，但难配置软件维护难
Adding more servers to your application to spread the load。
+ Can make use of on-demand cloud server 
architectures
+ Facilitates redundancy – having each layer running on multiple servers means that if any single machine fails, your application keeps running
### Vertical scaling
Add more RAM, processors, bandwidth, or storage to a machine.
给当前的服务器加硬件，快，简单，有上限，很贵

## The CAP Theorem
分布式计算容易，但维持状态很难
Distributing computations is relatively easy, but the hard part of distributed systems is actually persisting state.

### Consistency
A consitstent view of data on all nodes of the distributed system
所有节点在同一时间具有相同的数据

### Availability
This property demands the system to eventually answer every request, even in case of failures. 
系统需要回答每一个请求，即使失败，尤其是在数据读写的时候。通常有时限。

### Partition tolerance
+ The system is resilient to message losses between nodes. 
+ A partition is an arbitrary split between nodes of a system              。/, resulting in complete message loss in between. 
+ partition是节点之间的分割，partitions之间有信息损失，需要对此弥补。
+ 系统中任意信息的丢失或失败都不会影响系统的继续运作

## Partitioning
+ Separating one table’s rows into multiple different tables
  + Range-Based 根据范围划分 小于50 大于50
  + Key-Based 根据键划分 e.g.: 根据key的Hash分
+ Partitions may be stored on different tablespaces, which can be on different physical **storage tiers (RAM/NVME/SSD/HD)**
+ Partitions can be **compressed** using different compression schemes 可以被压缩
+ **Local indexes** can be dropped for some partitions (e.g. historical data)
+ **Table statistics** can be frozen on some partitions, while being periodically refreshed on others 
+ Individual partitions can be pinned into memory or stored in the database’s flash storage tier

## Distributed Partitions / Sharding
A goal in designing distributed DBMS is to avoid a single node failure taking down the entire system

### Pros:
+ Storage & bandwidth constraints 存储和带宽限制
+ Scale read & write capacity 读写速度更快
+ Geolocation: 地区不同
  + Proximity
  + Privacy & Data protection laws
+ Higher availability 丢失一块比丢失全部好

### Properties:
+ Sharding key needed 连接哪个数据库
+ Smaller reference tables may need to be replicated to all shard, a strategy is needed for how these tables can be modified and changes propagrated to all shards 有参考表的话每个shard都要有，一改所有的都得改
+ 如果一个shard太大了，需要更多的sharding时，模式的修改必须同步给所有
+ Need a strategy for how to query across mutiple database and how to implement transactions across multiple database 需要跨shard查询/执行事务
+ Once a database has been sharded, it can be very difficult to return it to its unsharded architecture 结构确认以后很难改

### Comparission:
+ Parallel Database:
  + Nodes are physically close to each other
  + Nodes are connected via high-speed LAN (fast, reliable communication fabric)
  + The communication cost between nodes is assumed to be small 节点之间损失很小
+ Distributed Database:
  + Nodes can be far from each other
  + Nodes are potentially connected via a public network, which can be slow and unreliable. 
  + The communication cost and connection problems cannot be ignored 通信成本和连接问题不能被忽视
+ Leader-Follower Replication: 领导者接受写入，其他的都复制

## Linearizability
If you ask two replicas the same question, you should get the same result.

## Distributed Relational Databases
+ 执行ACID属性需要很高的复杂性成本：低延迟和高可用性
+ 需要复制大量的数据，连接操作很关键不能放弃，但在这种情况下可能无法使用