# Static Checking and Testing

### Types
+ Data Types
+ operations and functions:
    1. Infix, prefix, or postfix operator: a + b
        +: int x int -> int  plus can be recognized as a function name
    2. Method of an object: bigint1.add(bigint2):
        add: BigInteger x BigInteger -> BigInteger
    3. Function Math.sin(theta)         ***sin : static function***
        sin: double -> double  

### Static Typing
+ Java is a statically-typed language: when you write the program, compiler will check before running (*compile time*)
+ Python is a dynamically-typed language: *checking is deferred until runtime*

### Static Checking
+ the bug is found automatically before the programs run
    e.g.: "a" * "b";

### Dynamic Checking:
+ The bug is found automatically when the code is executed
    e.g.: String str = "Hello"; str[6];

### No Checking:
+ the language doesnt help you find the error at all

### Other trap in Java:
+ Integer division: e.g.: 5/2 = 2
+ Integer overflow: e.g.: int i = 2147483647 (Integer.MAX_VALUE); i++; -> -2147483648
+ Special values in floating-point types

## Testing
+ Validation:
  + Verification: math proof
  + Code review: human -> read the code
  + Testing: automatic human -> run the program on carefully selected inputs and check the results

### Exhaustive testing
+ infeasible
+ possible test cases is generally too big
  
### Haphazard testing (“just try it and see if it works”)
+ less likely to find bugs
+ unless the program is so buggy that an arbitrarily-chosen input is more likely to fail than to succeed

### Random or statistical testing
+ not true for software: discontinuous and discrete across the space of possible inputs

***4/4/2022***