## 1.

1. **PCFG**: moreover the cast and the producers begins in the past where it could have been so much brighter
   + The sentence has a proper syntactic structure, like proper clause structure and coordination. This is because PCFG trained on full parse trees which leads to producing globally coherent syntax. 
   + Content words combine meaningfully. This is because PCFG uses lexical probabilities conditioned on syntactic positions, which tends to produce plausible thematic content.
   + There is small syntax error like 'and the producer begins', but not serious. This is because PCFG is not enforced by CFG rules so there might be agreement errors.

2. **NB (BoG)**: intuition who direction cast great but what spaceship sharply theme buys 
    + There is no syntax, no local word ordering, only incoherent nouns in this sentence. This is because NB with BoG only looks at overall word frequency. Sampling from BoG yields sequences of common class-specific words in random order.
    + Topic changing very abrupt. This is because NB generates words independently with no phrase structure and no n-gram coherence.

3. **Trigrams**: the plot and the cast is okay but not too deep in the story and the acting and the ending .
   + The local frequency is strong but global syntax is weak. For example 'and the acting and the ending' is locally plausible and common in movie reviews. But the whole sentence is repetitive and drifts, which is a common issue of higher-order n-gram models.
   +  Conjunction patterns repeats a lot, llike 'and the ... and the...'. This is because trigram LMs overfit to frequently observed trigrams like it.
   +  The sentence is grammatical at surface level but lacks hierarchical structure beyond what a trigram LM can model.

4. **Unigram**:a the too 's the be to awry ) they and 's dreamworks admit what . other friend have
   + There is no grammar, no phrases, no content, random punctuation, just grabbing a weighted frequency from bag of words. This is because unigram doesn't count other words into account so it cannot see any relationship between current word and others.
5. **HMM**: a entire performances is not many write under cast where he might actors
   + The sentence has coherent POS but the grammatical sequences is wrongly formed. HMM generates words using transitions over POS tags, which produces sentences with reasonable POS patterns but incorrect lexical choices. For example: “is not many write under cast” → AUX + PART + ADJ + VERB + ADP + NOUN (tags good, words wrong)

### 2a
No, the student should not be disappointed, because sthe log-linear bigram LM is mathematically equivalent to a tabular bigram LM and cannot generalise beyond it given the way the model is designed.
For a bigram LM, the history h contains exactly one word. The students define $\phi(h) \in R^V$ counts how many times each word occurs in the history. But in a bigram setting, the history only contains **one** word, which makes $\phi(h)$ one-hot: exactly one entry is 1 (the history word), and the rest are 0. Therefore, $W\phi(h) = W_{:, w_h}$, which is simply the column of W corresponding to the history word. Then the model compute: $P(W = w|h) = Softmax(W_{:,w_h}+b)$. This is exactly a table of size $V \times V$, one column per history word, one row per next word. This is identical to a tabular bigram LM.

### 2b
It is because the model does not need to store a separate parameter vector for each history. It only stores a single parameter matrix $W$ and vector $b$, and shares parameters across all histories.

A tabular 10-gram LM must store a parameter vector for every possible 9-word history. A classic N-gram LM stores $P(w_t|w_{t-1}, ..., w_{t-9})$, which requires a full lookup table indexed by all 9-word histories. In this case the number of total parameters is $O(V^{10})$, which is impossible to store.

The student’s log-linear 10-gram LM uses a distributed representation instead of lookup table. The feature function is $\phi(h) \in R^V$. For a 9-word history, $\phi(h)$ has $V$ dimension, 9 non-zero entries and more important, no dependence on the order of the 9 words. This compresses the entire 9-gram history into a single $V$ dimensional bag-of-words vector. The model has only $W$ with size $V \times V$, $b$ with size $V$. So the number of total parameters is $O(V^2)$, which is exponentially smaller than $O(V^{10})$

### 2c.
It is because the student’s model does not actually use 10-gram history. It only uses a bag-of-words summary (in another word, lexical histogram) of the previous 9 words.

Again the feature function $\phi(h)_i = \text{\#times word i occurs in the last 9 words}$. There is no order/position information and no syntactic patterns. So different contexts can collapse into the same vector. It compresses the 9-word history into a bag of counts, therefore it does not capture genuine long-range dependencies, and cannot condition predictions on syntactic or semantic structure. While the real n-gram LM preserve the order of words so the history is encoded more meaningfully.


### 3b.
In an HMM POS tagger, each word’s tag is chosen based on the tag–tag transition probability $P(t_i|t_{i-1})$ and the tag-word emission possibility $P(w_i|t_{i})$. Since Noun–noun sequences are very common in English, especially compound nouns (“catamaran trailer”, “office chair” etc.),  $P(NOUN|NOUN)$ would be relatively high. So the first noun in a noun–noun sequence is often mis-tagged as an adjective, because the model expects a noun-to-noun transition. Besides, many adjectives are rare, and some adjectives are also valid nouns. For example 'trail', $P(trail|ADJ)$ may be lower than $P(trail|NOUN)$. So the tagger often prefers NOUN over ADJ in prenominal position.