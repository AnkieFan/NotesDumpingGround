# Softwear Engineering
Good software should be:
1. Maintainable: is easier to change
2. Dependable: should be reliable, secure and safe
3. Efficient: should not waste system resources
4. Acceptable: be acceptable to its users

## Diminishing Returns
+ At first: small team, easy tasks, do not need to think about maintainability...
+ Then: *High coupling* 高耦合, technical depth, too much communication, repeated functionality

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

# OOP

+ **State:** The contents of these memory locations, at any given point in the program's execution, is called the program's state.


## Keys of OOP
+ Encapsulation (封装): to restrict permissions for code editing.
+ Inheritance (继承): Objects can have an “is-a” relationship to others:
  + e.g. Cat is-a Mammal, Mammal is-a Animal, etc.
  + Strongly couples (耦合): difficult to change without side-effects
  + Polymorphism (多态): A practical use-case of inheritance; Ability of objects to take many forms.
+ Interfaces: The best way to **uncouple** code
  + Why?
    + Wider inheritance options: (In Java) extend one class (single inheritance), implement interfaces (multiple inheritance)
    + Interfaces guarantee a behavior
+ Loose-Coupling: Using inheritance, interfaces and polymorphism you can promote the use of classes without designing **interdependent** structures


## Modularity
+ Packages / Namespaces / Modules: A package in Java is used to group related classes
+ Modularity:
  + The Reuse-Release Equivalence Principle (REP): Classes should be packaged together because they are released together
  + The Common-Reuse Principle (CRP): The classes in a component are reused together. If you reuse one of the classes in a component, you reuse them all
  + The Common-Closure Principle (CCP): Classes in a component should be closed together against the same kinds of changes. A change that affects a component affects all the classes in that component and no other components

## Object Oriented Design
+ Object: data structure with value in memory and unique id
+ Class: extensible code template
+ Modelling **state** first


## GRASP principles:
+ information expert
+ creator
+ low coupling
+ controller
+ high cohension
+ polymorphism
+ pure fabrication
+ indirection
+ protected variations