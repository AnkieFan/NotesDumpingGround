# Review

## Categorization of Explanations
### Local vs Global
+ A **local** explanation provides information or justification for the model’s prediction on a specific input
+ A **global** explanation provides similar justification
by revealing how the model’s predictive process
works, independently of any particular input

### Self-Explaining vs Post-Hoc
+ A **self-explaining** approach, generates the explanation
at the same time as the prediction, using information emitted by the model as a result of the process of making that prediction (e.g.: decision trees, rule-based models)
+ a **post-hoc** approach requires that an additional operation is performed after the predictions are made

## Explainability Techniques
+ Feature importance: derive explanation by investigating the importance scores of different features used to output the final prediction (more on model mechanism)
+ Surrogate model (like LIME)
+ Example-driven: explain the prediction of an input instance by identifying and presenting other instances, usually from available labeled data, that are semantically similar to the input instance
+ Provenance-based: illustrate some or all of the prediction derivation process, which is an intuitive and effective explainability technique when the final prediction is the result of a series of reasoning steps
+ Declarative induction

## Visualization Techniques
+ Saliency: visualize the importance scores of different types of elements in XAI learning systems
+ Raw declarative representations: directly presents the learned declarative representations, such as logic rules, trees, and programs
+ Natural language explanation

## Explanation Quality
+ Informal examination of explanations: how examples of generated explanations align with human intuition
+ Comparison to ground truth
+ Human evaluation
+ fidelity: how much they reflect the actual workings of the underlying model
+ comprehensibility: how easy they are to understand by humans

# Lime
Local Interpretable Model-agnostic Explanations

+ **interpretable**: provide qualitative understanding between the input variables and the response
  + interpretable explanations need to use a representation that is understandable to humans, regardless of the actual features used by the model
  + **complexity**: opposed to interpretability
+ **local fidelity**: for an explanation to be meaningful it must at least be *locally faithful*, i.e. it must correspond to how the model behaves in the vicinity of the instance being predicted
  + local fidelity does not imply global fidelity
+ **model-agnostic**: an explainer should be able to explain any model, i.e. treat the original model as a black box
+ **global perspective**

## Fidelity-Interpretability Trade-off
LIME will produce a new dataset (disturb from the original ones)  
+ $\xi (x) = argmin_{g\in G} \mathcal{L}(f, g, \pi_x) + \Omega (g)$
+ $f$: the model need to be explained
+ $g$: interpretable(simple) models 
+ $\pi(x)$: proximity measure (distance from 𝑥 to new dataset x')
+ $\Omega (g)$: complexity

## Sparse Linear Explanations
We let G be the class of linear models, such that $g(z') = w_g z'$  
+ $\mathcal{L}(f, g, \pi_x) = \sum_{x, x'\in D} \pi_x(z)(f(z)-g(z'))^2$
+ $\pi_x(z) = exp(-D(x,z)^2/\sigma^2)$: an exponential kernel defined on some distance function D (e.g. cosine distance for text, L2 distance for images) with width $\sigma$.
+ 𝐷 is a set of simplified inputs representing perturbations of the original input 

## LIME for text classification
Variations of the data are generated differently: Starting from the original text, new texts are created by randomly removing words from the original text. The dataset is represented with binary features for each word. A feature is 1 if the corresponding word is included and 0 if it has been removed.

# SHAP
SHapley Additive exPlanations

