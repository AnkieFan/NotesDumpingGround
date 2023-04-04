# Pumping Lemma
+ $\forall$ For every infinite language L
+ $\exist$ there exists integer $n \geq 1$ such that
  + $\forall$ for every string $w \in L$ wth $|w| \geq n$
  + $\exist$ there exists strings $x,y,z$:
    + $w = xyz, |xy| \leq n, y \not ={\varepsilon}$
  + $\forall$ and for every integer $i \geq 0, xy^iz\in L$ 

## Proof by Contradiction:
+ Assume L is regular and let $n$ be the pumping lemma constant for L
+ We choose a string $w \in L$ with $|w| \geq n$ 
+ For every "breakup" of w in $w = xyz$ with $|xy|\leq n$, $t \not ={\varepsilon}$. We find $i \geq 0$ such that $xy^iz \notin L$ (note $i \not ={1}$)
+ **Contradiction**