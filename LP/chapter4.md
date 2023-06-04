# Chapter 4

+ A **feasible solution** is a solution for which all the constraints are satisfied.
+ An **infeasible solution** is a solution for which at least one constraint is violated.
+ An **optimal solution** is a feasible solution that has the most favorable value of the objective function.
  + An optimal solution is a feasible solution that has the most favorable value of the objective function.

## Simplex
No leaving variable => unbounded objective  
The surplus variables and the decision variables are nonbasic.    

Standard form: Maximize, $\leq$  

## Two-Phase Method
1. Phase 1: minimize the sum of artificial variables
   1. Equal to maximize $Z = -\overline{x_a}$, $Z + \overline{x_a} = 0$
2. Phase 2: remove the artificial variables and continue to find the optimal solution

### Initial “zero” basic feasible solution
+ Decision variables and surplus variables are NON-BASIC (=0)
+ Slack variables and artificial variables are BASIC

### Big M
Minimize: $Z = x_1 + x_2 + ... + M\overline{x_6} + M\overline{x_7}-...$  
Maximize: $Z = x_1 + x_2 + ... - M\overline{x_6} - M\overline{x_7}-...$  
+ If the big-M method terminates with an “M” term in the value of the objective function
+ If the first-phase of the two-phase method terminates with a non-zero optimum
  + LP is infeasible

## LP/ILP

The optimum to the LP-relaxation is a lower bound on the ILP optimum (and thus also a lower bound on the true weight of a minimum vertex cover)

## Constraints Missing
+ no nonnegativity constraint:
  + $x_1 = x_1^+-x_1^-$
+ a decision variable whose natural range:
  + $x_1 >= -10$
  + $x_1' = x_1 + 10$s