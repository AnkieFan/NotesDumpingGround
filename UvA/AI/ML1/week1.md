# Intro to Machine Learning, Probability Theory, Linear Regression

## Machine Learning
### What is machine learning
+ E - experience
+ T - tasks (classification, regression, clustering)
+ P - performance measure

### Supervised learning
+ Dataset: 
  + features: $\{\bf{x_1, ..., x_N}\}$
  + targets: $\{t_1, ..., t_N\}$
+ Task: Find function $f$ such that $f(\bf{x} \approx t)$ or all known and unknown pairs $(\bf{x},t)$

### Unsupervised learning Unsupervised 
+ clustering

### Other types of learning
+ Semi-supervised learning
  + data points: $\{x_1, ..., x_k, x_{k+1}, ..., x_N\}$
  + targets: $\{t_1, ..., t_k\}$
  + Not all data points have a known target/label
  + Use all data, also those with unknown target, to create predictor
+ Reinforcement Learning

## Probability theory
+ Frequentist interpretation (data-driven)
  + Probability of event: fraction of times event occurs in experiment
+ Bayesian approach (model-driven)
  + Probability: quantification of plausibility or the strength of the belief of an event

### Random variables
+ Stochastic variable sampled from a set of possible outcomes
+ Discrete or continuous
+ Probability distribution p(X)
+ e.g.: flipping a coin: X = {head, tail}

#### Two discrete random variables
+ N trials: sample both X and Y.
+ Joint probability: $p(X = x_i, Y = y_i) = \frac{n_{ij}}{N}$
+ Marginal probability: let $c_i = \sum^n_{j=1}$ then $p(X=x_i)$
+ Sum rule: $p(X = x_i) = \sum_j p(X=x_i, Y=y_j)$
+ Conditional probability: $p(Y=y_i|X=x_i) = \frac{n_{ij}}{c_i}$
+ Product rule $p(X=x_i, Y=y_i) = \frac{n_{ij}}{N} = p(Y=y_j|X=x_i)p(X=x_i)$

#### Continuous Random Variables
+ Probability of $x \in \mathbb{R}$ falling in the interval $(x, x+dx)$ is given by $p(x)dx$
+ $p(x)$: probability density over x
+ Probability over finite interval $p(x \in (a,b)) = \int^b_a p(x)dx$
+ positivity: $p(x) \geq 0$
+ Normalization: $x \in \mathbb{R} = \int^{\infin}_{-\infin}p(x)dx = 1$
+ Change of variables $x = g(y)$, probabilities in $(x, x+dx)$ must be transformed to $(y,y+dy)$
  + $p_x(x)dx = p_y(y)dy$
+ Cumulative distribution: $P(x) = p(X \leq x) = \int^\infin_{-\infin} p(x)dx$
![pro_rules](imgs/pro_rules.png)

## Bayes Theorem
+ Product rule: $p(x,y) = p(x|y)p(y)$
+ Symmetry property: $p(x,y) = p(y,x)$
+ Bayes rule: $p(y|x) = \frac{p(x|y)p(y)}{p(x)}$
  + $p(x) = \sum_y p(x,y) = \sum_y p(x|y)p(y)$ (refers to [Law of total probability](..\ProSta\Lec2.md))
