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

### Midpoint method
+ Estimate $y(t+ \frac{h}{2})$ by Euler’s method
  + $y(t+ \frac{h}{2} ) ≈ y(t)+ \frac{h}{2} f(t, y(t))$
+ Then: $ y(t + h) ≈ y(t) + hf(t+\frac{h}{2}, y(t) + \frac{h}{2}f(t, y(t)))$
+ Obtain midpoint method:
$w_{i+1} = w_i + h_if(t_i+ 1/2 \cdot h_i, w_i+ 1/2 \cdot h_i \cdot f(t_i, w_i)$