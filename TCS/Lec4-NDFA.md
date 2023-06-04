# Non Deterministic Finite Automata
5-tuple: $(Q, \Sigma, q_0, \Delta, F)$  
+ $\Delta: Q \times {\Sigma \cup {\varepsilon}} \rightarrow P(Q)$ is the transition **relation** ($P(Q)$ is the powerset of the set Q)

### Differences:
+ From some states, we can reach multiple states with a given symbol
+ Some states have no transitions on some symbols
+ ε transitions: can reach some states without reading input symbol
  
## Acceptance
+ A NFA N accepts a string w from the alphabet iff a final accepting state can be reached starting on the initial state of N
+ $𝐿(𝑁)$: the language recognized/accepted by 𝑁
  + $L(N) = \{w \in \Sigma^*: N \ accepts \ w\}$
