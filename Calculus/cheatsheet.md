# Calculus Cheatsheet
Exam preparation Suggestion: do all exam level exercises according to this cheatsheet. Do more exercises as much as possible. It's not hard to get 10 in this course. Good luck!

## Announcement:
**THIS IS MY OWN SUMMARY, will not be provided in the exam.**
There may still be small mistakes in this document. Please report them to me if you found any :D Thx!

## Limitations
### Limits, Continuity and Differentiability
At a point $a, f(a)$ which is on the function $f(x)$
+ Limit exists at this point if: $\lim_{x \rightarrow a^+}f(a) = \lim_{x \rightarrow a^-}f(a)$, and this value is the limit at this point
+ Function is continuous at this point if limit exists at this point
+ Function is differentiable if $\lim_{x \rightarrow a^+}f'(a) = \lim_{x \rightarrow a^-}f'(a)$ -> derivative exists

### L'Hôpital's rule
When $\lim \frac{f(x)}{g(x)} = \frac{0}{0}$ or $\frac{\infin}{\infin}$ or $\frac{0}{\infin}$ or $\frac{-\infin}{\infin}$... etc., $\lim \frac{f(x)}{g(x)} = \lim \frac{f'(x)}{g'(x)}$

### Asymptotes
1. Break points: points that function cannot be defined. e.g.: $\frac{1}{x+1}$ break point $x_0 = -1$
2. Vertical Asymptote: break points $x_0$
   + If $\lim_{x \rightarrow x_0} f(x) = \infin$, then f(x) has a vertical asymptote at $x = x_0$
3. Horizontal Asymptote: 
   + If $\lim_{x \rightarrow \infin} f(x) = A$ or $\lim_{x \rightarrow -\infin} f(x) = A$, then $y = A$ is a horizontal asymptote of f(x).
4. Oblique Asymptote:
   + Check if $\lim_{x \rightarrow \infin} \frac{f(x)}{x}$ exists. If it exists with value $a$, then it exists an oblique asymptote.
   + Then find $\lim_{x \rightarrow \infin}\frac{f(x)}{x} - a$. If it exists with value $b$, the oblique asymptote is $y = ax+b$

## Derivative and Integral
### Basic Knowledge
+ Derivative of a function at point $x = x_0$ is the slope of tangent line at this point: $f'(x_0) = k$, tangent line function: $y = kx + b$
+ When a line $y_1 = k_1x + b_1$ is perpendicular/norm to line $y_2 = k_2x + b_2$, $k_1k_2 = -1$

### Calculation Rules
+ Derivative of multiplication: $(UV)' = U'V+V'U$
+ Derivative of faction: $(\frac{U}{V})' = \frac{U'V - V'U}{V^2}$
+ Chain Rules: $y = f(g(x))$, $y' = f'(g(x))g'(x)$
+ Integral by parts: $\int UV' = UV - \int VU'$

### Graph Sketch
+ When $f(x) = 0$, you can find intersection of the function with the x-axis.
+ When $f'(x) > 0$, function increases. When $f'(x) < 0$, function decreases. Function has global maximum/minimum when $f'(x) = 0$.
+ When $f''(x) > 0$, function concaves up. When $f''(x) < 0$, function concaves down.

## Sequences and Series
### Check if $\sum^\infin_1 a_n$ converges or diverges (Multiple choices like quizzes in Tutorial 5)
**Do the first test before any other tests, otherwise the conclusion may be wrong**  
1. Check if $\lim_{n \rightarrow \infin} a_n = 0$: 
   + Diverge if it doesn't exist or not equal to 0
   + Continue to do other tests if it is
2. Check if $a_n$ is a **geometric** sequence, which is if it can be written as $a_n = ar^{n-1}$ (or $a_{n+1} = ra_n$) with a common ratio $r$
   + Converge if common ratio $|r| < 1$
   + Diverge if common ratio $|r| \geq 1$
   + Notice that $a_n = C^n$ is also a geometric sequence with common ratio $r = C$
