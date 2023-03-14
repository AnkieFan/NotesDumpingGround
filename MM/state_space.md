# State-space representations (chapter 4.4)
+ State space:
  + $\dot{\textbf{x}}(t) = \textbf{f}(\textbf{x}(t), u(t), t)$  
  + $y(t) = \textbf{g}(\textbf{x}(t), u(t), t)$  
+ $\textbf{x}(t)$: state vector
+ $u(t)$: input  (scaler)
+ $y(t)$: output (scaler)

## Continuous time state-space representations
Shorthand notation for the state-space representation of a SISO LTI system: $(\textbf{A,b,c},d)$

### Some definition
SISO LTI: a single input & a single output LTI system  
TI -> $\textbf{f}$ doesn't explicitly depend on t (via x&u)  
-> $\textbf{f}$ is linear

### continuous state space
$\dot{\textbf{x}}(t) = \textbf{A}\textbf{x}(t) + \textbf{b}u(t)$   
+ also called *state-update equation*
+ $\textbf{x}(t)$: nx1 matrix
+ $\textbf{A}$: nxn system matrix
+ $\textbf{b}$: nx1 input matrix
  
output: $y(t) = \textbf{c}\textbf{x}(t) + du(t)$  

### Example (exercise 13)
Original function: $\ddot{\theta} = \frac{-b}{ml^2}\dot{\theta}  - \frac{g}{l}sin\theta$  
Linear state-space representation: $\begin{pmatrix} \dot{\theta} \\ \ddot{\theta}\end{pmatrix} = \begin{pmatrix} 0 & 1 \\ \frac{-g}{l} & \frac{-b}{ml^2}\end{pmatrix}\begin{pmatrix} \theta \\ \dot{\theta}\end{pmatrix}$