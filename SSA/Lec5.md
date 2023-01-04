# Empirical tests of hypothesis
+ Data: X
+ Null-hypothesis: $H_0$
+ Test statistic: T
+ Significance level: $\alpha$
+ Critical Value: c

## Chi square test (𝝌𝟐-test)
+ Test statistic:
  + $\chi^2 = \sum^k_{j=1}\frac{(N_j-np_j)^2}{np_j}$
  + in which $n = \sum^k_{j=1}N_j$
+ All parameters known:
  + k-1 degrees of freedom **(dof)**
  + m parameters estimated from data: 
    + k-1-m degrees of freedom
+ Steps:
  1. calculate $\chi^2$ (实际数据-原数据)除以原数据 求和
  2. Find critical value with this degree of freedom $(c_{1-a})$
  3. $\chi ^ 2 < c_{1−\alpha}$: No reason to reject

## Kolmogorov-Smirnov test (KS test)
+ Test statistic:
  + $D_n = sup|F_n(x) - \hat{F}(x)|$
    + 经验分布函数与目标分布的累积分布函数的最大差值
  + $F_n(x)$: Empirical distribution
  + $\hat{F}(x)$: Hypothesized distribution


# Tests specific for independence
## Poker test:
+ Tests independence of random numbers
  + Step 1: construct $y_k = [10*u_k]$
  + Step 2: Group per 5 observations $(y_{5j},y_{5j+1},y_{5j+2},y_{5j+3},y_{5j+4})$
  + Step 3: Count occurrences of patterns in table
### runs tests
+ Run: a sequence of consecutive observations  
  - above the mean (denoted by $a$)
  - below the mean (denoted by $b$)
- Under ℋ0, the total number of runs(denoted by 𝑟) becomes approx. normally distributed (if 𝑎𝑎 > 20 or b > 20) with
  - $\mu_r = \frac{2ab}{n}+0.5$
  - $\sigma^2_r = \frac{2ab(2ab-n)}{n^2(n-1)}$
- Test static: $R = \frac{r-\mu_r}{\sqrt{\sigma^2_r}}$
- Region of accept