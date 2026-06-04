### 8.
Skip-gram with negative sampling  approximates the denominator of the probability function. Instead of computing the exponential sum for the entire vocabulary to normalize the probability distribution, the model only computes it for the target context word and a small number k of randomly sampled "noise" words (negative samples). This basically turns a multi-class classification task where the model must predict the correct context word out of thousands of option into a binary classification task like, weather this specific word pair a true center-context pair, or is it noise.

Mathematically, this objective is maximized by increasing the probability of the observed pair and decreasing the probability of the negative samples. The training objective is:

### 9.
1. Semantic Similarity: it groups words that share the same conceptual category or topic.

Evidence from greenish: The neighbors are all colors (e.g., bluish, reddish, pinkish), showing the model understands the semantic field of color.

Evidence from poured: The neighbors are all actions related to liquids or cooking (e.g., sipped, boiled, spilled, drank), showing the model captures the specific domain of meaning associated with the verb.

1. Syntactic and Morphological Similarity: including the part of speech and specific morphological inflections (suffixes or tenses). This occurs because words with the same grammatical form tend to appear in identical syntactic contexts.

Evidence from greenish: The neighbors are not just colors, but specifically adjectives that share the -ish suffix (e.g., brownish, silvery, whitish). It does not list the noun forms like "green" or "blue".

Evidence from poured: The neighbors are all verbs in the past tense (e.g., simmered, drained, splashed). It does not list the infinitive forms like "pour" or "drink".

### 10.
These errors arise because of the distributional hypothesis, which states that words are similar if they share similar linguistic contexts. In  this case, they have similar contexts for antonyms: Antonyms like smaller and larger, or hotter and colder, tend to occur in almost identical sentences (e.g., "X is ___ than Y"). And then because they share such similar contexts, the model learns very similar vector representations for them. As noted in the lectures, distributional similarity is a broad notion that encompasses not just synonyms, but also antonyms and other related words. When the model performs the vector arithmetic for the analogy, it successfully identifies the correct grammatical form (a comparative adjective) and the correct semantic field (size or temperature). However, because the vectors for the correct word (e.g., smaller) and its antonym (e.g., larger) are so close in the vector space, the model sometimes retrieves the opposite meaning by mistake.