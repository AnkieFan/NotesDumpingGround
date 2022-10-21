# Paths, Walks, Cycles, Tours...

## Path
A path in a graph $G=(V, E)$ is a sequence of vertices $(v_1,v_2,v_3,...,v_k)$ of V such that:
  + $\forall i = 1,2,...,k-1: \{v_i,v_{i+1} \in E\}$
  + all $v_1, v_2,...,v_k$ are different (ie, $\forall i,j, i \neq j, v_i \neq v_j$)
vertices不能重复，起点终点不一样

## Circuit
+ Length >= 3
+ closed trail (verteice can be covered multiple time)

## Walk
- sequence of vertices ($v_1, v_2, v_3, ... , v_{k-1}, v_k$) of V such that:
  - $\forall i=1,2,...,k-1: v_i,v_{i+1} \in E$
  - vertices, edges都可以重复

### Closed
A walk W = ($v_1,v_2,...,v_k$) is called a **closed** walk if $v_1 = v_k$
A closed walk w = ($v_1, v_2, ..., v_k$) is called a **cycle** if  
  + ($v_1, v_2, ..., v_k-1$) is a path
  + and no edge appears twice
  + closed walk不是cycle。cycle起点终点一样，但vertices和edges都不重复
## Complete graph
is a graph such that $\forall u,v \in V: {u,v} \in E$  
每两点之间都有edge连接

## Length
Length of a walk/path ($v_1, v_2, ..., v_k$) is k-1 (the number of edges)
- trivial walk: length = 0
### Notation
For a path P = ($v_1,v_2, ..., v_i, v_0, v_k$)
+ $\forall i = 1, ..., k: Pv_i$ = the path ($v_1, v_2, ..., v_i$)
+ $\forall i = 1, ..., k: v_iP$ = the path ($v_i, v_{i+1}, ..., v_k$)
+ $\forall i \leq j: v_iPv_j$ = the path ($v_i, v_i+1, ..., v_j$)

## Path
+ For $u,v \in V$, anl. **uv-path** is a path $(v_1,v_2,v_3...v_4)$ such that $u_1 = u$ and $v_1 = v$

+ Graph $G = (V, E)$ is called **connected**, if $\forall u,v \in V:$ There is a uv-path in G 任意两点都连通
+ Complete graph $G = (V, E)$ is a graph that $\forall u, v \in V: \{v, u\} \in E$
+ Two paths p and p' in graph G are called **independent** if none of the pathes contains an inner vertex of the other path
  + e.g: $p = (u,v)$, $p' = (u, v)$ p and p' are independent
  + 两个path没有相同的vertex
  + P = (u,v), P' = (v, u): P, P' are independent.

### Theorem:
+ For a graph G = (V,E), if there's a uv-walk with length $l$, then G has one uv-path with length at most $l$

## distinct $d_G(u,v)$ or $d(u,v)$
G = (V,E), $u, v \in V$, distance between u and v is defined as the minimum length of uv path in G.

### diameter diam(G)
The largest distinct between vertices in G

# Euler Tour:
is also called an Euler walk, an Eulerian tour, and an Eulerian walk
+ A closed walk in G that cantains
  + Every edge
  + Exactly once!
  + 正好包含每个edge一次
  
### Eulerian graph
+ Graph that has euler tour is called Eulerian
+ if and only if the degree of every vertex is even

### Theorem
+ if G = (V,E) has an odd-degree vertex, then G is not Eulerian
+ Let G be connected graph: G is Eulerian IFF $\forall v \in V(G): d(v)$ is even.

# Lec 3:
## Hamiltonian cycle:
+ A cycle that visits every vertex

### When is connected G Hamiltonian?
sufficient conditions:
+ If G is connected and every vertex has degree exactly 2, then G has a Hamiltonian cycle.
+ If the minimum degree of a graph G is at least n/2, then G has a Hamiltonian cycle.
(This characterization is knows as Dirac's theorem.)
  + pigeonhole principle: If n items are put into m containers, with n > m, then at least one container must contain more than one item
+ If G is a complete graph (a clique), the G has a Hamiltonian cycle.
(Observe that the last characterization is a special case of Dirac's theorem.)

