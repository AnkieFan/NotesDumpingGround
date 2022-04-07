# Computer Arithmetic

## Computer arithmetic
+ Float numbers has small error

### Numbers and representations
+ Integer: decimal "42", binary $"101010_2"$
+ Real numbers: uncountable

### Decimal expansions of real numbers
+ Rational number: have *terminating* or *recurring* decimal expansions
  + Some numbers have 2 ***different*** but ***equal*** representations: 0.25 == 0.250000... == 0.24999999...
+ Irrational: $e$
+ Uncomputable: there's *no finite* description of the decimal expansion
+ Approximation 近似值
+ Decimal places: $pi$ = 3.14159 *(5 dp)*
  + Round ties away from zero 四舍五入

### Significant figures (有效数字)
+ α = 0.007 297 352 57 (11dp,9sf)
+ Zero: 0 has no significant figures!
+ Units: The number of significant figures is independent of the unit used.
  + e.g.: The density of gold is 19.32 g cm^−3 (4sf,2dp) = 19320 kg m^−3 (4sf)
  
### Scientific notation (科学计数法)
+ Scientific NotationWrite a number as a value $±m × 10^e$
where $1 ≤ *m* < 10$ and *e* is an integer.
+ Mantissa: m
+ exponent: e
+ The length of the mantissa is the number of significant figures.


## Digital representations
+ Memory: electromagnetic switches, capable of storing values ↑ or ↓
+ Hardware: works most efficiently with *fixed-width* data types
+ Software: infinite data types

### Binary Integers
+ Binary: Represent 0 by ↓ and 1 by ↑
+ Fixed-width: fixed number of digits
  + e.g.: Java: 32-bit -2^31 to 2 ^ 31 +1
+ Variable-width

### Fixed- and floating-point numbers
+ Fixed-point: uses a fixed number of fractional (binary) digits
+ Floating-point: Use a fixed number of *significant* digits in the *mantissa*, and
determine the size by the *exponent*
  + Single-precision: IEEE standard, 32-bit floating-point format
  + Double-precision: 64-bit ***(Matlab uses this by default)***
+ Dyadic: Any binary fixed- or floating- point number is a dyadic of the form p/2^q for integers p,q.

### Floating-point arithmetic
+ Inexact
+ Round-to-Nearest
+ Directed

### Machine epsilon
The difference between 1 and the next higher representable number
+ Spacing: Over the interval [1, 2], numbers have a spacing of ǫ
+ Max/min representable number: for double-precision floating-point: 
  + min strictly-positive representable number is 0+ = 2^-1074 ≈ 4.94 x 10^-324
  + max representable number: ∞^- = 2^1023(2-ǫ) = 2^1024 (1-ǫ/2) ≈ 1.798 x 10^308

---------
## Errors in Scientific Computing

### Sources of error
+ Roundoff errors: Errors due to the use of inexact (floating-point) arithmetic for computations
  + usually small for simple double-precision calculation
+ Truncation errors: Errors due to the use of an inexact method
  + e.g.: the approximation f′(x) ≈ (f(x + h) − f(x − h))/2h has a trunctation error O(h^2).
+ Errors in data

### Error computation:  
p* is approximation of p
+ Absolute error: $|p∗ − p|$
+ Relative error: $|p∗ − p|/|p|$
***Error Computation:*** use an *unrounded* version of the exact value, or a version rounded to much *higher* precision than your approximation. i.e.: 用更精确的估算值来作为精确值进行计算。

### Error estimates and bounds
+ Exact error: we cannot know the exact value -> use numerical method
+ Error estimates: a value -> |p∗ − p| ≈ e˜
+ Error bounds: a value -> |p∗ − p| ≤ e¯

### Error specificatio
+ Decimal place: requestiong an answer to n **decimal places** corresponds to an **absolute** error of 10^-n
+ Significant figures: requestiong an answer to n **significant figures** corresponds to an **relative** error of 10^-n
+ Error specification: better to request a given number of significant figures

### Rounded arithmetic
Floating-point will be rounded to the nearest representable number. 
-> **Decimal rounded arithmetic**: these small errors will accumulate
+ e.g.: Let $f(x) =x^3 − 5.34x^2 + 1.52x + 4.61$. Evaluate f at 4.89 using 3-digit rounded arithmetic
  + f(4.89) = 1.282355 = 1.28 (3 sf)
  + Relative error: 19% Re;ative error each step: 0.1%

### Fixed-point versus floating-point
+ Fixed-point: 
  + \+ & - are ***exact***
  + Multiplication of small numbers behaves poorly
+ Floating-point:
  + multiplication and division: small relative errors
  + subtraction of almost-equal  numbers causes loss of percision 

### Accuracy and precision
+ Accuracy (准确性) 
+ Precision (精度)
+ e.g.: 3.1428571 compared with 3.141592    
  + accuracy: 3
  + precision: 8

### Working guidelines
+ Final answer: If not specifically asked for, use the precision appropriate for the
accuracy. 一般保留和精度要求一样的小数位数。
+ Intermediates: Use more precision for intermediate results than needed in final
answer. 计算过程中保留更精确的小数位数。
+ Errors: Use at most two significant figues when giving an error (estimate) 
  + e.g.: Absolute error 0.0013, relative error 0.04%


## Reducing Errors in Scientific Computing

### substraction
+ Loss of significance: 2 almost-equal quantities in rounded for floating-point arthmetic
  + e.g.: Compute $x^3 − y^3$ using three-digit arithmetic for x = 427, y = 42
  + $x^3 − y^3 = 77854483 − 77308776 (3 sf) ≈ 77900000 − 77300000 = 600000 (3 sf)$.
  + Exact answer 545707. High relative error of 9.9
  + Solution: Re-write $x^3 − y^3 = (x − y) × (x^2 + xy + y^2)$
+ Safe subtraction: Subtraction of *exact* values at the *first step* is safe (no chance to accumulate errors)
  
### Quadratic formula 求根公式

### Polynomials in Horner nested form
$f(x) = x^3 - 5.34x^2 + 1.52x + 4.61$ --> $f(x) = ((x - 5.34)x + 1.52) + 4.61$
(Horner's rule)

### Quality of methods
A good method for a problem will always give an accurate answer, regardless of
the input.
e.g.: Horner's method does not always give a more accurate result than direct evaluation, does not have as bad a worst-case.