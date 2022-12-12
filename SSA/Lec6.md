# Generating random variates
## Setting:
+ Distribution already known
+ Source of IDD U(0,1) random variates available
+ Considerations:
  + Exactness
  + Efficiency
  + Complexity
  + Robustness

## Inverse Transform Method
If $X$ is a continuously random variable and its CDF is $F_X$, then:  
$X = f_X^{-1}(U), U \sim U(0,1)$
反函数（对于原函数来说X和Y互换位置）

### Composition technique
+ Applies when the distribution function F can be expressed as a convex combination of other distribution functions
+ Assume that for all x, F(x) can be written as
  + $F(x) = \sum^\infin_{j=1} p_jF_j(x)$
  + $p_j \geq 0, \sum^\infin_{j=1}p_j = 1$
+ 写成分段函数，分别求CDF，然后分布求反函数加起来

## Acceptance-Rejection
接受拒绝采样：一种蒙特卡罗方法
用矩形将函数圈起来，向这个矩形随机投点，但只保留函数下的点。对这些点的分布概率进行拟合。
+ t(x) majorizing function
+ r(x) = t(x)/c is PDF
  + where $c = \int^\infin_{-\infin} t(x)dx \geq \int^\infin_{-\infin} f(x)dx = 1$

### Algorithm:
1. Generate Y having density r
2. Generate $u \sim U(0,1)$ independent of Y
3. if $u <= f(Y)/t(Y)$ return X=Y
4. Else go to 1

## Convolution 卷积
1. generate $Y_1, Y_2, ... Y_m$ IID each with distribution function G
2. Return $X = Y_1 + Y_2 + ... + Y_m$

## Generating Continuous Random Variates
+ Uniform distribution
  + For $0 \leq u \leq 1$, $x = F^{-1}(u) = a + (b-a)u$
  + Use the inverse-transform method to generate X
    1. Generate $U \sim U(0,1)$
    2. Return $X = a + (b-a)U$
+ Exponential
  + use inverse-transform method
+ m-Erlang
  + Use convolution (sum of exponentiale) or inverse-transform method
+ Lognormal
  1. Generate $Y \sim N(\mu,\sigma^2)$
  2. Return $X= e^Y$
+ Normal
  + Box and Muller method
    + Get $U_1, U_2 \sim U(0,1)$, find X,Y such that:
      + $X = cos(2\pi U_1)\sqrt{-2lnU_2}$
      + $X = sin(2\pi U_1)\sqrt{-2lnU_2}$
    + Then X and Y follows Normal distribution with $\mu = 0, \sigma^2 = 1$
  + Polar method