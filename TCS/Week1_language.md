# Computer Science
Input -> Algorithm -> Output

## Computational vs Decision problem
+ Decision Problem **(D)**
+ Computational Problem **(C)**
+ If D can be solved, C can also be solved (binary search)
  
## Definitions
+ Alphabet $\Sigma$
  + a finite set of symbols
  + e.g.: $\Sigma = {0,1}$
+ String $w$
  + over $\Sigma$ is a finite sequence of symbols from $\Sigma$ 
  + '0101' is a string over {0,1}
+ $\varepsilon$: the empty string (length = 0, not a set)
+ Length of a string $w$: $|w|$
+ $\Sigma^n$: set of all strings over $\Sigma$ of length exactly n
+ $\Sigma^*$: set of all possible strigs over $\Sigma$
+ Some conventions to avoid confusions:
  + $a,b,c,...$ are symbols (strings of length 1) of some alphabet $\Sigma$
  + $w,x,y,z,...$ are strings over some alphabet $\Sigma$
  + $A,B,C,...$ are sets of strings

## Basic Properties
+ concatenation: let strings x = wolf, y = dog, xy = wolfdog
  + $x\varepsilon = \varepsilon x = x$
  + also denoted by $x \circ y$
+ $(uv)w = u(vw) = uvw$
+ but xy is not yx
+ $w^R$ is reverse for string 
  + $w$: w = cat, then $w^R$ = tac
  + $w^n = \varepsilon$ if n = 0
  + $w^n = w \circ w^{n-1} = ww^{n-1}, n >1$
  + $w = cat => w^3 = (cat)^3 = cat \circ (cat)^2 = cat \circ cat \circ cat = catcatcat$
+ 𝑣 is called substring of 𝑤 if we can find strings 𝑥,𝑦(possibly ε such
that 𝒘=𝒙𝒗𝒚.
  + If $x = \varepsilon$ then v is prefix of w
  + If $y = \varepsilon$ then v is suffix of w

## Concatenation of Sets
+ Any set of strings is called a **language**
+ Let A,B be 2 sets of strings over a common $\Sigma$
+ We denote $A \circ B = AB = \{xy : x \in A \ and \ y \in B\}$

## $\Sigma^*$ and languages
+ $\Sigma^n$ is the set of all strings from $\Sigma$ of length n
+ $\Sigma^* = \cup_{n \geq 0}\Sigma^n$ is the set of all finite length strings over $\Sigma$
+ $\Sigma^+ = \cup_{n > 0}\Sigma^n$ is the set of **all non-empty** strings over $\Sigma$
+ Α Language 𝐿 is a set of strings over some alphabet $\Sigma^*$

### Some properties
Let A,B be languages:  
+ $A\circ B = \{xy: x\in A, y\in B\}$ concatenation
+ $A\cup B = \{x: x\in A \ or \ x\in B\}$ union
+ $A\cap B = \{x: x\in A \ and \ x\in B\}$ intersection
+ $A \backslash B = A-B = \{x: x\in A \ and \ X \notin B\}$ difference
+ $\overline{A} = \Sigma^* - A$ complement

## Kleene Star: L be a language
+ $L^n$: the set of all strings w that are the result of a concatenation of any n strings from L
+ $L^n = \{\varepsilon\}$ if n = 0
+ $L^n = L \circ L^{n-1}$ if n > 0
+ $L^*$ (Kleene Star) = $ \cup_{n \geq 0}L^n$
  + Is the set of all strings that can be constructed by zero or more concatenations of strings form L
  + $L* = \{w \in \Sigma^*: w = w_1 \circ w_2 \circ ... \circ w_k, all \ w_i \in L \ and \ k \geq 0\}$
+ E.g.: L = {01,1,100} L*:$\varepsilon$, 0101, 10011100, 1111000111111, etc..
