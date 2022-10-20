# Matching / Hall Theorem

+ Matching: independent edges set
+ Matching M is a **miximal** matching if $\forall e \in E \ M,M \cup {e}$ is not a matching
如果一个子图包含了M，并且还有其它的边，那么必然不是matching，也就是说一定有两条边有公共顶点。
+ Matching m is **maximum** if $\forall$matching M' of G: $|M| \geq |M'|$ 是边数最多的matching
+ Perfect matching: a matching includes all the vertices
+ Complete matching: matching M of a bipartite graph $G=(U \cup W,E)$ is called a complete matching if
  + all vertices U are matched in M
  + or All vertices W are matched in M
  + If |U| = |M|, this complete matching is a perfect matching

## Hall theorem:
Let $G=(U \cup W,E)$ be a bipartite graph, $|U| \leq |W|$, there's a complete matching iff:
$\forall S \subset U: |S| \leq |N(S)|$
S的任意顶点所连接的W中的点的数量都大于等于S中点的数量

# Matchings / Augmenting Paths & Berge's Theorem

## Augmenting path
Let G be a graph and M a matching of G
A path P is called augmenting path if
1. P starts and ends with an unmatched vertex
2. every second edge along P is from M
  
### Proposition 2 
Every augmenting path P has an odd length, and the number of edges in P that are from M is one less than the number of edges in P that are not from M.

### Theorem
Let $P = (v_0,v_1,...,v_l)$ be an augmenting path with respect to M. Then $M \ \{e|e\in P \cap M\} \cup \{e|P\ M \}$ is a matching of size |M|+1

### Berge's theorem 
A matching M in a graph G is maximum  iff there is no augmenting path with M.