# Chapter 6:  Propositional Dynamic Logic - Syntax and Semantics

## propositional dynamic logic (PDL)

### formulas φ
+ Every basic proposition is a formula: p,q,r,...
+ If φ and ψ are formulas, then the following are formulas: ¬φ, φ ∧ψ, φ ∨ψ, φ →ψ, φ ↔ ψ
+ If φ is a formula and α an action, then the following is a formula:
〈α〉φ

### action α
+ Every basic action is a action
a, b, c, . . .
+ If α and β are actions, then the following are actions:
$ α; β, α ∪β, α^∗ $
+ If φ is a formula, then the following is an action: $?\varphi$ 

### Symbols: (!!! bExam)
+ ```α; β```  sequential composition: **execute α and then β**
+ ```α∪β``` non-deterministic choice: **execute α or β**
+ $ α^* $ repetition: **loop to do α**
+ $αˇ$ Converse: reversing basic actions
+ $?\varphi$ test: **check wheather $\varphi$ is true**
+ **$〈α〉φ $ α can be executed in such a way that, after doing it, $\varphi$ is the case** 
+  p ∨¬p as T
+  ¬T as ⊥
+  **$¬〈α〉¬φ $ as $ [α] φ$ ** After any execution of α, $\varphi$ is the case**
+ 〈α〉T : α can be executed
+ [α] ⊥ : α cannot be executed
+ 〈α〉φ ∧¬[α] φ 
  α can be executed it at least two different ways
+ [\[p]]: interpretations of p
#### tips:
+ $〈\alpha〉ϕ$ is true in a state s if for **some** $s_0$ with $(s, s_0)$ in the interpretation of α it holds that ϕ is true in $s_0$
+ $[α]ϕ$ is true in a state s if for **every** $s_0$ with $(s, s_0)$ in the interpretation of α it holds that ϕ is true in $s_0$

## labelled transition systems (LTS)
### 3 components: $M = 〈S,R_a,V〉$
+ ```S``` a non-empty set S of states
+ ```V``` a valuation function, ndicating which atomic propositions are true in each state s ∈S
+ ```R``` binary relation $R_a$ for each basic action a

### labelled transition system 带一堆箭头圆圈标志互相指的那个
#### Axiom system
The valid formulas of PDL can be derived from the following principles:
+ All propositional tautologies(valid)
+ $[α] (φ →ψ) →([α] φ →[α] ψ)$ for any action α.
+ Modus ponens (MP): from φ and φ →ψ, infer ψ.
+ Necessitation (Nec): from φ infer [α] φ for any action α.

#### Princeples for action operations
+ Test: $[?ψ] φ ↔(ψ →φ)$
+ Sequence: $[α; β] φ ↔[α] [β] φ$
+ Choice: $[α ∪β] φ ↔([α] φ ∧[β] φ)$
+ Repetition: 
  + Mix: $[α∗] φ ↔(φ ∧[α] [α∗] φ)$
  + Induction: $φ ∧[α^∗] (φ →[α] φ)→[α^∗] φ$

## Semantics of PDL (!!!!! Exam)
Given is a labelled transition system M = <S, V, R> for P and A.
S: set of states
V: valuation
R: set of labelled transitions
->:basic actions

+ $M, s |= p ⇐⇒ p ∈ V (s)$
+ $M, s |= ¬ϕ ⇐⇒ M, s 6|= ϕ$
+ $M, s |= ϕ ∨ ψ ⇐⇒ M, s |= ϕ or M, s |= ψ$
+ $M, s |= ϕ ∧ ψ ⇐⇒ M, s |= ϕ and M, s |= ψ$
+ $M, s |= <α>ϕ ⇐⇒$ for some t, $(s, t) ∈ [[α]]^M$ and $M, t |= ϕ$
+ $M, s |= [α]ϕ ⇐⇒$ for all t with $(s, t) ∈ [[α]]^M$ it holds that $M, t |= ϕ$


$[[α]]^M$: a→M 图里的箭头