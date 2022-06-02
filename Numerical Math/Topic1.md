# Topic 1 (for the Exam)

## Decimal
+ Significant figures (有效数字)
+ decimal place (小数位数)
+ Scientific notation (科学计数法)
+ tolerance (误差)

## Error
Error computation:
p* is approximation of p

Absolute error: |p∗ − p|∣p∗−p∣
Relative error: |p∗ − p|/|p|∣p∗−p∣/∣p∣

## arithmetic
### rounding arithmetic
e.g: $f(x) = x^3+2x^2+x$ when x = 1.21, 3-digit
$x^3 ≈ 1.772$
$2*x^2 ≈2.928$
$x = 1.210$
$f(x) ≈ 1.772 + 2.928 + 1.210 = 5.91$
+ 可以$x^2 = x*x$ 先按sf要求四舍五入取估值，再用估值计算$x^3 = x^2 * x$，再取估值再计算$x^4 = x^3 * x$， 最后乘系数加起来
+ 也可以直接算 $x^4$， $x^3$，x，然后全部四舍五入到sf要求，再做线性运算

### Single-precision arithmetic (in Matlab)
e.g.: In Matlab:
```
c=[1.00,-5.34,1.52,4.61], x=4.89
fx=polyval(c,x)
sc=single(c), sx=single(x)
sfx=polyval(sc,sx)
es = abs(double(sfx)-fx)/abs(fx)
```

## Solutions of Equations of One Variable
### Quadratic formula 求根公式

### Nested form
e.g.: $f(x) = x^3-5.34x^2+1.52x+4.61 = ((x-5.34)x+1.52)x+4.6$

### The bisection method:
+ idea: Shrink the bracket [a, b] to a point while preserving the bracket property.
+ Method: narrow the bracket but keep the property
  + e.g.: to have [a, c] or [c, b] which $ c = \frac{a+b}{2}$

### The secant method
+ idea: Given approximations p, q to a root of f, approximate f by the line joining (p, f(p)) and (q, f(q))
+ method: **provided on FormulaSheet**
+ Convergence: Want to stop when |pn − p| < ǫ
  + When we dont know exact root: Stop when $|p_n − p_{n−1}| < ǫ$ (Practical stopping heuristic)
+ Error estimate: For $|p_n − p_{n−1}| < ǫ$ : expect $|p_n − p_{n−1}| <≈ ǫ$ 

### Newton-Raphson method
+ idea: use the tangent line at (p, f(p))
+ method: **provided on FormulaSheet**

-----
r |Bisection|Secant|Newton-Raphson
---|:---:|:---:|---
Converge promised?|yes|no|no
Converge speed|linear $ǫ_{n+1} ∼ 1/2ǫ_n$|superlinearly $ǫ_{n+1} ∼ C_{ǫ^{1.6}_n}$|Superlinearly $ǫ_{n+1} ∼ C_ǫ^2$


### Working guidelines
+ Final answer: If not specifically asked for, use the precision appropriate for the
accuracy. 一般保留和精度要求一样的小数位数。
+ Intermediates: Use more precision for intermediate results than needed in final
answer. 计算过程中保留更精确的小数位数。
+ Errors: Use at most two significant figures when giving an error (estimate) 
  + e.g.: Absolute error 0.0013, relative error 0.04%
  

## Note from Exercise 1:
+ It is more accurate to add the smallest terms first. 多步计算的时候先算误差小的，这样能减少整体误差
  e.g.: 1/1+1/4+1/9+....+1/10000  is more accurate than 1/10000+...+1/9+1/4+1/1
+ Secant Method和Newton的converge条件都是 $|p_n-p_{n-1}| < 精度$，和$f(p_n)$没关系
+ Secant method: when given interval's length is large than 1, we can use bisection method first to find a [n,n+1] to speed converge. secant method如果区间长度大于1了可以先用bisection找一个1的区间，再用secant
+ 15：函数有解但secant method 迭代十次内无法收敛：函数太陡，每一次求出的直线和上一次差距过小，变化太慢
