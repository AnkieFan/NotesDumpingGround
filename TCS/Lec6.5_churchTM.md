# Church Turing Thesis
+ $\forall$ input w, in M we systematically search the entire non-deterministic tree that is produced by all possible transitions of N on w

## Proof of Theorem:
M uses 3 tapes:  
1. On the 1st, it stores he input w (and never changes it)
2. On the 2nd, simulates N(NTM) on w
3. On the 3rd, it stores the current string from {1,2,...,c}
+ On 3nd tape it creates the first string from ${1,2,...,c}$ (these strings are produced in lexicographic order)
+ For each such string $z = (c_1,...c_t)$, it simulates the actions N would have taken if it had choice $c_i$ at step i of its computation for t steps
+ If 𝒛 does not correspond to valid computation or it does not reach the 𝒒𝑨 or 𝒒𝑹, it erases 𝒛 and produces the lexicographically next one in the 3 rd
tape.

## Church Turing thesis
Intuitive notion of algorithm equals to Turing machines

## Decidability
+ A problem is decidable if there is an algorithm (Turing machine) that decides it.
+ Representation of object 𝑂 is denoted by ⟨𝑶⟩.

### Example (composite number):
M on input $w \in \{0,1\}^*$
1. choose, non-deterministically, two positive integers $1<p, q<w$
2. Write the binary representation of p,q on the tape, next to w
3. Multiply p*q and store the result (possibly in a new tape)
4. if p*q = w accept
5. Else, reject


### recursive vs. recursively enumerable
If we feed to M any string $x\in L$ then  
+ recursively enumerable:
  + If $w \in L$, then M accepts
  + If $w \notin L$, then M either reject or loops forever
+ Recursive:
  + If $w \in L$, then M accepts
  + If $w \notin L$ then M **rejects**

