# Basic Knowledge
## i.i.d.
+ Independent: probability of A does not effect probabiliy of B
  + $P(X\leq x,Y\leq y)=P(X\leq x)P(Y\leq y)$ 
+  identically distributed： Events follow the same distribution. 两个事件遵循同样的分布

## Functions
PMF&PDF: $f(c) = P(X = c)$ PMF/PDF's value of c is the probability of c  
CDF: $f(c) = P(X \leq c)$  
PMF: for discrete
PDF: for continuous   
CDF: cumulated posibility  
CDF = PMF/PDF's integral  
PMF/PDF = CDF's derivation  

## Expectation
离散型 For discrete：  
$E(X) = \sum^{\infin}_{j=1} x_j P(X=x_j)$  
$E(X) = \sum^{\infin}_{k=1} x_kp_k$  
连续型 For continuous： 
$E(X) = \int_{-\infin}^{\infin}xf(x)dx$  
### Variance
The variance of an r.v. X is
$Var(X) = E(X - EX)^2$
$Var(X) = E(X^2)-(EX)^2$
### Properties - Linearity of Expectation
$E(X + Y) = E(X) + E(Y)$
$Var(X+Y) = Var(X) + Var(Y) + 2Cov(X,Y)$
$E(cX) = cE(X)$
### Law of the Unconscious Statistician (LOTUS)
$E(g(x)) = \sum_{x} g(x) P(X=x)$
### Joint distribution
Covariance:  
$Cov(X,Y) = E((X-EX)(Y-EY)) = E(XY) - E(X)E(Y)$
Correlation:  
$Corr(X,Y) = \frac{Cov(X,Y)}{\sqrt{Var(X)Var(Y)}}$
### Variance of the Sample Mean
+ sampling with replacemen: $Var(\overline{X}) = \frac{1}{n^2} \sum_{i=1}^nVar(X_i) = \frac{\sigma^2}{n}$
+ sampling without replacement:$Var(\overline{X}) = \frac{\sigma^2}{n}(1-\frac{n-1}{N-1}) \approx \frac{\sigma^2}{n}$ 

## Hypothesis Testing
+ $H_0$ Null hypothesis
+ $H_1$ Alternate hypothesis
+ $H_0 = H_1^c, P(H_0) + P(H_1) = 1$

|Terminology|Meaning|
|---|---|
Type I error|Rejecting $H_0$ when it is true
Significance leve $\alpha$|Probability of a type I error
Type II error|Accepting $H_0$ when it is false
The power of test $1-\beta$|Probability that $H_0$ is rejected when it is false

# Exam questions
## Conditional Probability
1. Find 2 events A and B
2. Find all elements in LOTP
### Baye's rule
$P(A|B) = \frac{P(A \cap B)}{P(B)} = \frac{P(B|A)P(A)}{P(B)}$  
$P(B|A) = \frac{P(A \cap B)}{P(A)}$  
### LOTP
$P(B) = \sum^n_{i=1}P(B|A_i)P(A_i)$  

## Expectation
Use:  
$E(X + Y) = E(X) + E(Y)$
$E(cX) = cE(X)$
#### Bern(p)
$E(X) = p$  
$Var(X) = p(1-p)$  
#### Bin(n,p)
$E(X) = np$   
$Var(X) = np(1-p)$  
#### Pois($\lambda$)
$E(X) = \lambda$   
$Var(X) = \lambda$  
#### Unif(a,b)
$E(X) = \frac{a+b}{2}$  
$Var(X) = \frac{(b-a)^2}{12}$  
#### $N(\mu, \sigma^2)$
$E(X) = \mu$  
$Var(X) = \sigma^2$  

## Continuous Random Variables/Random Variables and Their Distributions
Especially:
$X \sim Bin(n,p)$  
PMF: $P(X = k) = \begin{pmatrix} n \\ k \end{pmatrix} p^k(1-p)^{n-k}$  

## Hypothesis Testing
Likelihood ration for $x_i =  \frac{P(X = x|H_0)}{P(X = x|H_A)}$  

#### $\alpha, 1-\beta$
threshold c
$\alpha = P(reject H_0|H_0) = P(X > c | H_0)$   
$1 - \beta = P(accept H_0|H_1) = P(X \leq c| H_1)$  
#### p-value
For X = c
p-value = $P(X \geq c|H_0)$

## Joint Distributions
### Find valid PDF
PDF: $f_{X,Y}(x,y)$, for $a < x < y < b$  
Valid PDF => CDF from a to b is 1  
$\int_a^b \int_a^y f_{X,Y}(x,y)dxdy = \int_a^b (\int_a^y f_{X,Y}(x,y)dx)dy = 1$
### Marginal PDF 
For x:
$f_X(x) = \int_a^xf_{X,Y}(x,y)dy$
### Conditional PDF
For all x with $f_X(x) >0$
$f_{Y|X}(y|x) = \frac{f_{X,Y}(x,y)}{f_X(x)}$

## Population, Sample, and Confidence Intervals
Confidence intervals: Lower endpoint: $\overline{X}-z(\alpha / 2)$ Upper endpoint: $\overline{X}+z(\alpha / 2)$  

### Fixed parameter
+ Population mean
+ Population total N
+ Population variance
+ The sample size (usually, depends on how to choose a sample)
+ significant level
+ Sample size n
+ The variance of the sample mean
+ The estimated variance of the sample mean

### Random variables
+ Sample mean $\overline{X}$
+ The largest value in the sample
+ The interval end points 

## Parameter Estimation (MLE)
1. Find $f(x_i|\theta)$  
   e.g.: n coins, S are Head, n-S are tails
   $f(x_i|\theta) = (p*p*p...p)((1-p)(1-p)...) = p^S(1-p)^{n-S}$
2. log-likehood:  
   e.g.: $f(x_0|\theta) = p^S(1-p)^{n-S}$
   $l_n(p) = log(p^S(1-p)^{n-S}) = log(p^S) + log((1-p)^{n-S}) = S\log{p} + (n-S)\log {(1-p)}$
3. Find maximum value (derivative = 0)  
   $l_n'(p) = S/p - \frac{n-S}{1-p} = 0$
4. Find p:
   $p = \frac{S}{n}$
5. The MLE is $\hat{p} = \frac{S}{n}$

