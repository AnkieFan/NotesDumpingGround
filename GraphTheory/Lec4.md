# Minimally-Connected Graphs (trees)

## Definations:
### connected:
+ For edge: If there's uv-path, then u and v is connected.
+ For graph: $\forall u,v \in V, \exist$ an uv-path, then G is connected.

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

### Component:
If a connected subgraph of G is not a true subgraph of any other connected subgraph of G, then it is said to be a connected branch of G
图是connected iff G恰好有一个component

#### Theorem:
G = (V,E), $|E| \geq 3$, $\exist u, v \in V, u \not ={v}$ such that $G_u$ and $G_v$ is connected, then G is connected.
Proof: let x,y to be 2 vertices in G
1. $\{x,y\} \not ={\{u,v\}}$ 
2. $\{x,y\} =\{u,v\}$ 

### Induced subgraph
+ 诱导子图，有特定的vertices和它们之间连接的edges
+ For a graph $G = (V,E)$ and $V' \subseteq V$, an **induced subgraph** of G by V' is the graph $G[V'] := (V', E')$, where
  + $\forall uv \in E'$ iff $u \in V' and v \in V'$
  + 对于F中的任意顶点u和v, 只要uv是G 中的边, 则uv一定是F中的边,

### A minimally-connected graph is called a tree
+ A vertex of degree 1 is called a leaf

## Tree characterization:
The following statements are equivalent for any graph G = (V,E):
1. G is a tree
2. G is connected and acyclic
3. G is maximally-acyclic (take any $uv \notin E, then G' = (V,E \cup \{u,v\}$ has a cycle)
4. For any two vertices $u,v \in V(G)$: there is a unique uv-path in G
5. G is connected and $|E| = |V| - 1$

### Theorem:
+ G is a tree iff every 2 vertices are connected by only one path.
+ Every non-travil tree has at least 2 leaf
+ For trees: |E| = |V|-1
+ Every connected graph: $|E| \geq |V|-1$
+ if G satisfied 2 of following, G is a tree:
  + G is connected
  + G is acyclic
  + |E| = |V| - 1
+ If T is a tree that |V| = k, if G satisfies $\delta(G) \geq k-1$, then T is isomorphic to a subgraph of G
