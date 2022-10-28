# Hypothesis Testing

+ Specify two hypothesis H0 and H1
+ Bayesian approach:
  + $P(reject H_0|H_0) = P(X > c | H_0)$
  + $P(accept H_0|H_1) = P(X \leq c| H_1)$

## The Neyman-Pearson Paradigm
Null hypothesis: $H_0$
Alternative hypothesis: $H_1 or H_A$

|Terminology|Meaning|
|---|---|
Type I error|Rejecting $H_0$ when it is true
Significance leve $\alpha$|Probability of a type I error
Type II error|Accepting $H_0$ when it is false
The power of test $1-\beta$|Probability that $H_0$ is rejected when it is false
Test statistic|Likelihood ratio, a threshold of $\frac{P(X = x|H_0)}{P(X = x|H_A}$
Rejection region|Set of values of test statistic that leads to rejection of $H_0$
Acceptance region|Set of values of test statistic that leads to acceptance of $H_0$
Null distribution|Probability distribution of test statistic when $H_0$ is true

## p-value
The smallest significance level at which the null hypothesis would be rejected