# Controllability, observability and minimality

## Controllability
+ Controllable if-f the controllability matrix $W_c$ is invertible (determinant != 0).
+ For a system (A,B,C,d):
  + $W_c $  
  + check the rank (Non-zero columns)

## Observability
+ Observable if-f the Observability matrix $W_o$ is invertible (determinant != 0).
+ For a system (A,B,C,d):
  + $W_o = \left [ \begin{matrix} C \\ CA \\ CA^2 \\ ... \\ CA^{n-1}\end{matrix} \right]$
  + check the row rank (Non-zero rows)

## Minimality
+ Controllable AND observable

# Pole placement with state-feedback
Quetsion: One wants to find a state-feedback such that all poles of the closed loop system are at −4. Provide the desired state-feedback (feedback control law) $L$.

## First step: turn state-space representation to be linear
1. Find $det(\textbf{sI-A})$ (or z in discrete case)
   + ↑This is the denominator transfer function. You can find **poles** here.
   + Trick: if $\textbf(A)$ is in controllable canonical form(see `state_space.md`: From transfer functions to state-space), then the first line is $-a_1, -a_2, -a_3...$
2. This will be a polynomial of $s$. Find coefficients of it.
   + If A is a 3*3 matrix: $s^3 + a_1s^2+a_2s+a_3$
   + Write $a_1 = , a_2=  , a_3=$
## Second step: find $\overline{L}$
1. The question will provide poles $p_1, p_2, p_3...$
   + NOTICE: if A is a 3*3 matrix, then it should always have 3 poles
   + Like if all poles are at $p$, then the formula is $(s-p)^3$
2. Construct linear representation: $(s-p_1)(s-p_2)(s-p_3)...$
3. Turn it to be linear form: (if 3*3 matrix) $s^3 + \tilde{a_1}s^2 + \tilde{a_2}s+\tilde{a_3}$
4. Write $\overline{L} = (\tilde{a_1}-a_1, \tilde{a_2} - a_2, \tilde{a_3}-a_3)$
## Third step: find controllability matrix $W_c$ and $\overline{W_c^{-1}}$
1. Calculate $W_c = [B, AB, A^2B, ..., A^{n-1}B]$ 
   + Trick: $A^2B = A \cdot AB$
2. Find $\overline{W_c^{-1}}$:
   + For A being 3*3 matrix, $\overline{W_c^{-1}} = \begin{pmatrix} 1, a_1, a_2\\ 0,1,a_1 \\ 0,0,1 \end{pmatrix}$
## Fourth step: Find $T$ and $T^{-1}$
1. $T^{-1} = W_c \cdot \overline{W_c^{-1}}$
2. Inverse it to find $T = (T^{-1})^{-1}$
## Last step: feedback control law $L = TL$