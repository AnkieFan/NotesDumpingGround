# Logic

+ Valid inference:
    + $\frac{A_1, A_2, A_3, ... , A_n}{C}$
    + An inference is **valid** if and only if **every** time **all** the premises are true, the conclusion is also true.

e.g.: if x integer, then $x^3 - x$ is multiple of 3
        3 cases: x = 3k, or x = 3k+1, or x = 3k+2
        case x = 3k+2: $x^3 - x = $

## Propositional language
The language LP is a set of formulas satisfying:
1. All the basic propositions are in LP:
    p ∈ LP, q ∈ LP, r ∈ LP, . . .
2. If ϕ ∈ LP and ψ ∈ LP, then
    + (ϕ ∧ ψ) ∈ LP, 
    + (ϕ → ψ) ∈ LP,
    + (ϕ ∨ ψ) ∈ LP, 
    + (ϕ ↔ ψ) ∈ LP
    + Nothing else is in Lp


## Constructing formulas
(¬(p ∨ q) → r) can be seen as building a **tree**
name | symbol
--- |:--:
not | ¬
and / conjuction | ∧ 
or / disjunction | ∨
"if...then" / implication | →
"if and only if" / equivalence | ↔
  

+ Never true (**contradiction**)
+ Can be true (**satisfiable**)
+ Always true (**valid, tautology**)
+ Two formulas ϕ and ψ are **logically equivalent** (ϕ ≡ ψ) if and only if ϕ |= ψ and ψ |= ϕ

## Symbolic inference
+ A **proof** is a finite sequence of formulas where each formula is either an axiom or else it has been infered from previous formulas by using an **inference rule**.
+ A formula is a **theorem** if it occurs in a proof
+ A set of axioms and rules is called an **axiom system** or an **axiomatization**.
  + An axiom system is **sound** for a logic if every theorem is valid in
the logic.
  + An axiom system is **complete** if every valid formula of the logic is
a theorems.
