# Minimally-Connected Graphs (trees)

## Definations:

### Minimally-connected graph
Graph G = (V, E) is minimally-connected if:
+ G is connected
+ $\forall e \in E, G' = (V,E-\{e\})$ is disconnected

#### Properties:
+ Every minimally-connected graph G = (V,E) has no cycle
+ Every minimally-connected graph G, $|V(G)| \geq 2$ has $\delta(G) = 1$
+ Every minimally-connected Graph G on n vertices has n-1 edges

### Subgraph
Graph $G'=(V',E')$ is a subgraph of graph $G=(V,E)$ IF $V' \subseteq V$ and $E' \subseteq E$

### Spanning subgraph
A subgraph $G' = (V', E')$ of a graph G = (V,E) is called spanning subgraph of G, if $V' = V$
拥有所有vertices的子图

### Induced subgraph
For a graph $G = (V,E)$ and $V' \subseteq V$, an **induced subgraph** of G by V' is the graph $G[V'] := (V', E')$, where
+ $\forall uv \in E'$ iff $u \in V' and v \in V'$
+ 子图，有特定的vertices和它们之间连接的edges

### A minimally-connected graph is called a tree
+ A vertex of degree 1 is called a leaf

## Tree characterization:
The following statements are equivalent for any graph G = (V,E):
1. G is a tree
2. G is connected and acyclic
3. G is maximally-acyclic (take any $uv \notin E, then G' = (V,E \cup \{u,v\}$ has a cycle)
4. For any two vertices $u,v \in V(G)$: there is a unique uv-path in G
5. G is connected and $|E| = u - 1$