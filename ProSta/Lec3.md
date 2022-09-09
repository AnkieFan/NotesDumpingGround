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

### PMF:
$P(X = x) = \frac{1}{|C|}$
for $x \in C$

