# Mock Exam
### Q1:
#### 1a. For $f(x)$ and $g(x)$ differentiable functions, let $f(1) = 1, f (−2) = −2, f'(1) = −3, f'(−2) = 3, g(1) = −2$ and $g'(1) = 1$. Find $\lim_{x \rightarrow 1} \frac{f(g(2-x))-g(f(x^2))}{x-1}$
1. Observe that denominator is 0, which means there is a high probability that this question will require L'Hôpital's rule. Check numerator when x = 1: $f(g(2-1))-g(f(1^2)) = f(g(1)) - g(f(1)) = 0$
2. No we are finding $\lim \frac{0}{0}$. Use L'Hôpital's rule
   1. Derivative of numerator (using Chain Rule twice): $(f(g(1)))' - (g(f(1)))' = -g'(1)f'(g(1)) +(2*1)f'(1)g'(f(1)) = 3$
   2. Derivative of denominator: $(x-1)' = 1$
   3. $3/1 = 3$

#### 1b. Calculate $lim_{x \rightarrow 0^-}\frac{x}{\sqrt{x^2-x}}$
1. Denominator: $\sqrt{x^2-x} = |x|\sqrt{1-\frac{1}{x}}$. Since $x<0$, it becomes $-x\sqrt{1-\frac{1}{x}}$
2. $lim_{x \rightarrow 0^-}\frac{x}{\sqrt{x^2-x}} = lim_{x \rightarrow 0^-}\frac{x}{-x\sqrt{1-\frac{1}{x}}} = lim_{x \rightarrow 0^-}\frac{-1}{\sqrt{1-1/x}} = \frac{-1}{\sqrt{1+\infin}} = 0$

#### 1c. Calculate $\int^1_0 xln(x)dx$
+ Integral by parts: $U = ln(x), U' = \frac{1}{x}, V' = x, V = \frac{x^2}{2}$
+ $\int UV' = UV - \int VU'= \frac{x^2ln(x)}{2} - \int\frac{x^2}{2x}dx = \frac{x^2ln(x)}{2} - \frac{x^2}{4}$
+ Put 0 and 1 in. Result is $\frac{-1}{4}$

### 2.
Horizontal: y = 0 (when $x \rightarrow \infin$), $y = \frac{-2}{3}$ (when $x \rightarrow \infin$)

...
Too tired to type here. Will do step by step on exam preparation session.