3. Check if $\sum a_n$ is a [**telescoping serie**](https://en.wikipedia.org/wiki/Telescoping_series)
   + It converges because when expanding it, the front term can be cancelled by the later term
   + E.g.: $\sum \frac{1}{n(n+1)} = \sum(\frac{1}{n} - \frac{1}{n+1}) = 1 - \frac{1}{2} + \frac{1}{2} - \frac{1}{3}+...+\frac{1}{n} - \frac{1}{n+1} = 1 - \frac{1}{n+1}$
4. $\sum a_n = \frac{1}{n!}$ converges.
5. $\sum a_n = \frac{1}{n^p}$ converges if $p > 1$
6. **Comparison Test**:
   + When $a_n \leq b_n$, $\sum a_n$ converges when $\sum b_n$ converges.
   + When $a_n \geq b_n$, $\sum a_n$ diverges when $\sum b_n$ diverges.
   + Trick(also for 7th): try to find a $b_n$ with a form in 1-5
7. **Limit Comparison Test**:
   + If $lim_{n\rightarrow \infin}\frac{a_n}{b_n} = c, 0 < c < \infin$, then $a_n$ and $b_n$ converge converge or diverge at the same time (check one of them).
   + If $lim_{n\rightarrow \infin}\frac{a_n}{b_n} = 0$, then $a_n$ converges if $b_n$ converges
   + If $lim_{n\rightarrow \infin}\frac{a_n}{b_n} = \infin$, then $a_n$ diverges if $b_n$ diverges
8. **Integral Test**:
   + Requirements for Integral Tests: $a_n$ is a positive, and it passed test 1. 
   + Take $a_n$ as a function $f(n)$, $\sum_{n=N}^\infin a_n$ and $\int^\infin_N f(x)$ converge converge or diverge at the same time.
   + Trick: check if $a_n$ can be easily integrated
9. **Ratio Test**: $\lim_{n \rightarrow \infin |\frac{a_{n+1}}{a_n}|} = \rho$
    + Converge if $\rho < 1$
    + Diverge if $\rho > 1$
    + Can't conclude if $\rho = 1$
    + Trick: check if $\frac{a_{n+1}}{a_n}$ is simple, e.g.: $a^n$, $n^a$, $n!$ 
10. **The alternating series test**: given well enough in the formula sheet

## Differential Equations
### Ordinary Differential Equations(ODE):
+ ODE: Differential Equations for one variable function.  
+ First order **linear** ODE(standard form): $y' + p(x)y = f(x)$
  + It is homogenous when $f(x) = 0$
  + if there's anything before y', divide it for all the terms to be back to standard form.
+ Second order **linear** ODE:$y'' + p(x)y' +q(x)y = f(x)$

#### Solving First Order Linear ODE:
$y' + p(x)y = f(x)$  
1. Calculate $u(x) = e^{\int p(x)dx}$. **Don't add** constant C in integral here.
2. Write $(u(x)y)' = u(x)f(x)$
3. Do integral of both sides: $u(x)y = \int u(x)f(x) dx$, constant C **is needed** here. 
4. Put given function value back to get C if needed.
   + If you ask why we do so: we want a $u(x)$ that can finally make $(u(x)y)' = f(x)u(x)$ so we can get y by simply do integration.
   + This means $(u(x)y)' = u(x)y' + u(x)p(x)y = u(x)f(x)$ (middle one is from multiply u(x) in both sides of standard first order linear ODE)
   + Deduct it, you will find $u(x)$ is always what we had above

##### E.g.: $y' - \frac{2}{x}y = x^2$
+ In this case, $p(x) = \frac{-2}{x}, f(x) = x^2$
+ $u(x) = e^{\int p(x)dx} = e^{\int \frac{-2}{x}dx} = \frac{1}{x^2}$
+ $(\frac{1}{x^2}y)' = \frac{1}{x^2}x^2 = 1$
+ Do integral of both sides: $\int(\frac{1}{x^2}y)'dx = \int 1dx$
+ $\frac{1}{x^2}y = \int 1dx = x + C$, $y = x^3+Cx^2$


### Partial Differential Equations(PDE):
#### Partial Derivative:
+ Symbol: $\frac{\partial}{\partial x}$ (first order), $\frac{\partial^2 y}{\partial x^2}$(second order)
+ Method: consider all other variables to be **constants**, and do derivative as normal.
  + E.g.: $f(x,y) = xy + x^2$, then $\frac{\partial}{\partial x} = y + 2x$, $\frac{\partial}{\partial y} = x$
+ Tangent plane formula is given in formula sheet.


#### Integral of PDEs:
+ Find the range of x and y respectfully. And do integral as usual, but from inside to outside, do integral one by one.
+ E.g.: Evaluate the double integral over a triangle T with vertices (0,0), (1,0), (1,1), given $\int \int_T f(x,y) dT$ 
  + Observe and find $0<x<1, 0<y<1$
  + Can be written as $\int_0^1 \int_0^1 f(x,y) dxdy$
  + Calculate $\int_0^1 (\int_0^1 f(x,y) dx)dy$ x part first, then y
 

## Supplementary material
### Rules about log (ln) functions
+ Power rule: $log_b m^n = nlog_b m$
+ Product rule: $log_b (mn)= log_b m + log_b n$
+ Change of Base rule: $log_ab = \frac{log_cb}{log_ca}$
+ $b^{log_bx} = x$ -> $e^{lnx} = x$
+ If $log_ba = log_b c$, then $a = c$