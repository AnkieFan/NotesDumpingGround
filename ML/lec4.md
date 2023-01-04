# Decision Rules
如果满足A和B就分类到X
if-then-rules
## Why decision rules
+ Decision rules are more compact than decision trees.
+ Decision rules can explain better than decision trees.

### Ordered decision rules 
Also called **decision lists**  
+ Ordered decision rules are logically equivalent to decision trees.
+ The order introduces implicitly extra rule conditions.

## Learning one rule
To learn one rule:
+ Perform greedy search
+ Could be top-down or bottom-up
  + Top-down:
    + Start with maximally general rule
    + Add literals one by one
    + Gradually maximize accuracy without sacrificing coverage  
  + Bottom-up:
    + Start with maximally specific rule  
    + Remove literals one by one
    + Gradually maximize coverage without sacrificing accuracy  


## Heuristics
Possible evaluation functions:  
+ Relative frequency: $n_c/n$
  + $n_c$ is the correctly classified instances
  + $n$ is the instances covered by the rule
+ m-estimate of accuracy: $(n_c+ mp)/(n+m)$ 
  + p is the prior probability of the class predicted by the rule
  + m is the weight of p
+ Entropy

## Approaches to Avoiding Overfitting
+ Pre-pruning: stop learning the decision rules before they reach the point where they perfectly classify the training data
+ Post-pruning: allow the decision rules to overfit the training data, and then post-prune the rules.
### Incremental Reduced Error Pruning
Do pruning directly after each new rule learned
