# Moments

## Mean and Median
We say that $c$ is a median of a random variable X if $P(X\leq c) \geq 1/2$ and $P(X \geq c) \geq 1/2$.  

### Theorem
Let X be an r.v. with mean $\mu$, and let $m$ be a median of X.  
+ The value of c that minimizes the mean squared error $E(X-c)^2$ is $c=\mu$  
+ A value of c that minimizes the mean absolute error $E(X-c)^2$ is $c = m$   

## Kinds of moments
Let X be an r.v. with mean $\mu$ and variance $\sigma^2$. For any positive integer n,
+ The $n$th moment of X is $E(X^n)$  
+ the $n$th central moment is $E((X-\mu)^n)$  
+ the $n$th standardized moment is $E((\frac{X-\mu}{\sigma})^n)$  

1st moment: E  
2nd moment: Var  
3rd moment: skewness (asymmetry)  
4th moment: kurtosis (tails)  

## Moment generating function MGF
$M(t) = E(e^{tX})$   
as a function of t, if this is finite on some open interval (-a,a) containing 0.  
Otherwise we say the MGF of X does not exist.  

#### E.g.: Bernoulli MGF
$M(t) = E(e^{tX}) = e^{t_1}P(X = 1) + e^{t_0}P(X = 0) = e^tp+q$   

### Moments via derivatives of the MGF
！！ 第n个矩是MGF的第n个导数
Given the MGF of X, we can get the $n$th moment of X by evaluating the $n$th derivative of the MGF at 0:  
$E(X^n) = M^{(n)}(0)$  

### Theorems
#### MGF determines the distribution
The MGF of a random variable determines its distribution: **if two r.v.s have the same MGF, they must have the same distribution**. In fact, if there is even a tiny interval (-a,a)containing 0 on which the MGFs are equal, then the r.v.s must have the samedistribution.
#### MGF of a sum of independent r.v.s
If X and Y are independent, then the MGF of X+Y is the product of the individual MGFs:  
$M_{X+Y}(t) = M_X(t)M_Y(t)$  
#### Sum of independent Normals
If we have $X_1 \sim N(μ_1,\sigma^2_1)$ and $X_2 \sim N(μ_2,\sigma^2_2)$ independently,   then the MGF of $X_1 +X_2$ is:  
$M_{X_1+X_2}(t) = M_{X_1}(t)M_{X_2}(t) = e^{\mu_1 t + 1/2 \sigma^2_1t^2}·e^{\mu_2 t + 1/2 \sigma^2_2t^2} = e^{(\mu_1+\mu_2)t + 1/2(\sigma_1^2 + \sigma_2^2)t^2}$  
By pattern matching, $N(\mu_1+\mu_2, \sigma_1^2+\sigma_2^2)$  