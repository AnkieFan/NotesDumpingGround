# Parameter Estimation



## Method of moments estimator
+ kth moment: $\mu_k = E(X^K)$
+ Sample moment: $\hat{\mu_k} = \frac{1}{n}\sum_{i=1}^n X_i^k$
+ $\hat{\mu_k}$ is an estimate of $\mu_k$

## Likelihood
$f(x_i|\theta)$ x表示某一个具体的数据；θ \thetaθ表示模型的参数
E.g.: coins
10: 反正正正正反正正正反
$f(x_0|\theta) = (1-\theta)*\theta*\theta*\theta*\theta*(1-\theta)*\theta*\theta*\theta*(1-\theta)$
We want to find $\theta$ where $f(x_0|\theta)$ is the max

## Maximum Likelihood Estimate MLE
### Likelihood
Suppose that random variables $X_1,...,X_n$ have a joint density:  
$f(x_1,x_2,...,x_n|\theta)$  
Given observed values $X_i = x_i$, where $i = 1,...,n$, the likelihood of $\theta$ as a function $x_1, x_2,..., x_n$ is defined as:  
$lik(\theta) = f(x_1,x_2,...,x_n|\theta)$  

### MLE
The maximum likelihood estimate of $\theta$ is that value of $\theta$ that maximizes the likelihood.  
That is, makes the observed data "most probable" or "most likely."  
If the $X_i$ are i.i.d., then:
$lik(\theta) = f(x_1,x_2,...,x_n|\theta) = \prod^n_{i=1}f(x_i|\theta)$  
Usually maximize:
$l(\theta) = \sum^n_{i=1}log[f(x_i|\theta)]$

## Optimality
### Consistent estimate
$\hat{\theta}$ converges to $\theta$ as $n \rightarrow \infin$
### Asymptotic variance
The variance of the limiting normal distribution
### Asymptotically efficient
The MLE is consistent, approximately normal, and achieves the smallest asymptotic variance for consistent estimators.

### Bayesian Statistics
+ Unknown parameter $\theta$ is treated as a random variable
+ We assign a prior distribution $f_{\Theta}(\theta)$ to $\theta$
+ Then we use Bayes rule to create the posterior distribution