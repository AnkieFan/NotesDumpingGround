# Solutions of Equations of One Variable

## The bisection method:
+ idea: Shrink the bracket [a, b] to a point while preserving the bracket property.
+ Method: narraw the bracket but keep the property
  + e.g.: to have [a, c] or [c, b] which $ c = \frac{a+b}{2}$

## The secant method
+ idea: Given approximations p, q to a root of f, approximate f by the line joining (p, f(p)) and (q, f(q))

## Newton-Raphson method
+ idea: use the tangent line at (p, f(p))

r |Bisection|Secant|Newton-Raphson
---|:---:|:---:|---
Converge promised?|yes|no|no
Converge speed|linear $ǫ_{n+1} ∼ 1/2ǫ_n$|

