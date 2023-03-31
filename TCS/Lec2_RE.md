# Regular Expressions
+ The expression 𝟎∗𝟏𝟎𝟎∗𝟏𝟎∗(𝟏𝟎∗ ∪ ∅∗) is called a regular expression.

## Basic Cases
+ $\empty$ denotes the empty language $\empty$
+ $\varepsilon$ denotes the language $\{\varepsilon\}$
+ $\alpha$ denotes the language $\{\alpha\}$, $\forall$ symbol $\alpha \in \Sigma$
+ Order of operators: ∗ > ∘ > ∪


## Inductive Case: 
Let $R_1, R_2$ be RE corresponding to languages $L_1, L_2$  
+ $(R_1 \cup R_2)$ (also denoted as $R_1 + R_2$) is RE and denotes $L = L_1 \cup L_2$
+ $(R_1 \circ R_2 = R_1R_2)$ is RE and denotes $L_1 \circ L_2 = L_1L_2$
+ $R_1^*$ is RE and denotes the language $L_1^*$
  + $R^*$ mean any number of concatenations of strings that can be constructed by R

## Regular Languages
+ There is some RE R that describes L
+ Every finite language L is a regular language
+ show that a language 𝐿 is described by a RE 𝑅:
  + Each string of L is described by R
  + Each string produced by R belongs to L

## Addition
+ $\varepsilon$ is a regular expression that corresponds to the language which contains a single string, and this string is simply the empty string
+ $\empty$ is that corresponds to the language that contains no strings at all!

## Description
+ $(b \cup a)^*$:  The concatenation of substrings that are either a or bb. So we see that the b symbols appear in pairs of consecutive symbols and so we conclude that this regular expression describes the language of all strings such that all maximal substrings of b symbols have even length.