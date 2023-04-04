# Deterministic finite automata

## Finite Automata
+ Finite state machines
+ can decide (accept/recognize) the Regular Languages

### Components of a finite automaton
+ A **tape** that extends to infinity to the right. It has cells , and each cell can hold one symbol
+ A **cursor** the reads one symbol at a time from the tape and can move only to the right (one symbol at a time)
+ A **control unit** that stores the current state. Given the current state and the symbol read by the cursor, it defines the new state

### Definition
A Deterministic Finite Automaton is a 5 tuple $(Q, \Sigma, q_0,\delta, F)$  
+ Q is a finite set of states
+ $\Sigma$ is the alphabet of the imput symbols
+ $q_0 \in Q$ is the initial state
+ $\delta: Q \times \Sigma \rightarrow Q$ is the transition function
+ $F \subseteq Q$ is the set of final state

### Acceptance of string/language
+ Every string 𝒘 in the language has a unique path that follows from a given state 𝑞, each time reading a letter of 𝒘from left to right
+ A DFA $M$ **accepts** a string $w$ iff the unique walk starting at $q_0$ and moving on the state diagram according the transition function reading one symbol at a time, ends in a final state
+ A DFA $M$ **accepts** (or recognizes) a language $L$ if $M$ accepts all strings in L and *rejects every other string*
+ Configuration: We can denote the computation of $M_1$ on 𝑤 as sequence of (state, remaining string to be read) pairs
  + $M_1$ accepts 𝒘 if we end up with 𝜀 on a final state

### Acceptance of a string
+ We can denote by $\rightarrow^*$ the **reflective and transitive closure** of $\rightarrow$
+ $(q,w) \rightarrow^* (q',w')$ when the configuration $(q,w)$ produces in zero or more steps the configuration $(q', w')$ where w' is the substring of w
+ We say that a DFA $M = (Q, \Sigma, q_0, \delta, F)$ accepts a string $x \in \Sigma^*$ if $(q_0, x) \rightarrow^* (q,\varepsilon)$ and $q \in F$
+ Important: An automaton recognizing 𝑳 must accept all 𝒘∈𝑳 and must reject every 𝒘′∉𝑳

## Solving exercise question
1. Draw the DFA with the specific situation
   1. E.g.: {0,1} end with 00
   2. Draw the DFA end with 00
   3. -> q0 -0-> q1 -0-> q2
2. Fill outputs for all the states with other letter in alphabet reasonably
   1. q0 needs an output '1' (point to it self)
   2. q1 needs an output '1', point to q0(since other way does not fit requirement)
   3. q2 needs an output '1', point to q0(since other way does not fit requirement)