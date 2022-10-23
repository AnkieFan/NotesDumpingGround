# Relational Modelling

## Relational DBMS (RDBMS)
Most DBMS are networked and multo-user. This introduces a lot of extra complexity:
+ concurrent writes to files
+ Network interuptions
+ database downtime while users are connected
+ requesting changing data
+ managing computational resources
+ authentication and authorisation

### ACID: an important property of a multi-user DBMS
+ Atomic: Transactions are all or nothing 如果有一条错的，那整一块都不应该执行
+ Consistent: Only valid data is saved
+ Isolated: simultaneous transactions are independently performed 即使同时进行了也该互不干涉
+ Durable: Transactions are never lost

### A transaction
A unit of work that is executed as a single entity:
begin -> transaction -> commit: transaction succeeded
                        roll back/abort: transaction failed

## Definations
+ **Entity**: e.g.: customer, student, part ...
+ **cell**: an individual piece of data in table 一个格子
+ **field**: an attribution of an entity (a column in the table)
+ **row/record**: an instance of an entity
+ **result set**: A non-persistent table, the result of a query 
+ **primary key**: one or more columns that together can be used as a unique identifier for each row in a table
+ **foreign** one or more columns that together can be used to identify a record in another table

## Domain Constraints
Domain constraints can be violated if an attribute value is not appearing in the corresponding **domain** or it is not of the appropriate data type.
- Constraints on whether a cell can be NULL
- Constraints on the data types of records

## Key constraints
An attribute that can uniquely identify a tuple in a relation is called the primary key of the table.  
The AUTO_INCREMENT functionality automatically increments an INT to generate unique ID’s.  

## Entity-Relationship Modelling
The entity-relationship model is a way to organise the description of entities (individual things) and the relationships between them.
+ **Entities** all with characteristic **attributes**
+ For each kind of entity there are **instances** that combine to an **entity set**
+ A **key** as a minimal set of **attributes** to identify and distinguish entity instances
+ **Relationships** between entities