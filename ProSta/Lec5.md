# Probability Density Functions
概率密度函数：描述连续型随机变量
For a continuous r.v. X with CDF F , the probability density function (PDF) of X is
the derivative f of the CDF, given by $f(x)=F'(x)$. The support of X , and of its  distribution, is the set of all x where $f (x )>0$.  
PDF求积分得CDF, CDF求导得PDF  

## Valid PDFs
The PDF f of a continuous r.v. must satisfy the following two criteria:
Nonnegative: $f(x) \geq 0$  
Integrates to 1: $\int^\infin_{-\infin}f(x)dx = 1$  

## Expectation
$E(X) = \int^{\infin}_{-\infin}xf(x)dx$  
$E(g(X)) = \int^{\infin}_{-\infin} g(x)f(x)dx$  

# Uniform distribution 均匀分布
在某一区间上均匀分布
A continuous r.v. U is said to have the Uniform distribution on the interval $(a,b)$ if its  
PDF is  
$$
\begin{equation}
f(x) = 
\begin{cases}
\frac{1}{b-1}& \text{if a<x<b}\\
0& \text{otherwise}
\end{cases}
\end{equation}
$$
We denote this by $U \sim Unif(a,b)$  
![](img/5.1.png)

### Theorem (Universality of the Uniform)
1. Let $U \sim Unif(0,1)$ and $X = F^{-1}(U)$. Then X is an r.v. with CDF F.  
2. Let X be an r.v. with CDF F. Then $F(x) \sim Unif(0,1)$.  

## Normal

### Standard Normal distribution
$Z \sim N(0,1)$  
#### PDF:
$\phi(z) = \frac{1}{\sqrt{2\pi}}e^{-z^2/2}, -\infin < z < \infin$  
#### CDF:
$\Phi(z) = \int^z_{-\infin}\phi(t)dt = \int^z_{-\infin}\frac{1}{\sqrt{2\pi}}e^{-z^2/2}dt$  
#### Properties:
+ $\phi$ is a valid PDF by proving that $\int^z_{-\infin}e^{-z^2/2}dt = \sqrt{2\pi}$. 
  + Also means: $\Phi(z) = 1$  
+ $E(Z) = 0$  
+ $Var(Z) = 1$  

### Normal distribution
If $Z \sim N(0,1)$, then $X = \mu + \sigma Z$
is said to have the Normal distribution with mean $\mu$ and variance $\sigma$, for any real $\mu$ and $\sigma^2$ with $\sigma >0$. We denote this by $X \sim N (\mu,\sigma^2)$.  

#### Properties:
$E(\mu+\sigma Z) = E(\mu) + \sigma E(Z) = \mu$  
$Var(\mu + \sigma Z) = Var(\sigma Z) = \sigma^2Var(Z) = \sigma^2$  