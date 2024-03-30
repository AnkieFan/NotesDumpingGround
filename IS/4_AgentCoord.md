# Multi Agent Coordination

## Coordination:
+ Malone & Crowston, 1994: Managing dependencies between activities
+ Malone & Crowston, 1991: Special case of interaction in which agents are aware of their dependencies on other agents and adjust accordingly
+ Stirling 1994: Any decision that uses information concerning the existence, decisions or decision-making strategies of others

## Characterizing Cooperative Systems
+ Environment
  + Diversity
  + Dynamics
  + Predictability
+ Cooperating Entities
  + Frequency
  + Levels
  + Patterns
+ Cooperation
  + Number
  + Homogeneity
  + Goals

### Types of Interdependency
+ Prerequisite: output of one activity is required by the next activity
+ Shared resource: Resource required by multiple activities
+ Simultaneity: Time at which more than one activity must occur

### Motivation for coordination over central control
+ Principle of Bounded Rationality (Simon1957):
  + Human's processing capacity is limited
  + Increasing complexity of computer program architecture & design
  + Divide & Conquer makes this possible for hyper complex tasks

## Basic Models and Mechanisms for Coordination

### Standard Client-Server
+ Client: sends requests for operations to another process
+ Server: receives requests for operations from another process
+ Service: operational subject of request by some client
+ Client and Server can be dynamically played by processes
+ Pros:
  + simple control structure
  + simple synchronization
+ Cons:
  + server can be a bottleneck
  + poor failure tolerance
  + information used by servers may be out of date (communication delays)
  + May be solved by server replication, but that removes the advantages

### Task and Results Sharing
+ Idea: divide and conquer
+ can be tackled using MapReduce
+ Subtask relations:
  + Disjoint
  + Overlapping
  + Subsuming
  + Identical
+ Potential Advantages:
  + Each sub-problem can be solved with less knowledge
  + Each sub-problem requires less resources
  + Parallelism and robustness
  + Use of multiple sources of knowledge and skills
+ Key Challenges:
  + Realizing advantages requires careful design
  + Connection problem:Who is responsible for what
  + Distribution of knowledge
  + Cost of control: loss in computing resources
  + Level of task decomposition

### Blackboard System
+ Shared memory with read and write control(on common memory area)
  + Independently or coordinated
  + Address of sender needs not to be known
+ Allows for heterogeneous processes: different languages, different paradigms
+ Participants decide:
  + information announcement(when, whether, ...)
  + information search and evaluation
+ Suited for open applications, e.g.: event/data driven (people can contribute unscheduled add-ons)
+ Can implement various data structures
+ Regionalization/Structuring is possible if required for e.g. efficiency

#### Pros and Cons (not in slides)
+ Pros:
  + Decentralized sharing of information
  + Asynchronous access & modification of shared memory
  + Handles heterogeneous agents with different capabilities
  + Supports real-time coordination
+ Cons:
  + Shared memory may become a bottleneck
  + Shared memory may become corrupted or inconsistent
  + May not be suitable for certain problems or environments
  + Vulnerable to security threats or attacks
  + Requires significant coordination overhead and complexity for design of communication protocolsRobot Operating System

#### Robot Operating System:
+ Nodes push messages on specific topics through specific channels
+ subscribe to the channels

### Contract Net Protocol
+ **Network of Nodes**:
  + managers: announce tasks
  + contractor: bids for right to carry out task
  + best bid selected by manager
+ Flexible and distributed control
+ dynamic roles (agent can act as manager and contractor)
+ Task Announcement:
  + Eligibility specification (minimal requirements on potential contractor)
  + Task abstraction (short description)
  + Bid specification (its structure and contents)
  + Expiration date
+ Properties:
  + Middle ground between Client-Server and Blackboard
  + Design issues:
    + What tasks should be announced?
    + Who should receive a specific announcement
    + Why should a potential contractor bid?
    + Selection criteria for managers in case of multiple bids?
    + Selection criteria for contractors in case of multiple announcements?

### Functionally Accurate Cooperation (FA/C)
= guideline for cooperation when the individuals’ local knowledge is **incomplete**, **uncertain** and **inconsistent**
+ functionally correct = acceptable and reasonable from a local point of view
+ cooperation = iterative refinement, transformation of local into global correctness
+ Requirements:
  + Well-defined and predictable tasks
  + Measure for functional correctness
  + Detection of inconsistencies
  + Integration of consistent part of received partial results into local database
  + Revision of own results on the basis of incoming data

## Advanced Models of Coordination
+ Auctioning 拍卖
+ Voting
+ Negotiation
+ Joint Planning
+ Commitments and Conventions

