# Multi Agent Reinforcement Learning

## Cooperative Systems
+ Full System Reward: a global reward signal that reflects the overall performance of the entire system, regardless of individual agent contributions.
+ Local reward: a reward signal that reflects the performance of an individual agent or a subset of agents

### Credit Assignment Problem
+ how to determine how much each agent's action contributed to the total reward
+ Approaches:
  + Counterfactual baselines: estimate what would have happened if an agent had acted differently
  + Difference rewards: The contribution of each agent is measured by comparing the global reward when all agents are present to the global reward when a particular agent is removed or its actions are changed
  + Attention-based credit assignment

## Competitive Systems
+ Each agent has its own reward
+ Deterministic policies can be exploited by other agents, need to learn mixed policies
+ **Best Response Policy**: optimal policy depends on other agents
+ **Nash Equilibrium**: Collection of strategies such that each player's policy is a best response to the other player's policies. Comparable to deadlock -> nobody can improve by unilaterally changing its policy.
  + Nash Equilibrium might not be globally optimal
+ **Pareto optimality**: a state where no agent can improve its own reward without causing a decrease in the reward at least one other agent

### Non-Markovian Environment
+ Action outcomes are jointly determined by the actions of all agents
+ Environment is highly dynamic and non-stationary

## Game Theory
+ Symmetric game -> different person should give same policy/rewards
+ Zero-sum game = my reward + your reward = 0

### Q-Learning in Normal Form Games
+ Eyes wide shut approach: Independent Learner
  + Ignore other agents
  + Learning as if single learner
  + Interactions with other agents are considered noise
  + Resulting partial observability means convergence guarantees are lost

## MARL - Ad-hoc Techniques
### Learning Automata & Cross Learning
+ Policy iteration
+ Stateless environments
+ Assume finite action space
+ Uses immediate reward to update policy
+ Reward and penalty parameters
  + Reward: $\alpha \in [0,1]$ Penalty: $\beta \in [0,1]$
  + 𝛼 = 𝛽 linear reward penalty
  + 𝛽 = 0 linear reward-inaction
  + $\alpha \gg \beta$ linear reward-𝜀-penalty
  + 𝛼 = 1, 𝛽 = 0 cross learning
+ Guarantees valid prob distribution 𝜋 if $r \in [0,1]$

### Regret Minimization
Regret is a measure of the difference between the reward an agent could have achieved by always choosing the best action (in hindsight), and the reward it actually received by following its policy.

## MARL - Mathematically Grounded Techniques
(from gpt4)
### Joint-Action Learning
+ An agent learns policies based on the joint actions of all agents in the system.
+ Consider the actions of other agents while learning, as the state transition and rewards often depend on the joint action of all agents. 
+ The exponential growth of the joint action space with the number of agents is a significant challenge (curse of dimensionality). 

### MiniMax Q-Learning
Minimax Q-learning is a MARL algorithm designed for adversarial settings (zero-sum games). It's an extension of Q-learning that incorporates the minimax principle from game theory. The update rule is as follows:  

$$Q(s, a, b) \leftarrow Q(s, a, b) + \alpha [r + \gamma \min_{b'}\max_{a'}Q(s', a', b') - Q(s, a, b)]$$

Here, $a$ and $b$ are the actions of the two players, $r$ is the reward, $s$ and $s'$ are the current and next states, $\alpha$ is the learning rate, and $\gamma$ is the discount factor. The algorithm aims to find the optimal strategy that maximizes the agent's reward under the assumption that the opponent is playing optimally (minimizing the agent's reward).  

### Policy Hill Climbing
PHC is a policy search method in reinforcement learning. It's a form of gradient ascent on the policy space. At each step, it proposes a small modification to the policy and adopts it if it leads to improved performance. In the context of MARL, each agent can independently apply PHC to learn its policy, but this can lead to non-convergence issues due to the non-stationarity introduced by concurrent learning.

### Win or Learn Fast (WoLF)
WoLF is a principle for adjusting the learning rate in MARL based on whether the agent is 'winning' or 'losing'. The idea is to be cautious while winning (to avoid destabilizing a good policy) and to learn fast when losing. It's often combined with other methods like Q-learning. The WoLF principle helps mitigate some of the instability and non-convergence issues in MARL.

### Differences:
+ JAL considers the joint actions of all agents
+ Minimax Q-learning assumes an adversarial setting and uses game-theoretic principles
+ PHC is a simple policy search method that doesn't explicitly account for other agents
+ WoLF is a principle for adjusting the learning rate that can be used with various learning methods.

### Pros and Cons:
- JAL can be more accurate as it considers all agents' actions, but it suffers from the curse of dimensionality.
- Minimax Q-learning can find optimal strategies in adversarial settings, but it assumes that the opponents are playing optimally, which may not be the case.
- PHC is conceptually simple and can find good policies in some cases, but it can suffer from non-convergence in MARL settings due to the non-stationarity introduced by concurrent learning.
- WoLF can mitigate some of the instability and non-convergence issues in MARL, but the definition of 'winning' and 'losing' can be problem-dependent and hard to specify.