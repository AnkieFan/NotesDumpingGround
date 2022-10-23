# Introduction
## What is a database?
+ quickly retrievable based on user's demands
+ can be indexed in many ways
+ has a level of "meaning" relatable to real world entities
+ can be kept up-to-date and is **consisten** at all times

+ preferably store millions of records
+ Preferably accessible by multiple processes at the same time
+ Preferably can be secured and authorized on multiple levels
+ Preferably predictably structured

## Approach
+ a relational approach
+ a document-based approach

## When do you need a database?
+ When your data no longer **fits in memory**
+ When you need **persistence** between processes
+ If **multiple processes** need to access and modify the same data
+ when you need to **secure** your data
+ when **integrity and structure**

## The database management system (DBMS)
+ Can be accessed by multiple users, connect to other systems etc.
+ Single point of entry, no redundancy
+ **Abstraction** through common interfacing and **query language**
+ Network
+ separates **storage** from **data**
+ manages **redundancy and constraints**

### our job
As developer: abstract the DBMS
As data scientists: turn the data from the DBMS into ***actionable*** information

## SQL
+ SQL is a non-procedural language. It is not a "programming language"
+ See it as a way to communicate with a DBMS
+ The DBMS determines **how and when** your statement is executed
+ To use databases in your software, you must use an SDK to communicate using SQL with a DBMS