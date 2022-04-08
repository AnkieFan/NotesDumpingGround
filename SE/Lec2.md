# Software

## What is well-designed software
+ Maintainability: should be evolved to meet the changing needs of customers.
+ Dependability: should be reliable, secure and safe
  + Malicious users should not be able to access or damage the system
  + will not cause finance or some lose
+ Efficiency: should not waste system resources
  + Memory
  + Processor Cycles
  + Disk Space
  + Bandwidth
+ Acceptable: should be accpepted by users

## Diminishing Returns
+ At first: small team, easy tasks, do not need to think about maintainability...
+ Then: *High coupling* 高耦合, technical depth, too much communication, repeated functionality

### Maintainable Software
+ The difficulty of making a change should be proportional to the scope of the change
  
### Preventing Diminishing returns
+ Design Choices (loose coupling)
+ fitting architectural choices
+ code quality
+ Agile / Communication
+ Managing users / stakeholders
  
### Agile Principles
1. satisfy the customer through early and continuous delivery of valuable software. 开发需要时间，软件要一直跟上客户的需求。
2. welcome changing requirments
3. deliver working software frequently 频繁的推送软件
4. Business people and developer must work together 客户和开发一起工作
5. Build projects around motivated individuals
6. convering information to and within a development team by face-to-face conversation
7. working software is the primary measure of progress
8. promote sustainable development. The sponsors, developers, and users should be able to maintain a constant pace indefinitely.
9. Continuous attention to technical excellence and good design


## What is *State*
+ The contents of these memory locations, at any given point in the program's execution, is called the program's state.

### Object-Oriented Design
+ Object: data structure with value in memory and unique id
+ Class: extensible code template
+ Modelling **state** first

#### Object-Oriented Programming
+ Key Concepts
  + Encapsulation (Abstraction)
  + Inheritance
    + Strong couples
  + Polymorphism

+ Interface
  + Uncouple code
  + design-by-contract
  
+ Modularity & cohesion
  + The Reuse-Release Equivalence Principle (REP): 

# UML Modelling
+ UML: Unified Modelling Language
+ class diagrams
+ sequence diagrams
+ state diagrams

## Classes diagram
1. class name
2. class variables
   + +: public
   + -: private
   + #: protected
3. class methods
   + +: public
   + -: private
   + #: protected

### Association: 
+ A relationship bet
+ Drawn as a line
+ 