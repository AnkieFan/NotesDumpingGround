# Constraint satisfaction problems

## CSP:
+ state is defined by
  + a set of variables $X = \{X_1,...,X_n\}$
  + a set of domains $D = \{D_1,...,D_n\}$, one for each variable goal test is a set of constraints 𝐶 specifying allowable combinations of values for subsets of variables
+ V: Variables: 𝑊𝐴, 𝑁𝑇, 𝑄, 𝑁𝑆𝑊, 𝑉 , 𝑆𝐴, 𝑇
+ Domains: 𝐷_𝑖  = {𝑟𝑒𝑑, 𝑔𝑟𝑒𝑒𝑛, 𝑏𝑙𝑢𝑒}
+ Constraints: adjacent regions must have different colors


## solve a CSP
+ **constraint propagation**: Inference in CSPs. Using constraints to reduce the number of legal values for a variable.
+ Constraint propagation can be performed **before** search, as preprocessing step, or **interleaved** with search.

### Backtracking search
Depth-first search for CSPs with single-variable assignments is called **backtracking search**

#### Improving backtracking efficiency
1. Forward checking:  
   + This is inference in CSPs: Whenever a value is assigned to a variable, values that are now illegal for other variables are removed
   + doesn't provide early detection for all failures
2. Arc consistency: The arc 𝑋→𝑌  is consistent **iff** for every value of 𝑋 there is some allowed value of 𝑌
3. Minimum remaining values (MRV): choose the variable with the fewest legal values
   + Degree heuristic: choose the variable with the most constraints on remaining variables
4. Choose the least constraining value
5. Tree-structured CSPs
   + Theorem: if the constraint graph has no loops, the CSP can be solved in $𝑂(𝑛𝑑^2)$ time
