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