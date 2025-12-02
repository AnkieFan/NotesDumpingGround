## a. it snows
Identification: Pleonastic Pronouns
Explanation: The word "it" does not refer to any specific entity or object in the real world. It is semantically empty and serves only a syntactic function.
Complication for Models: A standard compositional model looks for the meaning of "it" (typically a reference to an object) to combine with "snows." In this context, the "part" (it) contributes no semantic content to the "whole." On the other hand, the model must distinguish between a referential "it" (e.g., "it barks" -> the dog barks) and a pleonastic "it" (e.g., "it rains") where the pronoun should be ignored semantically

## b. rock the boat
Identification: Idioms (Non-compositional Phrases)
Explanation: This phrase is an idiom. The meaning "to disturb an existing situation" cannot be derived by combining the literal meanings of "rock," "the," and "boat".
Complication for Models: The primary assumption of compositional semantics fails here. The system needs to recognize "rock the boat" as a single multi-word expression with its own entry in the lexicon, rather than building it up from parts. As noted in the lecture, idioms can often still be interpreted compositionally (literally moving a boat back and forth). A model cannot simply "block" the literal meaning; it must decide between the idiomatic and literal sense based on context.

## c.
Identification: Logical Metonymy
Explanation: The verb "enjoy" semantically requires an event (enjoy doing something). However, "cigarette" and "book" are physical entities, not events. The composition forces an additional meaning to arise: we infer "enjoy smoking a cigarette" or "enjoy reading a book".
Complication for Models: The model cannot simply combine the explicit parts. It must infer a hidden predicate (smoking/reading) that is not present in the text, while it changes based on the noun (e.g., "Enjoy" + "book" implies reading). The model requires knowledge about how specific objects are typically used to resolve the meaning correctly.

## d.
Identification: Metaphor
Explanation: Meaning transfers and additional connotations can arise through composition. 
"Inject hydrogen" is literal: a physical substance is introduced into a container/body.
"Inject life" is metaphorical: an abstract quality (vitality/energy) is introduced into a situation or person.
Complication for Models: A model needs to handle the fact that combining "inject" with abstract nouns creates a new, non-literal meaning that shares structural similarity but operates in a different semantic domain.

## e.
1. These models treat combinations of words identically regardless of their sequence or grammatical role. As a result, they cannot distinguish between sentences containing the same words but different meanings, such as "John hit the ball" and "The ball hit John".
2. Vector mixture models are generally more suitable for combining content words (nouns, verbs, adjectives) and do not work well to function words like conjunctions or prepositions. For example, they struggle to capture the semantic nuances in phrases like "some dogs," "lice and dogs," or "lice on dogs".

## f.
Lexical function models address the limitations by fundamentally changing how different types of words are represented and combined. Instead of treating every word as a static vector to be simply added or multiplied, these models introduce a distinction between words that act as arguments and words that act as functions. In this framework, content words like nouns retain their representation as distributional vectors because their meaning is directly determined by their context. However, words that modify others, such as adjectives or verbs, are modeled as functions that transform the distributional profile of the words they modify.

To solve the specific issue of insensitivity to word order and syntax, lexical function models use linear transformations rather than symmetric operations. For instance, in the approach proposed by Baroni and Zamparelli, an adjective is represented as a parameter matrix while the noun remains a vector. The meaning of a phrase like "old dog" is derived by multiplying the adjective matrix by the noun vector. Because the order of matrix multiplication operations matters, this method inherently respects the syntactic structure of the phrase, allowing the model to capture the specific directional relationship between the modifier and the head noun.

## g. lec 6, page 24-27
In lexical function models, adjectives are represented as parameter matrices rather than simple vectors, distinguishing them as "functions" that operate on "arguments" (nouns). While a noun is modeled as a distributional vector that reflects its static meaning, an adjective is viewed as a function that transforms the meaning of the noun it modifies. Consequently, the semantic representation of an adjective-noun phrase (e.g., "old dog") is derived through a linear transformation: the adjective's matrix is multiplied by the noun's vector to produce a new vector representing the composed phrase.

To learn these matrices, the model uses a supervised learning approach based on linear regression using data from a text corpus. The process begins by obtaining standard distributional vectors for a set of nouns (e.g., "house," "dog") and obtaining separate distributional vectors for the corresponding adjective-noun(AN) phrases (e.g., "old house," "old dog") by treating each phrase as a single unit in the corpus. These pairs of noun vectors and phrase vectors form a training dataset for that specific adjective. The algorithm then learns the adjective's matrix by finding the weights that best map the input noun vectors to their corresponding phrase vectors, specifically by minimizing the squared error loss between the predicted phrase vector and the actual observed phrase vector.

## h.
1. Train the lexical functions(as shown in above question):
   1. Build distributional vectors for nouns $n_j$ and for observed AN phrases $p_{ij}$
   2. For each adjective $a$, learn a matrix $A_a$ that maps a noun vector $n$ to the AN phrase vector and train $A_a$ with linear regression to minimize squared error $L(A_a) = \sum_{j \in D(a)} || p_{ij} - A_a n_j ||^2$
2. Score paraphrase for a specific phrase a n
   1. Target vector $v_{a,n} = A_an$ 
        e.g.: $v_{target} = A_{smart}\times n_{students}$
   2. For every candidate adjective b (same POS), compose $v_{b,n} = A_bn$
        e.g.: $v_{candidate} = A_{clever}\times n_{students}$
   3. Score the paraphrase by calculating the cosine similarity between the target vector and each candidate vector
   4. Selection: The candidate adjectives that produce the highest cosine similarity scores are considered the best paraphrases. If $A_{clever} n_{students}$ is spatially close to $A_{smart} n_{students}$, the model predicts that "clever students" is a valid paraphrase for "smart students"

