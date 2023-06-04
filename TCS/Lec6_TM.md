# Turing Machine
In fact, can recognize Context Free Languages  
+ The tape:
  + Cells, each containing a single symbol
  + Has a leftmost cell
  + but extended to infinity on the right side
+ The cursor
  + Reads the current cell symbol
  + can overwrite a symbol in the current cell
  + move right, left or stay
  + Two special states: $𝒒_{𝒂𝒄𝒄𝒆𝒑𝒕},𝒒_{𝒓𝒆𝒋𝒆𝒄𝒕}$

## Definition
A Turing Machine M is a 7-tuple $M = (Q, \Sigma, \Gamma, \delta, q_0, q_{accept}, q_{reject})$  
+ $Q$: finite set of states
+ $\Sigma$: input alphabet
+ $\Gamma$: tape alphabet (includes blank symbol)
+ $\delta$ transition function $Q \times \Gamma \rightarrow Q \times \Gamma \times \{L,R,-\}$
+ $q_0$: starting state
+ $q_{accept}, q_{reject}$: the accepting/rejecting states

### Configuration: a snapshot of the current mode of the TM 𝑀
Formally: a pair $(q, wau)$ where  
+ $q \in Q$: current state
+ $a \in \Gamma$: symbol in the cell
+ $w/u \in \Gamma^*$: the content of the tape to the left/right of the cursor
+ $q = q_{accept} (q_{reject})$: accepting/rejecting configuration

## Defi
+ $M$ does not accpets w if it either rejects w or loops infinite on w
+ $M$ does not rejects w if it either accepts w or loops infinite on w
+ $M$ **halts** on w if it either accepts w or rejects w

## Language Recognition
+ A Turing machine accepts the input iff q0 can reach $q_{accept}$ where the cursor reads the first symbol of w

## Decider
+ A Turing machine 𝑀 decides a language 𝑳 if it accepts $∀𝒘∈𝑳$ and it rejects ∀𝒘∉𝑳. 𝑀 recognizes 𝑳 and, furthermore, it is a decider.
+ A language 𝑳 is called Turing decidable if there exists some Turing machine that decides it. (also called recursive languages)

## recognizes vs. decides
+ $M$ **recognizes** a language $L \subseteq \Sigma^*$ if $\forall w \in \Sigma^*$
  + If $w \in L$, then M accepts
  + If $w \notin L$, then M either reject or loops forever
+ $M$ **decides** a language $L \subseteq \Sigma^*$ if $\forall w \in \Sigma^*$
  + If $w \in L$ then M **accepts**
  + If $w \notin L$ then M **rejects**

## Non-deterministic Turing Machines (NTM)
All effective methods of computation are equal to or weaker than a TM.  

The language can be formulated as follows:
$L = \{\langle M \rangle \mid \text{on input } x, \text{ Turing machine } M \text{ writes a non-blank symbol on its second tape\}}$

Here, $\langle M \rangle$ represents the encoding of the Turing machine $M$.

To show that this language is undecidable, we can reduce the problem of the halting problem, which is known to be undecidable, to this problem.
Suppose we have a Turing machine $H$ that decides the halting problem, i.e., given the encoding of a Turing machine $M$ and an input string $x$, $H$ decides whether $M$ halts on $x$ or not. We will construct a new Turing machine $M'$ that simulates $M$ on input $x$, and if $M$ halts on $x$, then $M'$ writes a non-blank symbol on its second tape. Otherwise, $M'$ never writes a non-blank symbol on its second tape.

Formally, $M'$ can be defined as follows:

On input $x$:
Simulate $M$ on input $x$.
If $M$ halts on $x$, then write a non-blank symbol on the second tape and halt. Otherwise, continue simulating $M$ on $x$.
Now, if we assume that $L$ is decidable, then there exists a Turing machine $T$ that decides $L$. We can use $T$ to decide the halting problem as follows:

On input $\langle M, x \rangle$:
Construct the Turing machine $M'$ as described above.
Run $T$ on input $\langle M' \rangle$.
If $T$ accepts, then $M'$ writes a non-blank symbol on its second tape, which means $M$ halts on $x$. Otherwise, $M'$ never writes a non-blank symbol on its second tape, which means $M$ does not halt on $x$.
Output the appropriate answer.
Therefore, if $L$ were decidable, then the halting problem would also be decidable, which is a contradiction. Hence, $L$ is undecidable.