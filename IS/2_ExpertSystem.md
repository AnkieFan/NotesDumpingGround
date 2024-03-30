# Expert Systems

## Def:
+ a computer system that emulates the decision-making ability of a human expert
+ a computer system that uses knowledge and inference to solve problems in a specialized subject domain, that are difficult enough to require human expertise
+ difference with Intelligent Systems: only software
+ difference with Agents: Don’t interact with an environment, No real proactive behavior

## Knowledge Base and Inference Engine
+ Rules: IF-THEN statement
+ Faces: Data about specific cases/instances/…

### Non-probabilistic Reasoning


### Probabilistic Reasoning
+ Probabilistic facts: p(student)
+ Probabilistic reasoning: p(A|B) (A depends on B)
+ Marginalizing: finding a probability value: P(Var1=value1) or P(Var1=value1,…,VarN=valueN)
+ Maximization: $V_{MAP} = argmax_{value}P(Var1=value)$
+ Bayes Rule $P(A|B) = \frac{P(B|A)P(A)}{P(B)}$

#### Naïve Bayes


## Cons and Pros
### Advantages of Expert Systems
- Consistency (same decisions given the same data)
- Memory (computers do not forget)
- Logic (no sentimental or biased decisions)
- Infinitely reproducible (and does not get tired)

### Disadvantages
- Common sense (hard to program common sense)
- Creativity (difficult to find new solutions to problems)
- Maintenance (knowledge base manually updated)
- Not adaptable by itself (no response to changing conditions)