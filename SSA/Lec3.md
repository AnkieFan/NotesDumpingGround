# Random number generators
## Properties of a “good” random number generator
- !!! produces numbers that appear to be distributed uniformly on [0,1]
- !!! produces numbers that do not exhibit any correlation with each other
- Is fast
- Does not need much storage memory
- Can easily produce separate streams of random numbers
- Can reproduce a given stream of random number exactly
- Produces the same sequence of random numbers for all standard compilers and computers

## Linear Congruential Generators (LCG)
+ $Z_i = (aZ_{i-1}+c)$(mod m)
  + Modulus $m$, multiplier $a$, increment $c$ and seed $Z_0$ are nonnegative integers
  + 0 < m, a < m, c < m, and $Z_0$ < m
+ Looping behavior
  + Random numbers repeat on a cycle
  + Length of cycle called period of the generator

### Disadvantage:
+ Looping will occur (cycle)
+ Cycle length is period
+ Cycle length depends on seed
+ The period of a good LCG generator should be very large
  + Often scale of simulation projects large
  + Full period contributes to uniformity


### Theorem 7.1: An LCG has full period iff the following three conditions hold
1. m and c is are relatively prime (最大公约数为1)
2. If qis a prime number that divides m, then q divides a-1
3. If 4 divides m, then 4 divides a-1

### Optimizing
+ Mixed generators:
  + Good choice of m: $m = 2^b$
    + Where b is the number of binary digits in a word on the computer being used for storage
+ Multiplicative generators:
  + More widely used than mixed generators
  + c is not needed
  + Choice for m: largest prime number that is less than $2^b$
+ Many experts recommend that LCG’s with modulus $m = 2^{31}$ should no longer be used as the random number generator for general purpose software

## Feedback Shift Registers (FSR)
在移位寄存器向右移位一位以后，左边就会空出一位（如上图所示），这时如果采用一个反馈函数，以寄存器中已有的某些序列作为反馈函数的输入，在函数中经过一定的运算后，将反馈函数输出的结果填充到移位寄存器的最左端，那么这样的移位寄存器就会有源源不断的输出。这样的，拥有反馈函数的移位寄存器称为反馈移位寄存器（Feedback Shift Register，FSR）

#### Linear Feedback Shift Register (LFSR)
https://en.wikipedia.org/wiki/Linear-feedback_shift_register    

## Testing Random Number Generators
### Empirical tests 经验性测试
  + Use the generator to generate random numbers
  + Check for uniform distribution: Chi^2 test
  + Check for independence: Poker test
  + Not a test for “randomness”, but uniformity or independence

#### Disadvantage of empirical tests
+ Only a certain segment of the cycle is examined
  + No information about how generator would perform on other segments of the cycle

### Theoretical tests
Based on generator structure and defining constants

# vocabulary
trajectories: 轨迹  
diagram： 图示  