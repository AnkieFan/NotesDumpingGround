# Tutorial 1:
### 1. Polynomial calculation 多项式计算：
e.g.: $p(x) = 3x^4+2x^3+x$
+ 可以$x^2 = x*x$ 先按sf要求四舍五入取估值，再用估值计算$x^3 = x^2 * x$，再取估值再计算$x^4 = x^3 * x$， 最后乘系数加起来
+ 也可以直接算 $x^4$， $x^3$，x，然后全部四舍五入到sf要求，再做线性运算

### 2. Error calculation:
p* is approximation of p 
**p 是精确答案**
+ Absolute error: $|p∗ − p|$
+ Relative error: $|p∗ − p|/|p|$
+ 题目没有要求的时候留两位sf

-----
# Topic 2

## Initial-value problem:
Find a function y : [t0, tf ] → R satisfying
        $dy/dt = f(t,y), y(t_0) = y_0$
+ Numerical solution: approximate y at each points $t_i: y(t_i) ≈ w_i, i = 0,1, ..., N$
+ step size: $h_i = t_{i+1} - t_i$
+ ordinary differential equation (ODE) 常微分方程
  
## Taylor Methods

### Euler's method
+ First-order approximation
+ Euler's method: Compute w$_i ≈ y(t_i) by w_0 = y(t_0)$ and
  + $w_{i+1} = w_i + h_i \cdot f(t_i, w_i)$
  + where $h_i$ is step size
+ Error estimate
+ Growth of global errors:
+ Second-order Taylor method

## Runge-Kutta Method

### Basic Idea:
For function $ y=y(x) $, $y_n = y(x_n)$:
$$y(x_{n+1}) = y(x_n) + hf'(ϵ), x_n < ϵ < x_{n+1}$$
From $y'(x_n) = f(x_n,y_n)$:
$$y(x_{n+1}) = y (x_n) + hf(ϵ, y(ϵ))$$
$f(ϵ, y(ϵ)$ is the slope $k^*$ in range $(x_n, x_{n+1})$

---------
In Euler's method: take slope ib $x_n$, which is $k_1$ as $k^*$.
Proved Euler's method: Midpoint
+ Estimate $y(t+ \frac{h}{2})$ by Euler’s method
  + $y(t+ \frac{h}{2} ) ≈ y(t)+ \frac{h}{2} f(t, y(t))$
+ Then: $ y(t + h) ≈ y(t) + hf(t+\frac{h}{2}, y(t) + \frac{h}{2}f(t, y(t)))$
+ Obtain midpoint method:
$w_{i+1} = w_i + h_if(t_i+ 1/2 \cdot h_i, w_i+ 1/2 \cdot h_i \cdot f(t_i, w_i)$

-----
### Second-order Runge-Kutta method
Choose another point $p$ in range $[x_n,x_{n+1}]$ except $x_n$:
$$ x_{n+p} = x_n + ph, 0<p≤1$$
Take **weighted average** $k°$ of $k_1, k_2$, which are the slopes of $x_n, x_{n+p}$, i.e.:
$$ k° = (1-λ)k_1 + λk_2$$ 
+ λ is weight
So we have:
$$ y_{n+1} = y_n + h[(1-λ)k_1 + λk_2]\quad(1a)$$
Inside:
$$ k_1 = f(x_n,y_n) \quad (1b)  $$
$$ k_2 = f(x_{n+p},y_n +phk_1)\quad(1c)$$
(1) is second-order Runge-Kutta method. p and λ are undecided constant. We found when λp = 1/2, the precious is the best.
+ Euler's format: λ = 1/2, p = 1
+ Heun's format: λ = 3/4, p = 2/3
+ Midpoiny: λ = 1, p = 1/2

-----
### Classical fourth-order Runge-Kutta method
Choose 3 points in range $[x_n,x_{n+1}]$:
> $ y_{n+1} = y_n + \frac{h}{6}(k_1+2k_2+2k_3+k_4)$
> $k_1 = f(x_n,y_n)$
> $k_2 = f(x_{n+1/2},y_n + \frac{h}{2}k_1)$
> $k_3 = f(x_{n+1/2},y_n + \frac{h}{2}k_2)$
> $k_4 = f(x_{n+1},y_n + hk_3)$