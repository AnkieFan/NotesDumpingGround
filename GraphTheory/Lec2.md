# Paths, Walks, Cycles, Tours...

## Path
A path in a graph $G=(V, E)$ is a sequence of vertices $(v_1,v_2,v_3,...,v_k)$ of V such that:
  + $\forall i = 1,2,...,k-1: \{v_i,v_{i+1} \in E\}$
  + all $v_1, v_2,...,v_k$ are different (ie, $\forall i,j, i \neq j, v_i \neq v_j$)
vertices不能重复，起点重点不一样

## Circuit


## Walk
- sequence of vertices ($v_1, v_2, v_3, ... , v_{k-1}, v_k$) of V such that:
  - $\forall i=1,2,...,k-1: v_i,v_{i+1} \in E$

### Closed
A walk W = ($_1,v_2,...,v_k$) is called a **closed** walk if $v_1 = v_k$
A closed walk w = ($v_1, v_2, ..., v_k$) is called a **cycle** if 
  + ($v_1, v_2, ..., v_k-1$) is a path
  + and no edge appears twice

## Complete graph
is a graph such that $\forall u,v \in V: {u,v} \in E$

## Length
Length of a walk/path ($v_1, v_2, ..., v_k$) is k-1 (the number of edges)
### Notation
For a path P = ($v_1,v_2, ..., v_i, v_0, v_k$)
+ $\forall i = 1, ..., k: Pv_i$ = the path ($v_1, v_2, ..., v_i$)
+ $\forall i = 1, ..., k: v_iP$ = the path ($v_i, v_{i+1}, ..., v_k$)
+ $\forall i \leq j: v_iPv_j$ = the path ($v_i, v_i+1, ..., v_0$)

## Path
+ For $u,v \in V$, anl. **uv-path** is a path $(v_1,v_2,v_3...v_4)$ such that $u_1 = u$ and $v_1 = v$

+ Graph $G = (V, E)$ is called **connected**, if $\forall u,v \in V:$ There is a uv-path in G
+ Complete graph $G = (V, E)$ is a graph that $\forall u, v \in V: \{v, u\} \in E$
+ Two paths p and p' in graph G are called **independent** if none of the pathes contains an inner vertex of the other path
  + e.g: $p = (u,v)$, $p' = (u, v)$ p and p' are independent

## Eulerian graph
+ a closed walk in G that contains every edge exactly once
an Eulerian trail (or Eulerian path) is a trail in a finite graph that visits every edge exactly once

### Theorem
+ if G = (V,E) has an odd-degree vertex, then G is not Eulerian
+ Let G be connected graph: G is Eulerian IFF $\forall v \in V(G): d(v)$ is even.

