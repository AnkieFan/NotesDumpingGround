# Topic 1

## Decimal
+ Significant figures (有效数字)
+ decimal place (小数位数)
+ Scientific notation (科学计数法)

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
$x = $ 



## From Exercise 1:
+ It is more accurate to add the smallest terms first.
  e.g.: 1/1+1/4+1/9+....+1/10000  is more accurate than 1/10000+...+1/9+1/4+1/1
+ 