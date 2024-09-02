# Joint Distribution

## Joint PMF (Discrete)
The joint PMF of **discrete** r.v.s X and Y is the function pX,Ygiven by  
$p_{X,Y}(x,y)=P(X =x,Y =y)$  

### Marginal PMF
For **discrete** r.v.s X and Y , the marginal PMF of X is  
$P(X = x) = \sum_y P(X=x, Y=y)$  

### Conditinal PMF
For **discrete** r.v.s X and Y , the conditional PMF of Y given X =x is:  
$P(Y = y| X = x) = \frac{P(X=x, Y=y)}{P(X=x)}$  

### Properties
+ X,Y are independent if: $F_{X, Y}(x,y) = F_X(x)F_Y(y)$
+ $P(X = x, Y = y) = P(X=x)P(Y=y)$  
+ For all $P(X = x) > 0$: $P(Y = y|X = x) = P(Y=y)$  

## Joint PMF (Continuous)
If X and Y are continuous with joint CDF $F_{X,Y}$, their joint PDF is the derivative of the joint CDF with respect to x and y:  
$f_{X,Y}(x,y) = \frac{∂^2}{∂_x∂_y}F_{X,Y}(x,y)$ (Always >= 0)  

### Marginal PDF
$f_X(x) = \int_{-\infin}^{\infin}f_{X,Y}(x,y)dy$  

### Conditional PDF
For all x with $f_X(x) >0$  
$f_{Y|X}(y|x) = \frac{f_{X,Y}(x,y)}{f_X(x)}$  

### Continuous form of Bayes’ rule and LOTP
+ For continuous r.v.s X and Y, Bayes' rule:
  + $f_{Y|X}(y|x) = \frac{f_{X|Y}(x|y)f_Y(y)}{f_X(x)}$, for $f_X(x) > 0$  
+ And we have the following continuous form of the law of total probability:
  + $f_X(x) = \int^{\infin}_{-\infin}f_{X|Y}(x|y)f_Y(y)dy$  
+ Proposition:
  + If $f_{X,Y}(x,y) = g(x)h(y)$, the X,Y are independent.  

## 2D LOTUS
+ X, Y are discrete:  
  + $E(g(X,Y)) = \sum_x \sum_y g(x,y)P(X=x,Y=y)$  
+ X,Y are continuous:  
  + $E(g(X,Y)) = \sum^\infin_{-\infin} \sum^\infin_{-\infin} g(x,y)f_{X,Y}(x,y) dxdy$  

## Covariance and Correlation
$Cov(X,Y) = E((X-EX)(Y-EY)) = E(XY) - E(X)E(Y)$
$Corr(X,Y) = \frac{Cov(X,Y)}{\sqrt{Var(X)Var(Y)}}$  

### Theorem
If X and Y are independent, then they are uncorrelated and their covairance is 0.  

## Multivariate Normal distribution
A k -dimensional random vector X =(X1,...,Xk)is said to have a Multivariate Normal distribution if every linear combination of the $X_j$ has a Normal distribution. That is, we require  
$t_1X_1 + ... + t_kX_k$  
to have a Normal distribution for any constants $t_1, ..., t_k$  

### Theorem
If $X_1,X_2,X_3$ is Multivariate Normal, then so is the subvector $(X_1, X_2)$  