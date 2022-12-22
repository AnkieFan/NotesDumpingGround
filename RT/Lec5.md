# Chapter 7: Logical agents

## Logic in general
+ **Logics** are formal languages for representing information such that conclusions can be drawn
+ **Syntax** defines the sentences in the language
+ **Semantics** define the “meaning” of sentences; i.e., define truth of a sentence in a world
+ **Entailment** means that a sentence follows logically from another: $KB |= \alpha$
  + Knowledge base 𝐾𝐵 entails sentence a if and only if a is true in all possible worlds where 𝐾𝐵 is true
  + Entailment is a relationship between sentences (i.e., **syntax**) that is based on **semantics**

### Inference 推论
+ The definition of entailment can be applied to derive conclusions (**logical inference**)
+ Entailment = tells us that $\alpha$ is a consequence of 𝐾𝐵
+ Inference = procedure that derives(推导) $\alpha$ from 𝐾𝐵
+ Inference: $𝐾𝐵 |−_𝑖  \alpha  =$ sentence $\alpha$ can be derived from 𝐾𝐵 by inference algorithm 𝑖
  + Soundness: 𝑖 is sound if whenever $𝐾𝐵 |−_𝑖  \alpha$ , it is also true that $𝐾𝐵 |= \alpha$
  + Completeness: 𝑖 is complete if whenever $𝐾𝐵 |= \alpha$, it is also true that $𝐾𝐵 |−_𝑖 \alpha$

## Conjunctive Normal Form





