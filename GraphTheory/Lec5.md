# Minimum spanning tree

## Edge-weighted graph
An edge-weighted graph is a graph G = (V,E) together with edge-weights $w(e) \in R$ for every $e \in E$
+ Let H = (V', E') be a subgraph of G.
+ The cost of subgraph H, denoted as c(H), is $\sum_{e \in E'}w(e)$

## Minimum spanning tree:
A minimum spanning tree T of an edge-weighted graph G = (V, E) is a spanning tree of minimum cost c(T) (among all spanning trees).

### Prim's algorithm
T ← any vertex v
while T not a spanning tree do:
    uw ← arg $min_{uw\in E; u\in T; w \notin T}w(uw)$
    T ← T + uv
end
return T

### Kruskal's algorithm
T ← $(V, \emptyset)$
Sort rge edges in E such that $w(e_1) \leq w(e_2) \leq ... \leq w(e_m)$
for i = 1...,m do:
    if $T + e_i$ does not contain a cycle then
        T ← $T + e_i$
    end
end
return T