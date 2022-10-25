# Connectivity

## Defination
### Vertex cut
$S \subset V$ is a vertex cut if $G \backslash S$ is disconnected
### Disconnecting set of edges
$F \subset E$ is a disconnecting set of edges (edge-disconnecting) if $G \backslash F$ is disconnected
### Connectivity
Connectivity of a graph G=(V,E):
k(G) is the size of smallest $S \subset V$ such that
+ G\S is disconnected
+ OR G\S is a single vertex
### Edge-connectivity of G:
k'(G) = minimum size of an edge-disconnecting
### E(S,T)
For any $S,T \subset V$
$E(S, T) = {uv\in E | u\in S, v\in T}$
### Edge cut
E(S, T), for $S,T \subset V$, is called an edge cut if
$S,T \not= \empty$ and $T = v \ S$ 
### x-y cut
For $x,y \in V$, x-y cut is a set $S \subset V\backslash{x,y}$ such that
$G \backslash S$ has no x-y path. 
### x-y-connectivity
x-y-connectivity  of G is the size of a smallest x-y cut;
### x-y-edge-disconnecting set
x-y-edge-disconnecting set is a set $F \subset E$ such that $G\backslash F$ has no x-y path
### x-y-edge-connectivity
x-y-edge-connectivity of G is the size of a smallest x-y-edge-disconnecting set.
### Strongly connected
Directed graph G(V,E) is strongly connected if
$\forall u,v \in V:$ There exists
+ A path from u to v
+ And a pthe from v to u
### x-y-edge-disconnecting
Let $x,y \in V$, set $F \subset E$ is an x-y-edge-disconnecting set of a directed graph G, if in $G \backslash E$ there is no path from x to y.