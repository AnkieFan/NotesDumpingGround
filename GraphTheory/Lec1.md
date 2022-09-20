# Graph
 
- vertices V=
- edges E
- graph G

e.g.:
V = {x, y, z}
Edges:{x, y}, {x, z}, {y, z}
E = {{x, y}, {x, z}, {y, z}}

## Drawing a graph
G = (V, E): a tuple
V = {a, b, c, d}
E = {{a,c}, {c,d}}}

## Vocabulary
+ neighbor
+ adjacent (vertices)
+ edge $e \in E$ is **incident** to a vertex $v \in V$ IFF $v \in e
+ degree $d(v) = |{e \in E| v \in e}|$
+ $\delta(G) := min \{d(v)|v \in V\}$ minimum degree of G
+ $\Delta(G) := max \{d(v)|v \in V\}$ maximum degree of G
+ $d(G) = \frac{\sum_{v \in V}d(v)}{|v|}$
+ vertices u and v are **endpoints**(endvertices) of an edge e
+ edge e **joins** u and v
+ weights/labels: distance, time...
+ **Path** in G: sequence of vertices $(v_1,v_2,...,v_l)$, s.t.: $\forall i = 1,2,...,l-1: {v_i,v_{i+1}} \in E$, and $v_1 \neq v_i \forall i \neq j$
+ A **clique** is a collection of vertices in an undirected graph G such that every two different vertices in the clique are nearby, implying that the induced subgraph is complete.