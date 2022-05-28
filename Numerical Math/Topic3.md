# Polynomial Interpolation

All the needed formulas are in the formula sheet.

## Polynomial interpolation in Matlab
+ Computing polynomials
    `cs=polyfit(xs,ys,d)`
    cs is a row vector of the coefficients of p in descending order: $cs = [c_d,c_{d-1},...,c_1,c_0]$
+ Evaluating polynomials To evaluate the polynomial with coefficients cs at x, use
  `polyval(cs,x)`
  + The result: $c_0 + c_1x+c_2x^2+...$
+ Polynomial function To construct a function p with the coefficients, use
  `p = @(x) polyval(cs,x)`

## From exercise 3:
In calculating error bound: 
+ given points: $x_0,x_1,x_2,...,x_n$ n is number-1, which is also 'n' in error bound formula.
+ $f^{(4)}(x)$ is $f'''(x)$

