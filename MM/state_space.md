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

## Continuous state space
$\dot{\textbf{x}}(t) = \textbf{A}\textbf{x}(t) + \textbf{b}u(t)$   
+ also called *state-update equation*
+ $\textbf{x}(t)$: nx1 matrix
+ $\textbf{A}$: nxn system matrix
+ $\textbf{b}$: nx1 input matrix
+ 
output: $y(t) = \textbf{c}\textbf{x}(t) + du(t)$  

### Example (exercise 13)
Original function: $\ddot{\theta} = \frac{-b}{ml^2}\dot{\theta}  - \frac{g}{l}sin\theta$  
Linear state-space representation: $\begin{pmatrix} \dot{\theta} \\ \ddot{\theta}\end{pmatrix} = \begin{pmatrix} 0 & 1 \\ \frac{-g}{l} & \frac{-b}{ml^2}\end{pmatrix}\begin{pmatrix} \theta \\ \dot{\theta}\end{pmatrix}$

## Discrete state space
$\textbf{x}[k+1] = \textbf{A}\textbf{x}[k] + \textbf{b}u[k]$   
$y[k] = \textbf{c}\textbf{x}[k] + du[k]$  

## From state-space to transfer functions (exam)
### Laplace transform
$s\textbf{X}(s) = \textbf{A}\textbf{X}(s) + \textbf{B}U(s)$   
$Y(s) = \textbf{C}\textbf{X}(s) + DU(s)$  
***!!!!!!!!!!!! Important formula:!!!!!!!!!!!!!!!!***  
$\textbf{H}(s) = \textbf{C}(s\textbf{I-A})^{-1}\textbf{B}+D$

### Z-transformation
$z\textbf{X}(z) = \textbf{A}\textbf{X}(z) + \textbf{B}U(z)$   
$Y(z) = \textbf{C}\textbf{X}(z) + DU(z)$   
$\textbf{H}(z) = \textbf{C}(z\textbf{I-A})^{-1}\textbf{B}+D$

### Solving steps:
1. find $sI-A$ (or z in discrete)
2. find $(sI-A)^{-1}$ through determinant
   1. $\begin{pmatrix} a & b \\ c & d \end{pmatrix}^{-1} = \frac{1}{ad-bc}\begin{pmatrix} d & -b \\ -c & a \end{pmatrix}$
3. Continue to calculate. Trick: we can just turn the $\frac{1}{ad-bc}$ to be $(s+pole1)(s+pole2)$, and keep it out of matrix.
   1. They are poles but
   2. They may be canceled in the following step

### Exercise 17.1
$\textbf{A} = \begin{pmatrix} -2 & -4 \\ 1 & 3 \end{pmatrix}$   
$s\textbf{I} - \textbf{A} = \begin{pmatrix} s & 0 \\ 0 & s \end{pmatrix} - \begin{pmatrix} -2 & -4 \\ 1 & 3 \end{pmatrix} = \begin{pmatrix} s+2 & 4 \\ -1 & s-3 \end{pmatrix}$  
$(s\textbf{I} - \textbf{A})^{-1} = \frac{1}{(s+2)(s-3)+4} \begin{pmatrix} s-3 & -4 \\ 1 & s+2 \end{pmatrix} = \frac{1}{(s-2)(s+1)} \begin{pmatrix} s-3 & -4 \\ 1 & s+2 \end{pmatrix}$  
$\textbf{C}(z\textbf{I-A})^{-1} = \frac{1}{(s-2)(s+1)} \begin{pmatrix} 1&0 \end{pmatrix} \begin{pmatrix} s-3 & -4 \\ 1 & s+2 \end{pmatrix} =\frac{1}{(s-2)(s+1)} \begin{pmatrix} s-2&-4 \end{pmatrix}$  
$\textbf{C}(z\textbf{I-A})^{-1}\textbf{B} = \frac{1}{(s-2)(s+1)} \begin{pmatrix} s-2&-4 \end{pmatrix} \begin{pmatrix} 3 \\ -1 \end{pmatrix} = \frac{3(s-2) + 4}{(s-2)(s+1)}$  
$\textbf{H}(z) = \textbf{C}(z\textbf{I-A})^{-1}\textbf{B}+D = \frac{3(s-2) + 4}{(s-2)(s+1)} + 1 = \frac{s^2+2s-7}{(s-2)(s+1)}$  
Poles: s = 2 and s = -1