# Bayesian Network
## Glass:
### a) source level - glass
+ Hp: The glass fragments recovered from the hoodie originate from the museum display case glass.
+ Hd: The glass fragments recovered from the hoodie originate from some other source rather than the display case.

### b) activity level - glass
+ H1: The wearer of the hoodie smashed the display case during the robbery.
+ H2: The wearer of the hoodie did not smash the display case; the glass fragments are present on the hoodie due to background presence or an unrelated activity.

### c) CPT:
Assign $E_1$ to be the evidence of glass fragments recovered from the hoodie, $S$ to be the source of glass fragments.

#### Prior on Activity_propositions
No other prior knowledge so neutral: $P(H1) = 0.5, P(H2) = 0.5$

#### Source-level LR:
$\frac{P(E_1 = match|H_p)}{P(E_1 = match|H_d)} = 10000$

So we could have:
+ $P(E_1 = match| S = DisplayCase(H_p)) = 0.9$
+ $P(E_1 = match| S = Other(H_d)) = 0.00009$
+ $LR = 0.9/0.00009 = 10000$

Then complements:
+ $P(E_1 = no match| S = DisplayCase(H_p)) = 0.1$
+ $P(E_1 = no match| S = Other(H_d)) = 0.99991$


#### Activity-level LR:
$\frac{P(E_1 = match|H_1)}{P(E_1 = match|H_1)} = 20$

But in this BN:
$P(E_1​=match∣H)=P(E_1=match∣S=Display)P(S=Display∣H)+P(E_1 =match∣S=Other)P(S=Other∣H)$

Let:
+ $p_1 = P(S = Display | H1)$
+ $p_2 = P(S = Display | H2)$

Then $P(S = Other|H1) = 1-p_1$
So: $P(match|H1) = a p_1+b(1-p_1) = b + (a-b)p_1, P(match|H2) = b + (a-b)p_2$
Where $a = P(E_1=match∣S=Display) = 0.9, b = P(E_1 =match∣H=Other)$
Therefore: $LR_{activity} = \frac{b + (a-b)p_1}{b + (a-b)p_2} = 20$

$p_2$ means, under the alternative activity proposition, what’s the probability the hoodie still ends up with display-case glass. This should be small but not zero. 
Pick $p_2 = 0.02$, plug a and b in, we have $p_1 \approx 0.4019$

So we have activity CPT:
+ $P(S = Display | H1) = 0.4019$
+ $P(S = Display | H2) = 0.02$
+ $P(S = Other | H1) = 0.5981$
+ $P(S = Other | H2) = 0.98$

## Bloodstain:
### d) source level - DNA
+ Hp: The DNA in the bloodstain originated from Mr. Smith.
+ Hd: The DNA in the bloodstain originated from an unknown person unrelated to Mr. Smith.

### e) combining evidence
We can multiply LRs when evidence items address the same hypotheses and are conditionally independent given those hypotheses. 
+ H1: Mr. Smith wore the hoodie during the robbery (i.e., he is the robber wearing that hoodie.
+ H2: Someone else wore the hoodie during the robbery; Mr. Smith last wore it at least two weeks earlier.

### F) 

