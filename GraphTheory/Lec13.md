# Flow network
- directed graph $G = (V,E)$
- edge capacities $c(e) \in R^+, e \in E$ 容积
- source node $s \in V$
- target node $t \in V$

## Definations
### Flow (in a flow network) is:
$f: E \rightarrow R^+_0$ s.t.
- $\forall e \in E: 0 \leq f(e) \leq c(e)$
- $\forall v \not ={s,t}: f^{in}(v) = f^{out}(v)$

### Value (or size) of a flow f is:
$val(f) := f^{out}(s)$

### Maximum Flow is a flow of maximum value