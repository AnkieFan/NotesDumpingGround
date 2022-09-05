# Lecture 1: Probability and Counting

## Notations
+ $S$ sample space: possible outcomes
+ $A$ event: a subset of sample space
e.g.: B event that at least one is head
$B = A_1 \cup A_2 \cup ... \cup A_  {10} = \cup_{j=1}^{10} A_sj$
e.g.: C event all F
$C = A_1 \cap A_2 \cap ... A_{10} = \cap_{j=1}^{10} A_j$

+ $\subset$
+ $\supseteq$

## Sampling with replacement
+ $n$ objects and making $k$ choices from them, one at a time with replacement (can be chosen again next time)
+ with replacement, order matters
+ possible outcomes: $n^k$

## Sampling without replacement
+ Once chosen cannot be chosen again
+ without replacement, order matters
+ Possible outcomes: $n(n-1)(n-2)...(n-k+1)$

## Binomial Coefficient Formula
+ With replacement, order doesn't matter
+ For $k\leq n$, we have 
  $$\begin{pmatrix} n \\ k \end{pmatrix} = \frac{n(n-1)...(n-k+1)}{k!} = \frac{n!}{(n-k)!k!}$$
+ For $k \leq n$, we have  $$\begin{pmatrix} n \\ k \end{pmatrix} = 0$$

## Intuition
1. $P(\empty)$ = 0, P(S) = 1$
2. $P(\cup^{\infin}_{j=1}A_j) = \sum^{\infin}_{j=1}P(A_j)$
3. $P(A^c) = 1-P(A)$
4. If $A \subseteq B$, then $P(A) \leq P(B)$
5. $P(A \cup B) = P(A) + P(B) - P(A \cap B)$
6. $P(A^c) = 1-P(A)$