### 1.
1. Word windows: A context is defined as the n words surrounding the target word in the text
2. Lexeme window: Same idea as above, but using lemmas or stems instead of surface forms.
3. Syntactic dependency contexts: Context for a lexical item is the syntactic dependency structure it belongs to.
4. Document/BoW contexts: The context is defined as all other words occurring within the same document or larger text unit (entire vocabularies or text regions).

### 2. 
PMI calculates how much more likely the context is for the word than it is on average across the whole corpus. It compares how often the word and context actually occur together $P(c|w)$ versus how often we would expect them to occur together just by chance $P(w)$. If they occur together more than expected, PMI is positive. If less than expected, PMI is negative. If just as expected, PMI is zero.

### 3.
The word *w* occur very rarely in the corpus means: $f(w)$ is very small. Because $f(w)$ appears in the dominator of PMI(w,c), it will makes the likelihood P(c|w), and in the end PMI(w,c), very large. This means even its just random or accidental co-occurrence, it still look like there is a special pattern. As a result, a single co-occurrence f(w,c)=1 can produce a very high PMI, and PMI interprets this as a strong word–context association, even though it may be a statistical accident.

### 4.
Experiment 1: 
Type of Similarity: Paradigmatic similarity. The words in each cluster are syntactically and semantically interchangeable. They can typically fill the same 'slot' in a sentence (e.g., 'I rode the bike/train/bus'). This shows the experiment likely used small context windows (e.g.: one word to the left/right) or syntactic dependencies to define context, forcing the model to find words that have the same immediate neighbors.
Lexico-Semantic Relations: The clusters show synonymy or co-hyponymy. For example, in the first cluster: carriage, bike, and train are all co-hyponyms sharing the common hypernym "vehicle". In the third cluster, sister, daughter, and parent share the hypernym "relative".

Experiment 2:
Type of Similarity: Syntagmatic similarity. The words in each cluster are thematically associated and tend to co-occur within the same broader context or document, but they are not necessarily interchangeable (e.g.: we dont say 'I rode the petrol/road'). This shows the experiment likely used large context windows, leading the model to group words that belong to the same topic.
Lexico-Semantic Relations: The clusters show general topical associations, like: driver operates a car on a road; singer performs on a stage at a concert. These are functional or situational associations rather than taxonomic ones.

### 5.
This is already being briefly discussed in previous question. But in detail, the design choices might be:
1. The Size of the Context Window
If both experiments used linear windows:
Experiment 1 (Small Window): This experiment likely used a very small context window (e.g., n=1 or immediate neighbors) When context is restricted to immediate neighbors, the model focuses on local syntax (e.g., words that are preceded by "the" or followed by "is"). This constraint makes the clusters group words with high paradigmatic similarity because they share the exact same immediate surroundings.
Experiment 2 (Large Window): This experiment likely used a large context window (e.g., whole documents or wide windows of 50+ words). A larger window captures the general topic of the discourse rather than specific syntactic slots. This leads to syntagmatic clusters, grouping words that engage in topical associations (e.g., doctor, hospital, medicine) because they frequently appear in the same long spans of text, even if they don't share the same immediate neighbors.

2. Whether the model looks at the linear sequence of words or the grammatical structure of the sentence.
Experiment 1 (Syntactic Relations): This experiment likely defined context using syntactic dependencies (e.g., subject-verb or adjective-noun relations). By tracking which words modify the same heads or serve as subjects for the same verbs, the model identifies words that function identically in a sentence. This results in paradigmatic clusters containing words that are grammatically and semantically substitutable, such as truck and lorry.
Experiment 2 (Linear/BoW): This experiment likely defined context using a simple linear window or bag-of-words approach. By counting which words appear near each other regardless of grammatical role, the model captures co-occurrence. This results in syntagmatic clusters containing words that are topical related and found in the same "scene" or topic, such as driver and road.

### 6.
Prepositional Phrase (PP) attachment ambiguity occurs when a sentence contains a prepositional phrase that can be syntactically attached to more than one preceding head word (usually a verb or a noun), resulting in different meanings.
Example: Consider the sentence: "I eat pizza with anchovies.". This sentence has two distinct structural interpretations (parses):
NP Attachment (Noun Phrase): The PP "with anchovies" attaches to the noun "pizza." Meaning: The pizza has anchovies on it (it is an anchovy pizza).
VP Attachment (Verb Phrase): The PP "with anchovies" attaches to the verb "eat." Meaning: I am using anchovies as an instrument to eat the pizza (alongside the "I").


Why is this challenging for a syntactic parser:
The challenge arises because: Both attachments are grammatically correct. The rules NP -> NP PP and VP -> VP PP are both valid standard rules. Standard Probabilistic Context-Free Grammars (PCFGs) rely on the probability of rewrite rules. However, these probabilities are often insufficient because the correct attachment depends on the semantic compatibility of the specific words involved (e.g., "pizza" and "anchovies" vs. "eat" and "anchovies"), not just their syntactic categories. As noted in the text, ambiguity grows with sentence length, making it difficult for structural rules alone to resolve the meaning.

Using Distributional Semantics for Disambiguation:
Distributional semantics operates on the hypothesis that words with similar meanings share similar linguistic contexts. These models represent words as dense vectors (embeddings) where semantic similarity is calculated as the distance between vectors. Techniques from distributional semantics can help a parser by introducing lexical preferences. Instead of just looking at the structural probability P(Structure), the system can look at the semantic likelihood of the words interacting. 
For example, in the "pizza" example, a distributional model would likely find that the vector for "anchovies" is spatially closer (more similar) to "pizza" (food ingredients context) than to "eat" (instrument context). Conversely, in "I eat pizza with a fork," "fork" would have a strong semantic association with "eat."




### 7.
The Problem: Computational Expense
The original skip-gram model is trained on a large corpus and the softmax function becomes computationally expensive to calculate
The Reason: To normalize the dot product results into a probability distribution using softmax, the model must calculate a denominator that consists of the sum of exponents for every word in the entire vocabulary. However, in a large text corpus, the vocabulary size is very huge. Calculating this sum for the whole vocabulary for every single training instance is too expensive and inefficient.