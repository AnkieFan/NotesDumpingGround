# Informed Search and Local Search

## Informed search:
### Greedy best-first search
+ Evaluation function ℎ(𝑛) (heuristic)
  + estimate of cost from 𝑛 to the closest goal
+ Choose the one with the lowest cost

### A* search
+ Evaluation function 𝑓(𝑛) = 𝑔(𝑛) + ℎ(𝑛)
  + 𝑔(𝑛) = cost so far to reach 𝑛
  + ℎ(𝑛) = estimated cost to goal from 𝑛
  + 𝑓(𝑛) = estimated total cost of path through 𝑛 to goal

#### Consistency
+ Most admissible heuristics also have the consistency (monotonicity) property
+ A heuristic is consistent if $ℎ(𝑛)≤𝑐(𝑛, 𝑎, 𝑛^′)+ℎ(𝑛^′)$
+ Theorem: If h(n) is consistent, A* using GRAPH-SEARCH is optimal

#### Properties of A*
+ Complete
+ Optimal
+ Time: Exponential in [relative error in ℎ × length of soln.]
+ Space: Keeps all nodes in memory

### IDA*
+ A* can be memory intensive for large problems
+ Iterative deepening A* (Korf, 1985)
+ Iterative deepening iterates on a threshold T
+ Search a node as long as f ≤ T
+ Either find a solution (done), or fail, in which case the threshold is increased and a new deph-first search starts

## Local Search
+ In many optimization problems, path is irrelevant; the goal state itself is the solution.
+ Then state space = set of “complete” configurations;
  + find optimal configuration, e.g., TSP
  + or, find configuration satisfying constraints, e.g., timetable

### Hill-climbing (gradient ascent/descent)
### Simulated annealing
escape local maxima by allowing some “bad” moves but gradually decrease their size and frequency