## Maximum Likelihood Principle
+ Dataset $D = \{(x_1,t_1), (x_2, t_2)...\}$ of N independent observations
+ $D \sim p(D|\mathbf{w})$: D as a random variable, distributed to a model with parameters **w**
  + **likelihood**: $p(D|\mathbf{w})$
+ **Maximum likelihood principle**: 
  + likelihood function: $L(\mathbf{w}) = p(D|\mathbf{w})$
  + the most likely explanation of D is given by model parameters $\mathbf{w_{ML}}$ which maximizes the likelihood function
  + assume $x_i \in D$ are i.i.d, $p(D|\mathbf{w}) = \prod^N_{i=1} p(x_i|\mathbf{w})$
  + $\mathbf{w_{ML}} = \argmax_w p(D|\mathbf{w}) =\argmax_w \prod^N_{i=1} p(x_i|\mathbf{w})$
  + argmax: 在这个参数下方程达到最大值

### Problem: numerical underflow/overflow
+ Maximize: $\mathbf{w_{ML}} = \argmax_w \log \prod^N_{i=1} p(x_i|\mathbf{w})$
+ or Minimize negative log-likelihood function: $E(D|\mathbf{w}) = -log p(D|\mathbf{w})$
  + $\mathbf{w_{ML}} = \argmin_w -log p(D|w)$
  + if i.i.d: $\mathbf{w_{ML}} = \argmin_w -\sum^N_{i=1} log p(x_i|\mathbf{w})$

## Maximum A Posteriori Estimates
+ $W_{ML}$ ML estimate: choose such that data likelihood is maximized
+ $W_{MAP}$ MAP estimate: choose most probable given the data
  + $w_{MAP} = \argmax_w p(w|D) = \argmax_w p(D|w)p(w) = \argmin_w - \log p(D|w) - \log p(w)$

## W_ML, W_MAP, W_LS
### W_LS Least Squares Solution
+ Minimizes the sum of squared errors between the predicted outputs and the target values in a regression setting
+ assumes that there is no prior distribution over the weights

### W_ML Maximum Likelihood
+ Finds the parameter W_ML that maximizes the likelihood of observing the data given the model

### Difference
+ W_LS and W_ML are the same when there is no prior or regularization. They both minimize the sum of squared errors without any additional constraints on the weights.
+ W_MAP incorporates a prior over the weights and can be viewed as a regularized version of W_ML. It prevents overfitting by penalizing large weights through the prior distribution.