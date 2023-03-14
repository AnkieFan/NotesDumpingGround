# Z Transform (Chapter 4.3)
Transfer function and impulse response representations of **discrete-time** linear systems  
[]: discrete (): continuous

## Notations
+ input/output: sampling (because time is always continuous)
+ $f_s$: sampling frequency
+ $T_s = \frac{1}{f_s}$: sampling time
+ k-th sample: $t_k = t_0+kT_s = t_0 + \frac{k}{f_S}$
+ input: $u[k] = u(t_k) = u(t_0+kT_s)$

## Differential equations of discrete time systems
$y[k+n] + a_1y[k+n-1] + ... + a_ny[k] = b_0u[k+n] + b_1u[k+n-1]+...+b_nu[k]$   
==>  
$y[k+n] = -a_1y[k+n-1] - ... - a_ny[k] + b_0u[k+n] + b_1u[k+n-1]+...+b_nu[k]$  
 
## Z_transfer function
$(1+a_1z^{-1} + a_2z^{-2} +...+a_nz^{-n})Y(z) = (b_0 + b_1z^{-1}+b_2z^{-2}+...+b_nz^{-n})U(z)$  
$\{h(k)\}$: impulse response sequence
### discrete-time transfer function
$H(z) = \frac{b_0 + b_1z^{-1}+b_2z^{-2}+...+b_nz^{-n}}{1+a_1z^{-1} + a_2z^{-2} +...+a_nz^{-n}} = \frac{b_0z^n+b_1z^{n-1}+...+b_n}{z^n+a_1z^{n-1}+...+a_n}$

#### Example (exercise 9.2):
Differential equation: $y[k]+y[k-1]-12y[k-2]=2u[k]-u[k-2]$  
Transfer function: $H(z) = \frac{2z^2-1}{z^2+z-12}$

## Causality
+ causal(the output does not anticipate the input): $h[k] = 0$ for all $k<0$ 
+ strictly causal: ↑ + $h[0] = 0$
  + the output does not anticipate the input and there is even no instantaneous effect (no direct feed-through) from the input to the output
+ For difference equations: causality is a built-in property.
  + he degree n of the denominator of H(z) is at least as large as the degree of the numerator polynomial

## partial fraction expansion (PFE)
### PFE without repeated poles
$p_i$: poles  
E.g.: $H(z) = A_0 + \frac{zA_1}{z-p_1} + \frac{zA_2}{z-p_2}$  
$A_0 = H(z)|_{z=0}$  
$A_1 = \frac{numerator}{(z+b_2)z}|_{z = p_1}$  
$A_2 = \frac{numerator}{(z+b_1)z}|_{z = p_2}$  
**Remember to divide *z* in calculating $A_n$**  

### PFE with repeated poles ($(z-p_i)^k$ appear in nume)
Same with Laplaze transform, but remember to **divide z**  
E.g. exercise 11.4:  
$H(z) = \frac{z^2+3}{z^2-z+1/4} = \frac{z^2+3}{(z-1/2)^2}$  
1. $H(s) = A_0 +\frac{zB_{1,1}}{z-1/2}+\frac{zB_{1,2}}{(z-1/2)^2}$   
2. $A_0 = H(0) = 12$
3. $B_{1,2} = \frac{H(z)(z-1/2)^2}{z} = \frac{z^2+3}{z}|_{z=1/2} = \frac{13}{2}$ (same with PFE without repeated poles)
4. $B_{1,1} = (\frac{(z+1/2)^2H(z)}{z})' = \frac{(2z^2-(z^2+3))}{z^2}|_{z = -1/2} = -11$   
   + Multiply the highest degree, and then find the derivative