# Random Variables and Their Distributions

## Notations
$P(X = x)$ where X = x denotes
Formally, $\{X = x\} = \{s \in S: X(s) = x\}$

+ $s$ outcome
+ $S$ sample space
+ $X$ random variable
+ $x$ value of the real line
+ {...} subset of the sample space, thus an event

### Example: coin tosses
$S = \{HH, HT, TH, TT\}$

## Probability mass function
+ 描述离散型随机变量在各特定取值上的概率
+ 在某一区间上的积分来刻画随机变量落在这个区间中的概率
+ Define a distribution of a random variable
$p_X (x) = P (X = x)$
Note that this is positive if x is in the support of X , and 0 otherwise.

## Bernoulli distribution
An r.v. $X$ is said to have the Bernoulli distribution with parameter $p$ if:
$P(X = 1) = p$
$P(X = 0) = 1 - p$
where $0<p<1$, we write this as:
$X ~ Bern(p)$
The symbol ~ is read as "**is distributed as**".

## Binomial distribution
Suppose that n independent Bernoulli trials are performed, each with the same success probability $p$. Let X be the number of successes. The distribution of $X$ is called the **Binomial distribution** with parameters $n$ and $p$. We write
$X ∼Bin(n,p)$
to mean that $X$ has the Binomial distribution with parameters n and $p$, where $n$ is a positive integer and $0 <p <1$.

### Binomial PMF
If $X ∼ Bin(n,p)$, the the PMF of X is
$P(X = k) = \begin{pmatrix} n \\ k \end{pmatrix} p^k(1-p)^{n-k}$
for $k = 0,1, ..., n$ (and $P (X = k ) = 0$ otherwise)

## Discrete Uniform distribution
$C$ is a finite, nonempty set of numbers. CHoose one number from C randomly and uniformly $X$.
$X ∼DUnif(C)$

#### PMF:
$P(X = x) = \frac{1}{|C|}$
for $x \in C$

## Cumulative Distribution Functions
CDF: 是概率密度函数的积分，能完整描述一个实随机变量X的概率分布。
CDF的定义是：$F_{X}\left( x\right) =P_{r}(X \leq x)$  

### 函数式
连续型随机变量：$F_{X}\left( x\right) =P_{r}(X \leq x)=\int ^{x}_{-\infty }f_{X}\left( t\right) dt$
离散型随机变量，CDF是阶梯状的分段函数，以掷硬币为例\[F_{X}\left( x\right) =P_{r}(X \leq x)=\begin{cases}0 \ if \ x<0\\ \dfrac {1}{2}\ if \ 0\leq x<1\\ 1\ if \ x\geq 1\end{cases}\]

### Theorem
另外CDF的单调递增（不减）性质可以由它的定义和概率的性质推出: 对任意$x_1 < x_2$，总有 $P_{r}(X \leq x_1)\leq P_{r}(X \leq x_2)$,所以$F_{X}\left( x_1\right)\leq F_{X}\left( x_2\right)$

### Independence of two r.v.s
Random variables X and Y are said to be independent if
$P(X\leq x,Y\leq y)=P(X\leq x)P(Y\leq y)$
+ 独立 independent：两个事件发生互不影响对方发生的概率
+ 同分布 identically distributed：两个事件遵循同样的分布
+ i.i.d.: independent and identically distributed
