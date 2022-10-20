# Proof
1. Deductive reasoning
2. Contradiction
3. Mathematical induction

## Proof a graph is connected
Theorem:
G = (V,E), $\forall u, v \in V$, if $uv \notin E$,  $d(u) + d(v) \geq |E| -1$, then the graph is connected

## Proof 2 paths are different:
$P_1 = {u,...,v}, P_2 = {u,...,v}$
If $\exist u',v' \in P_1, P_1+P_2-u'v'$ is connected, then $P_1, P_2$ are different

## Proof if there's cycle
Theorem:
+ G = (V,E), $\forall  v \in V, d(v)>0$, if $\forall v, d(v)$ is even, then cycle exists
+ G = (V, E), $\exist u, v \in V$, if it exists 2 different path between u and v, then cycle exists

## 
G = (V,E), $\exist v  $