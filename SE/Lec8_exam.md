# Refactoring

## Technical Debt:
Reasons:
1. Business pressure: time limitation
2. Lack of understanding of the consequences of technical debt
3. Failing to combat the strict coherence of components: the project is a single module
4. Lack of tests
5. Lack of documentation
6. Lack of interaction between team members
7. Long-term simultaneous development in several branches
8. Delayed refactoring: the project's requirements are constantly changing
9. Lack of compliance monitoring: everyone codes with their own style
10. Incompetence

## Code Smells:
### Bloaters
+ Long method: more than 10 lines
+ Large class: a class contains many fields/methods/lines
+ Primitive Obsession: hard code instead of small object
+ Long parameter list: parameter more than 3 or 4
+ Data clumps: different parts of the code contain identical groups of variables
### Object-Orientation Abusers
+ switch statement: complex `switch` or `if else`
+ Temporary Field:most of time they are null. only needed when specific situation
+ Refused Bequest: subclass only use some methods and fields of superclass
+ Alternative Classes with Different Interfaces: Two classes perform identical functions but have different method names.
### Change Preventers
1. Divergent Change: need to change many unrelated methods when you make changes to a class
2. Shotgun Surgery: Making any modifications requires that you make many small changes to many different classes
3. Parallel Inheritance Hierarchies: Whenever you create a subclass for a class, you find yourself needing to create a subclass for another class
### Dispensables 可有可无的
+ Comments
+ Duplicate code: 2 code fragments look almost identical
+ Lazy class: don't use much
+ Data Class: Only contain getter and setter
+ Dead Code: a variable, parameter, field, method or class is no longer used
+ Speculative Generality: unused class, method, field or parameter
### Couplers
+ Feature Envy: A method accesses the data of another object more than its own data.
+ Inappropriate Intimacy: One class uses the internal fields and methods of another class.
+ Message Chains: In code you see a series of calls resembling $a->b()->c()->d()$
+ Middle Man: If a class performs only one action, delegating work to another class, why does it exist at all?