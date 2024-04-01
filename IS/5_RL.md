# Reinforcement Learning
+ Learning from **delayed** feedback: rewards/punishments
  + In computer science:
    + Pro-active software(agents)
    + Delayed reward or punishment = numerical value
+ State - Action -Transition - Reward - Policy
  + Sate: where am I now
  + Action: what will I do
  + Transition: How does this change where I am?
  + Reward: What do I get for being here and doing what I did
  + Policy: How should I behave

## Reinforcement Learning Problem
Learning what to do: situation to action mapping, a policy
+ Learning from interactions, not from examples
+ Delayed rewards, no direct feedback
+ Need to explore (and exploit)

## Single agent problem:
+ Given: 
  + Set of States: S
  + Set of Actions: A
  + (unknown) Transition function: $\delta:S\times A \rightarrow S$
  + (unknown) Reward function: $r:S\times A \rightarrow \Sigma$
+ Find:
  + Policy: $\pi$
  + such that $V^{\pi}(s_t) \equiv \sum^{\infin}_{i=0} \gamma^ir_{t+i}$ is  价值：预期将来得到的reward之和（期望）

### Nondeterministic Environments and Policies
+ Probabilistic Transitions: $P^a_{ss'}:S \times A \times S \rightarrow [0,1]$
+ Probabilistic Rewards: $R^a_s: S \times A \rightarrow \mathbb{R}$
+ Probabilistic Policies: $\pi(a|s): S\times A \rightarrow [0,1]$ 函数：输入是state输出是action 根据当前 state 来产生 action
  + also: $a = \pi(s)$, or $\pi(a|s) = P(a|s)$ 后者表示某种状态下执行某个动作的概率
+ Transition Model: $T(S, a, S')P_r(s'|s,a)$ 据当前状态 s 和动作 a 预测下一个状态 s’

#### Discounting Rewards
+ $r_t = \gamma r_{t+1}$
+ Influences:
  + Mathematically ensures that $V^\pi(s_t)$ is finite
  + Puts some time pressure on the agent

#### Utility/Value update rule (deterministic)
+ $V(s) = r(s, \pi(s)) + \gamma V(\delta(s,\pi(s)))$
  + Finite Horizon 有最大值上限（converge）
  + Receding Horizon 逐渐远离的视野：在控制理论中，指在每个时间步骤中，通过不断更新的优化问题来预测未来一段时间内的最优决策，然后只执行当前时间步骤的决策。
  + Average Reward
+ **Bellman Equation** (general case)
  + $V(s) = r(s, \pi(s)) + \gamma V(\delta(s,\pi(s)))$
  + Stochastic Transitions: $V^\pi (s) = r(s, \pi(s)) + \gamma \sum_{s' \in S} P_\delta (s, \pi(s),s')V^\pi(s')$
  + Stochastic Policy $V^\pi(s) = \sum_{a \in A} P_\pi (a|s) [r(s,a) + \gamma \sum_{s' \in S} P_\delta (s,a,s')V^\pi(s')]$
+ Exploration and Exploitation
  + Exploration: 探索 找到environment中可能达到的的values (比如找到不同policy下value的期望)
  + Exploitation：压榨 尽可能高的在这种情况下获得价值
  + exploration-exploitation dilemma: 探索-利用困境 
## Algorithm 动态规划求解 MDPs:

### Policy Evaluation
+ Given: $<S,A,t,r,\gamma>$ and a (deterministic) policy $\pi$
+ Find: $\forall s \in S: V^\pi(s)$

### Policy Improvement:
Value Function to Policy: $\pi_t(s) = \argmax_a [r(s, \pi(s)) + \gamma \sum_{s' \in S} P_\delta (s, \pi(s),s')V^{\pi_{t-1}}(s')]$

### Policy Iteration (Complete Algorithm) 解决的是 Control 问题,使用的是贝尔曼期望方程和贪心算法
+ Policy Evaluation - Policy Improvement
+ 基于当前的 Policy 计算出每个状态的 Value function
+ 同步更新：每次迭代更新所有的状态的 matrix:$\mathbf{v^{t+1} = R^\pi} + \gamma \mathbf{P^\pi v^k}$

### Value Iteration:
+ 类似只迭代1次 找到下一次能达到的最好的value
+ 最优化原理：当且仅当状态s达到任意能到达的状态 s' 时，价值函数 v 能在当前策略（policy）下达到最优，与此同时，状态 s 也能基于当前策略达到最优
+ Policy Iteration: $Evaluation \rightarrow Improvement \rightarrow Evaluation$
+ Partial Evaluation: $Full Backup \rightarrow Improvement \rightarrow Full Backup$
+ Value Iteration: $SingleStep \rightarrow Improvement \rightarrow SingleStep$
+ 值迭代：“寻求隐藏在大自然中的真理“ 策略迭代：利用经验去寻找正确的做法”
### Computing $V^\pi(s)$ in the non-deterministic case
1. Try it out multiple times and average = Monte-Carlo Estimation $\tilde{V}(s) \leftarrow \tilde{V}(s) + \alpha (V_{MC}(s) - \tilde{V}(s)), \alpha$: Learning Rate
2. By bootstrapping: $\tilde{V}(s) \leftarrow \tilde{V}(s) + \alpha (r +\gamma(\tilde{V}(s')) - \tilde{V}(s))$

## Model-free v.s. Model-based
+ Model-based 是指学习 Transition Model $T(S, a, S')$，即在状态 s 采取行动 a 后转移到 s' 的概率，然后基于这个 Model 去选择最优的策略。Transition Model 的空间复杂度为$O(S^2A)$，所以不太适合用于解决状态空间和动作空间过大的问题。
+ Model-free 未知 Transition Model，通常通过不断的尝试去直接学习最优策略。
+ 前面的 Policy Iteration 和 Value Iteration 都是 model-based 方法，因此一定程度上受限于状态空间和动作空间的规模。于是 Q-learning 应运而生。

### Model-free: State-Action Values
+ State-Action values (Q-values): $Q(s,a) \equiv r(s,a) + \gamma \sum_{s'\in S}P_\delta(s,a,s')V^{\pi_{t-1}}(s')$

### $\epsilon - Greedy$
+ Make choose by greedy for most of time, but also do some random choose by random possibility $\epsilon$
+ 可以与value差值挂钩 不大的时候随机 大的时候贪婪

### Boltzmann (related to softmax)
+ 按离散概率分布选择a

## Q-learning
+ Model-free: no need to know $P_\delta (s,a,s')$
+ Exploration independent (= off-policy)
+ $Q(s_t,a_t) \leftarrow Q(s_t, a_t) + \alpha [r_t + \gamma max_{a'} Q(s_{t+1}, a') - Q(s_t, a_t)]$

### Bucket brigade value updating
+ Faster convergence possible by
  + remembering path followed during episode
  + update all Q’ value values on path, in reverse order

### Greedy in the Limit with Infinite Exploration (GLIE)
+ All state-action pairs are explored infinitely many times
+ The policy converges on a greedy policy

## State-Action-Reward-State-Action (SARSA)
+ 与 Q-learning 的不同是，SARSA 是 on-policy 方法，需要考虑 exporation-exploitation 问题
+ exploration evolution is key
+ $Q(s_t, a_t) = (1-\alpha )Q(s_t,a_t) + \alpha [r_t + \gamma Q(s_{t+1}, a_{t+1})]$

### Differences with Q-learning:
+ Q learning is off policy:
  + Ity will learn the optimal policy values, as long as there is enough exploration
  + It does not learn the values of the exploration strategy
+ SARSA is on policy
  + It will learn the values for the policy being followed
  + If you want it to learn the optimal policy, the exploration strategy need to be evolve into a greedy policy.

## Larger Environments
+ Curse of dimensionality: Table size increases exponentially in the number of attributes of states (and actions)
+ RL: Value functions (V and Q) try to summarize everything still to come and thus create a label for each state or state-action pair.
+ Do supervised learning using an appropriate regression technique resulting in a Q-function $Q(s,a,\omega)$ instead of a Q-table

### estimates for Q
1. MC (Monte Carlo) estimates as targets
  + $Q(s,a) = \sum_{i=0}\gamma ^ i r_i$ Unbiased but noisy samples
  + Converges to a global optimum for linear functions
  + Even works with non-linear function approx. (local optimum)
2. SARSA estimates as targets
  + $Q(s_t,a_t) = r_t + \gamma Q(s_{t+1},a_{t+1})$ Biased sample
  + with linear function approximation converges close to global optimum
3. Q-learning estimates as targets
  + $Q(s_t,a_t) = r_t + \gamma max_aQ(s_{t+1},a)$ Unstable biased sample
  + Not guaranteed to converge

### Policy Search:Values are great but …
+ Unstable under generalisation
  + Labels change while learning
  + Samples are not IID

### SNES: Separable Natural Evolution Strategy

### Estimating the gradient
$\mathbb{E}_\pi [Q^\pi (s,a) \nabla_\theta log(\pi(s,a,\theta))]$