# Inequalities and Limit Theorems

## Markov’s Inequality
For any r.v. Xand constant a > 0,
$P(|X| \geq a) \leq \frac{E|X|}{a}$

## Chebyshev’s Inequality
Let X have mean $\mu$ and variance $\sigma^2$. Then for any $a > 0$,
$P(|X-\mu| \geq a) \leq \frac{\sigma^2}{a^2}$

## Weak Law of Large Numbers
For all $\epsilon > 0$, $P(|\overline{X_n}-\mu| \geq \epsilon) \rightarrow 0$ as $n \rightarrow 0$

## Central limit theorem
As $n \rightarrow 0$
$\sqrt{n}(\frac{\overline{X_n}-\mu}{\sigma})\rightarrow N(0,1)$ in distribution

### Central limit theorem, approximation form
For large n, the distribution of $\overline{X_n}$ is appoximately $N(\mu,\sigma^2/n)$