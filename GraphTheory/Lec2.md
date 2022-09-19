# Paths, Walks, Cycles, Tours...

## Path
A path in a graph $G=(V, E)$ is a sequence of vertices $(v_1,v_2,v_3,...,v_k)$ of V such that:
  + $\forall i = 1,2,...,k-1: \{v_i,v_{i+1} \in E\}$
  + all $v_1, v_2,...,v_k$ are different (ie, $\forall i,j, i \neq j, v_i \neq v_j$)

## Path
+ For $u,v \in V$, anl. **uv-path** is a path $(v_1,v_2,v_3...v_4)$ such that $u_1 = u$ and $v_1 = v$

+ Graph $G = (V, E)$ is called **connected**, if $\forall u,v \in V$
+ Complete graph $G = (V, E)$ is a graph that $\forall u, v \in V: \{v, u\} \in E$
+ Two paths p and p' in graph G are called **independent** if none of the pathes contains an inner vertex of the other path
  + e.g: $p = (u,v)$, $p' = (u, v)$ p and p' are independent

## Eulerian graph
an Eulerian trail (or Eulerian path) is a trail in a finite graph that visits every edge exactly once

### Theorem
Let G be connected graph: G is Eulerian IFF $\forall v \in V(G): d(v)$ is even.

