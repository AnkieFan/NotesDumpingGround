# Mutability and Debugging

## Mutability & Immutable
Mutable type 可改变的 e.g.: StringBuilder
+ 有点像reference data type, 运算后原数据被改
Immutable Type 不可改变的 e.g.: String

Why mutable objects?
+ Optimizing performance
+ Sharing

Immutable types:
+ BigInteger, BigDecimal
+ Collections: List.of, Set.of, Map.of
+ Collections utility class methods
+ create unmodifiable shallow copies of mutable collections

## Debugging

### Avoiding debugging
#### First Defense: Make Bugs Impossible
+ Static and dynamic checking
+ Final keyword for immutable reference
#### Second Defense: Localize Bugs:
Throw an unchecked exception to prevent bug from propagating
+ e.g.: add checking condition

### Assertions
`assert x >= 0 : "x is " + x;`
+ At this point x should be non-negative
+ If x == -1, then program throws an AssertionError: x is -1
+ Careful: in Java assertion are turned o

### Debugging
+ Bug is found only when you plug the whole system together
+ Bug reported by a user after the system is deployed

#### systematic strategy 
1. reducing the size of the buggy input
2. find a small test case
3. start to fix it
4. go back to original

To localize the bug and its cause, you can use the scientific method:
1. Study the data
2. Hypothesize
3. Experiment
4. Repeat
---
1. Study the Data:
   + Stack trace from an exception
   + Test input that causes the bug
   + Failed assertions
2. Hypothesize:
   + Propose a hypothesis, consistent with all the data
   + Think of it as flow of data
   + Then rule out whole sections of the program at once
   + Slicing: finding the parts of a program that contributed to computing a particular value 在合适的地方加print看运算值
   + Delta debugging: Two closely-related test cases that bracket the bug (one succeeds and one fails)
3. Experiment：
   + Probes:
      1. print statement (permanent)
      2. logging (turn off, redirect log)
      3. assertion
      4. breakpoint with a debugger
   + Swap Components: 换另一个确定是对的方法
   + Probe first, then fix later
4. Repeat:
   Result disagreed with the hypothesis -> make a new one
   Result agreed with the hypothesis