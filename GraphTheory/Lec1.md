# Graph
 
- vertices V
- edges E
  - an edge **joins**/**connects** two vertices
- graph G

e.g.:
- V = {x, y, z}
- Edges:{x, y}, {x, z}, {y, z}
- E = {{x, y}, {x, z}, {y, z}}
  - An edge is a **subset** of V of **size 2**

## Drawing a graph
G = (V, E): a tuple
V = {a, b, c, d}
E = {{a,c}, {c,d}}}


## Vocabulary
+ $v_2$ is a **neighbor** of $v_1$
+ if $uv \in E$, u and v are **adjacent**
+ order: $|V|$
+ size: $|E|$
+ edge $e \in E$ is **incident** to a vertex $v \in V$ IFF $v \in e$
+ degree $d(v) = |{e \in E| v \in e}|$
+ $\delta(G) := min \{d(v)|v \in V\}$ minimum degree of G
+ $\Delta(G) := max \{d(v)|v \in V\}$ maximum degree of G
+ $d(G) = \frac{\sum_{v \in V}d(v)}{|v|}$
+ vertices u and v are **endpoints**(endvertices) of an edge e
+ edge e **joins** u and v
+ weights/labels: distance, time...
+ **Path** in G: sequence of vertices $(v_1,v_2,...,v_l)$, s.t.: $\forall i = 1,2,...,l-1: {v_i,v_{i+1}} \in E$, and $v_1 \neq v_i \forall i \neq j$
+ A **clique** is a collection of vertices in an undirected graph G such that every two different vertices in the clique are nearby, implying that the induced subgraph is complete.
+ **Regular**: every vertex has the same degree $\delta (G) = \Delta (G)$

### Theorem:
+ If $\forall u,v \in V, uv \notin E$, $d(u) + d(v) \geq |V|-1$, then G is connected and $diam(G) \leq 2$
+ If $\delta (G) \geq \frac{n-1}{2}$, then G is connected.

## Defination:
+ Vertex cover: V' of an undirected graph $G = (V, E)$ is a subset of V such that $u,v \in E \Rightarrow u \in V' \vee v \in V'$ 包含这些点的edge覆盖了所有edges
  + minimum vertex cover's complement is maximum independent set它的补集是最大独立集

### Common graph:
+ Complete graph: $\forall u,v \in V, u\not = {}v$, if uv are adjacent, then G is complete. 
+ Complememt $\overline{G}$: same vertices with G but for each edge of vertices u,v of G, uv is an edge of $\overline{G}$ if and only if uv is not an edge of G.
+ bipartite graph:  a graph whose vertices can be divided into two disjoint and independent sets U and V(partite set), that is every edge connects a vertex in U to one in V. Vertex sets U and V are usually called the **parts** of the graph. 可以分为两个独立集，并且每个edge都是从一个连到另一个。必须是无向图。
+ isomorphic: a function ϕ from $V(G_1)$ to $V(G_2)$, such that $u_1v_1 \in E(G_1)$ iff $ϕ(u_1)ϕ(v_1) \in E(G_2)$, ϕ  is the isomorphism from $G_1$ to $G_2$
+ planar: graph G is a planar graph if it can be drawn in theplane without edge-crossings
+ comflict graph: edge交叉的图

#### Theorem:
+ If G is disconnnected, then $\overline{G}$ is connected
+ selfcomplementary: when $G \cong \overline{G}$, G is selfcomplementary
+ Non-trivial graph is BIPARTITE iff there's no cycle with length to be odd.
+ For isomophic graphs:
  + $G_1$ and $G_2$ are isomophic iff $\overline{G_1}$ and $\overline{G_2}$ are isomophic
  + If G and H are isomophic:
    + G is bipartite iff H is bipartite
    + G is connected iff H is connected
+ For planar graphs: |E| is small, for $|V| \geq 3, |E| \leq 3|V|-6$