## Auctioning
+ English Auction(First-price open cry)
  + Traditional auction: bidders raise hands to predefined amount
  + Auction ends when no bidder is willing to raise
  + Highest bidder wins at price of his bid

+ Sealed-bid auction
  + Each bidder submits one bid without knowing other bids
  + Highest bidder wins and pays:
    + First-price: amount of own bid
    + Second-price(Vickrey): amount of second highest bid (motivate highest bidding)

+ Dutch (descending) auction
  + Seller continuously lowers price
  + Auction ends when one of the bidder buy item at current price
  + Need to be faster than other buyers
+ Japanese: n lowest bidders are excluded from next rounds

### Auction characteristics
+ Valuation of goods/services
  + _private value_: bidders estimate of value depends on own preference
  + *common value*: bidders estimate of value depends on what others are willing to pay
  + *Coorelated value*: partly private partly common
+ Risk Attitude

### Auction Theory: Expected Outcomes
1. **English, Dutch, First-price & Second-price Sealed-bid produce** same expected revenue to the auctioneer in **private value** auctions where values are independent and **bidders are risk neutral**
2. **Dutch and First-price Sealed-bid** have higher expected revenue to auctioneer compared to English or Vickrey among **risk averse bidders**规避风险的投标人
3. **Second-price Sealed-bid or English** achieve higher expected revenue for **risk averse auctioneers**规避风险的拍卖商 then Dutch and First-price Sealed-bid

#### Issues:
+ *Dishonest auctioneers*: may misrepresent information or manipulate the auction process
+ *Bidder collusion*: bidders may collude勾结 to manipulate the auction process
+ *Counterspeculation*: agents may gathering information about other bidders or the auction process to gain an advantage in the auction

## Voting Systems - Plurality多数 Protocols
+ simultaneous voting on multiple alternatives
+ highest number of votes wins
+ Spoiler effect problem: Irrelevant alternative can split majority
  + The more candidates a side has, the less power your vote has

### Binary Protocol
+ alternatives are voted pairwise
+ winner stays, and will be compared to another alternative
+ surviving alternative is final winner
+ Problems:
  + Irrelevant alternatives influence vote
  + Agenda (order of pairings) determines outcome

### Borda Count
+ Ranked choice voting: highest points for first place on voter's ranking
+ Highest total points wins
+ Problem: irrelevant alternatives influence outcome 

## Negotiation
= Exchange of information in multiple rounds for the purpose of coming to an agreement

## Joint Planning
+ General Taxonomy of planning
  + Single-component approaches
  + Multi-component approaches
    + Single planner + multiple executors
    + multiple planners + single executor
    + multiple planners + multiple executors
+ Relationships among plans:
  + Positive:
    + Equality: Plans have some effect
    + Subsumption: Effect of plan A covers effect of plan B
    + Favorableness: minor modification of plan A reduces efforts for plan B
  + Negative:
    + Resource conflicts
    + incompatibility of activities and states

### Partial Global Planning (Durfee ‘88)
+ Joint Planning version of FA/C
+ General Coordination Schema: No assumptions about sub-problems, expertise or resource
+ Idea:
  + Problem broken down into sub-problems
  + Each agent plans its sub-task based on local information
  + Communicates with other agents to resolve conflicts & ensure coherence
+ Components:
  1. **objective**: why PGP exists, including its goal
  2. **plan-activity map**: what the parties are doing, major current plan steps (including costs and expected results)
  3. **solution-construction-graph**: information about how the parties should interact, what results should be exchanged and when to exchange them
  4. **status**: bookkeeping information
+ Key limitations:
  + Local actions may be executed without agreement
  + Plan coordination is based on simple level of abstraction, no long term goals in mind

## Commitments and Conventions
### Commitments
as a first class modeling abstraction:  
+ Types:
  + *Joint commitment*: joint activities with others
  + *Precommitment*: decision to be involved in the future
  + *Leveled commitment*: can cancel under penalty
+ Operations:
  + *Create*: initiate commitment
  + *Discharge*: success case, commitment was satisfied
  + *Cancel*: failure case, revokes the commitment
  + *Release*: neutral elimination of the commitment
  + *Delegate*: shift role of debtor to other agent
  + *Assign*: shift role of creditor to other agent

### Conventions约定
Rules for allowing/forbidding reconsideration of commitments
+ Motivation:
  + World may change in between commitment and actual time of event
  + Conventions make agents more dynamic, able to react to change
+ Key Challenges:
  + Model reliability of agents: decrease when commitments are broken too often
  + Balance between being impulsive and being an overthinker: never/always reconsider commitment
+ Social convention:
  + how to behave when commitments alter
+ Centrality Hypothesis of Commitments & Conventions (Jennings, 1993):
  + Coordination = commitments + conventions