## i.
1. Train the lexical functions, same to the previous one, but more focus on synonym learning. In this example, train a matrix for the ambiguous adjective $A_{warm}$ using all available AN pairs (e.g., "warm tea," "warm person," "warm weather," "warm welcome"). And then train matrices for unambiguous synonyms that correspond to the specific senses we want to distinguish. In this case: Sense 1 (Temperature): Train $A_{hot}$ or $A_{tepid}$.Sense 2 (Personality): Train $A_{friendly}$ or $A_{kind}$. The objective function remains the same with 1h.
2. Score paraphrase
   1. Compute the vector for the ambiguous phrase: $v_{warm\_tea} = A_{warm} \times n_{tea}$ and $v_{warm\_person} = A_{warm} \times n_{person}$
   2. Apply the matrices of the distinct synonyms to the same noun to generate reference points
    For *Tea*: Compute $v_{hot\_tea} = A_{hot} \times n_{tea}$ and $v_{friendly\_tea} = A_{friendly} \times n_{tea}$.
    For *Person*: Compute $v_{hot\_person} = A_{hot} \times n_{person}$ and $v_{friendly\_person} = A_{friendly} \times n_{person}$.
    3. Measure the cosine similarity between the target vector and the candidate vectors
        $Score_{temp} = \text{Cosine}(v_{warm\_tea}, v_{hot\_tea})$
        $Score_{pers} = \text{Cosine}(v_{warm\_tea}, v_{friendly\_tea})$
    4. Selection:
        If $Score_{temp} > Score_{pers}$, the model concludes "warm" is functioning in its Temperature sense
        If $Score_{pers} > Score_{temp}$, the model concludes "warm" is functioning in its Personality sense

## j
Relation: Justification 
Explanation: The second sentence provides the underlying reason or evidence regarding the health risks of pollution to explain why diesel use has come under scrutiny as stated in the first sentence.

## k
Relation: Consequence 
Explanation: The second sentence describes the negative health effect that occurs as a direct consequence of the formation of ground-level ozone described in the first sentence.

## l
Relation: Elaboration 
Explanation: The second sentence provides a specific example of the general "steps" mentioned in the first sentence by detailing the ban on older vehicles.

## m
Spans: Run a BiLSTM over the document words. For each candidate span i take: the BiLSTM output at the start and end tokens, an attention-weighted sum over the tokens inside the span (a soft “head” word), and a learned span-width feature.

Mention-pair (antecedent): For a mention i and candidate antecedent j, feed an FFNN the concatenation of $g_i, g_j$, the element-wise product $g_i \cdot g_j$, and a small feature vector $\phi (i,j)$ with surface/metadata cues (e.g., distance buckets, same-speaker flag, genre embedding). The network outputs a score for j being an antecedent of i.

## n
Idea: Augment the mention-pair scoring function by injecting external semantic knowledge. The standard Lee et al. model relies on surface-level embeddings ($g_i, g_j$), which often fail to capture logical relationships between definite expressions. We can extend this by computing a semantic relation feature vector between the head words of the candidate antecedent and the anaphor.

Implementation:
1. Use the model's existing attention mechanism to identify the head word of the antecedent span (e.g., "clothes") and the anaphor span (e.g., "jacket").
2. Query an external knowledge base (like WordNet) to determine if a specific relation exists between the two heads. Encode this as a binary feature or a low-dimensional embedding
3. Concatenate this relation vector ($r_{ij}$) to the existing pair representation before passing it to the scoring network

Relevant Semantic Relations:
Hyponymy / Hypernymy (Is-A): This is the relation exhibited in the example provided. "Jacket" is a hyponym of "clothes" (Hypernym). The model needs to know that a jacket is a type of clothing to resolve the link. (Actually in this case, they are more like set–element that jacket ∈ clothes, but Is-A makes sense too for me)
Meronymy / Holonymy (Part-Whole): This is crucial for bridging resolution. For example, linking "the house" (Holonym) to "the roof" (Meronym). The model needs to know the roof is part of the house.

## o
Reason: The model is likely influenced by recency bias. Neural models often weigh the distance between the anaphor ("it") and the candidate antecedent heavily. Since "the cat" is the closest noun phrase to "it," and both "dog" and "cat" are semantically compatible with the pronoun "it" and the adjective "excited," the model defaults to the nearest valid option.

Missing Factor: Causal Reasoning. The model lacks the world knowledge that excitement is typically the cause of chasing behavior (attributed to the agent/dog), whereas fear is typically the reaction of the one being chased (the patient/cat).

## p
Reason: Recency bias that similar to the previous example. "The tree" is closer to "it" than "the car" is. Furthermore, from a purely distributional semantic perspective, both cars and trees can be described as "undamaged," so word embeddings do not exclude "tree."

Missing Factor: Pragmatics/World Knowledge. The model fails to capture the pragmatic implication of the driver's emotion ("pleased"). In the real world, a driver cares about the condition of their own vehicle, not the object they hit. Although there is also chance that this driver is a radical plant enthusiast, in which case the situation would be reversed. It also depends on the background context.


## q
Reason: The model likely relies on lexical similarity. In many general contexts, "colleague" and "worker" might have high cosine similarity (both relate to employment). Without a specific understanding of medical hierarchy, the model might link "colleague" to "worker" simply because they are semantically close or because "injured worker" is a salient entity in the sentence.

Missing Factor: Script Knowledge. The model lacks a structured "Hospital/Medical" script. In this specific frame, doctors and nurses are defined as professional peers (colleagues), while the injured worker fills the role of the "patient." The model needs to understand social roles and professional relationships within specific scenarios to realize that "nurse" acts as the "colleague" to the "doctor," distinct from the person being treated.

