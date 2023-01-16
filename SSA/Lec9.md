# Comparing multiple system configurations

## Comparing Two System Configurations
### Paired-t confidence interval
- $n_1$ observations from system 1, $n_2$ observations from system 2, assume here that $n = n_1 = n_2$
- Pair $X_{1j}$ and $X_{2j}$ to $Z_j = x_{1j} - X_{2j}$, where $X_{bj}$ is the mean of the $j^{th}$ run of system b
- Approximate $100(1-\alpha)$ confidence interval given by:
  - $\overline{Z}(n) \pm t_{1-\frac{a}{2}, n-1}\sqrt{\hat{Var}[\overline{Z}(n)]}$
  - $Var[\overline{Z}(n)] = \frac{Var[Z_j]}{n} = \frac{Var[X_{1j}]+Var[X_{2j}]-2Cov[X_{1j},X_{2j}]}{n}$
  - $\hat{Var}[\overline{Z}(n)] = \frac{\sum^n_{j=1}[Z_j-\overline{Z}(n)]^2}{n(n-1)}$
#### Alternative
+ $H_0$: No difference in means, $\mu_1 = \mu_2$, hence $\mu_Z = 0$
+ $t = \frac{\overline{Z}(n)}{\sqrt{Var(\overline{Z}(n))}}$
  + 两样本：$t = \frac{(\overline{x} - \overline{y})}{\sqrt{\frac{S_1^2}{n_1}+\frac{S_2^2}{n_2}}}$
+ Find the alpha for which $t_{1-\frac{\alpha}{2},n-1}$ matches the absolute value of your test statistic. This is the p-value

## Multiple Measures of Performance
+ Bonferroni inequality
  + Gievn by $P(\mu_s \in I_s \forall s = 1,2,...,k) \geq 1-\sum^k_{s=1}a_s$
  + States the probability that all k confidence intervals simultaneously contain their respective true measures
  + If k is small (fewer than 10) practical solution may be used

## Ranking and Selection
Goal: select one of the k systems as 
being the best one

+ Correct selection (CS)
  + can never be absolutely sure of making cs
  + Specify a probability of CS
  + Procedure involves two-stage sampling from each of the k systems

### Dudewicz and Dalal procedure
+ Use weighted sample means from the k systems
+ Assumes independence across runs and between systems
+ Assume $X_{ij}$ normally distributed

#### Procedure
+ We want $P(CS) \geq p*$ provided that $\mu_{i_2} - \mu_{i_1} \geq d*$ (minimal difference of interest of best and second best system)
+ Expected response no longer than $\mu_{i_1} + d*$ with $p*$
+ 