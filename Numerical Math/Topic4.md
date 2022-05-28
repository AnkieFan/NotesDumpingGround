# Differentiation and Integration

## Approximation:
e.g.: $\int_1^3 xlogx dx$, n=4
1. let $f(x) = xlogx$, a = 1, b = 3, $h = (b-a)/n = 0.5$

**Midpoint Rule**
2. Table of function values $f(x_{i+1/2})$ for i = 0,..., n-1

i|0|1|2|3
---|:---:|:---:|:---:|:---:|
$x_{1+1/2}$|1.25|1.75|2.25|2.75
$f(x_{i+1/2})$|0.2783|0.9783|1.8246|2.7819
    
3. Approximation:
   $M_4(f,1,3) = h(f(x_{1/2})+f(x_{1+1/2})+...+f(x_{n-1/2})) = 0.5 × (0.2783 + 0.9793 + 1.8246 + 2.7819) = 0.5 × 5.8648 = 2.9324$

**Trapezoidal rule**
2. Table of function values $f(x_i)$ for i = 0,..., n
i|0|1|2|3|4
---|:---:|:---:|:---:|:---:|:---:|
$x_i$|1.0|1.5|2|2.5|3.0
$f(x_i)$|0.0000|0.6082|1.3863|2.2907|3.2958
3. Approximation:
   $T_4(f;1,3) = h(1/2f(x_0)+f(x_1)+...+f(x_{n-1})+1/2f(x_n)) =0.5 × (1/2 ×0.0000 + 0.6082 + 1.3863 + 2.2907 + 1/2 ×3.2958) = 0.5 × 5.9333 = 2.9666$

**Simpson’s rule**
2.  Table of function values $f(x_i)$ for i = 0,..., n
   Same with T
3. Approximation:
   $S_4(f;1,3) = 1/3*h(f(x_0)+4f(x_1)+2f(x_2)+4f(x_3)+f(x_4)) = 0.5 ×1/3(0.000000 + 4×0.608197 + 2×1.386294 + 4×2.290727 + 3.295837)= 0.5 × 1/3 × 17.664124 = 0.5 × 5.888041 = 2.944021$
   


