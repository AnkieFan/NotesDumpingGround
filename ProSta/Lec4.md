# Expectation
离散型：  
$E(x) = \sum^{\infin}_{j=1} x_j P(X=x_j)$  
$E(X) = \sum^{\infin}_{k=1} x_kp_k$  
连续型：  
$E(X) = \int_{-\infin}^{\infin}xf(x)dx$  

### Example: Bernoulli r.v.
Let $X \sim Bern(p)$ and $q = 1-p$  
$E(x) = x_1P(X = x_1) + x_2P(X=x_2)= 1p+0q = p$  

## Linearity of Expectation
$E(X + Y) = E(X) + E(Y)$  
$E(cX) = cE(X)$  

## Law of the Unconscious Statistician (LOTUS)
If X is a discrete r.v. and g is a function from R to R, then   
$E(g(x)) = \sum_{x} g(x) P(X=x)$  

# Variance
The variance of an r.v. X is  
$Var(X) = E(X - EX)^2$  
$Var(X) = E(X^2)-(EX)^2$  
The square root of the variance is called the standard deviation (SD):  
$SD(X) = \sqrt{Var(X)}$   

# Poisson
二项分布的极限情况（试验次数无穷大）
An r.v. X has the Poisson distribution with parameter $\lambda$, where $\lambda > 0$, if the PMF of X is:  
$P(X = k) = \frac{e^{-\lambda}\lambda^k}{k!}, k = 0,1,2,...$  
We write $X \sim Pois(\lambda)$  

## Expectation:
$E(X) = \sum^\infin_{k=0} k·\frac{e^{-\lambda}\lambda^k}{k!} \\ = \sum^\infin_{k=1} \frac{e^{-\lambda}\lambda^k}{(k-1)!} \\ = \lambda e^{-\lambda}\sum^\infin_{k=1}\frac{\lambda^{k-1}}{(k-1)!} \\ = \lambda e^{-\lambda}\sum^\infin_{j=0}\frac{\lambda^{j}}{(j)!} \\ = \lambda e^{-\lambda}·e^{\lambda} \\ = \lambda$  
$Var(X) = E(X^2) - (EX)^2 = \lambda + \lambda^2-\lambda^2 = \lambda$  

## Poisson paradigm
Let $A_1,..., A_n$ be events with $p_j = P(A_j)$, where n is large, the $p_j$ are small, and the $A_j$ are independent or weekly dependent. Let:  
$X = \sum^n_{j=1}I(A_j)$  
I: indicator functions:  
$I(A_j) = 0$ if $A_j$ didn't occur  
$I(A_j) = 0$ if $A_j$ occured  

Count how many of the $A_j$  ocur. Then X is approximately distributed as $Pois(\lambda)$, with $\lambda = \sum^n_{j=1}p_j$  

## Theorem
### Poisson given a sum of Poissons
If $X \sim Pois(\lambda_1), Y \sim Pois(\lambda_2)$, and X is independent of Y , then the conditional distribution of X given $X + Y =n$ is $Bin(n,\lambda_1/(\lambda_1+\lambda_2))$.

### Poisson approximation to Binomial
If $X \sim Bin(n,p)$ and we let $n \rightarrow \infin$ and $p \rightarrow 0$ such that $\lambda = np$ remains fixed, then the PMF of X converges to the $Pois(\lambda)$ PMF. More generally, the same conclusion holds if $n \rightarrow \infin$ and $p \rightarrow 0$ in such a way that np converges to a constant $\lambda$.  