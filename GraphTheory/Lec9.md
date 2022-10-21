# Shortest Paths

## Directed graph G = (V,E)
- Every edge $e \in E$ is a tuple of vertices $e \in V x V$
  - Cartesian product of two sets: $AxB := \{(a,b)|a\in A, b\in B\}$
- Hence: $(u,v) \in VxV$ is a different tuple than $(v,u) \in VxV$ , they are differen edges.

### Path in a directed graph；
Sequence of vertices $(v_0,v_1,v_2,...,v_k)$ such that:
+ $(v_0,v_1) \in E$
+ $(v_1,v_2) \in E$
+ $(v_2,v_3) \in E$
+ ...
+ $(v_{k-1},v_k) \in E$
And $\forall i\not=j: v_i\not ={v_j}(0\leq i,j\leq k)$

### walk in a directed graph
Sequence of vertices $(v_0,v_1,v_2,...,v_k)$ such that:
- $\forall i=0,...,k-1: (v_i,v_{i+1} \in E)$

### Weight of a path/walk
For a walk/path $x = (v_0,v_1,v_2,...,v_k)$
In an edge-weighted graph G(V,E) with edge-weight
$w(X) := \sum^{k-1}$

### Theorem
Let $P = (v_0, v_1, v_2,...,v_l)$ be a shortest path from $v_0$ to $v_l$ in an edge-weighted graph G with non-negative edge weights. Then, for any $0 \leq i < j \leq l, v_iPv_j$ is a shortest path from $v_i$ to $v_j$

## Find the shortest path
### Dijkstra's algorithm (No negative edge-weight)
$\forall v: d[v] = \infin$ // Final results
$d[s] = 0$ // a set of vertices to record distance
$S = \emptyset$
$while S \not ={V} do$
+ u = arg min d[v]
+ $S = S \cup {u}$
+ $\forall edge(u,x) \in E:$ if d[x] > d[u] + w(u,x)
  + then d[x] = d[u] + w(u,x)

### Bellman-ford algorithm (negative edge-weight)
1 ∀v: d[v] ← ∞ and π[v] ← v
2 d[s] ← 0
3 for i = 1, 2, . . . , n − 1 do
4 for every edge uv ∈ E do
5 if d[u] + w(uv) < d[v] then
6 d[v] ← d[u] + w(uv)
7 π[v] ← u
8 end
9 end
10 end

### Theorem
+ Given a directed edge-weighted graph G = (V,E) and a vertex $s \in V$, the Bellman-Ford algorithm computes, for every vertex $v \in V$, a shortest su-path.