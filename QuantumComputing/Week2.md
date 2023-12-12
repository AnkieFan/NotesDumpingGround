
## State Space (Hilbert Space)
+ vector space equipped with an inner product (i.e., a Hilbert space) known as the state space of the system

### Discrete Time Integral:
U:  unitary transformation  
$\ket{\Psi_1} = U\ket{\Psi_2}$  

Transform $\ket{\Psi_1} = \alpha\ket{0} + \beta\ket{1}$ to $\ket{\Psi_2} = \gamma\ket{0} + \theta\ket{1}$  
$\alpha^2 + \beta^2 = 1$
$\gamma^2 + \theta^2 = 1$
$\ket{\Psi_1} = \begin{bmatrix} \alpha\\ \beta \end{bmatrix}$
$\ket{\Psi_2} = \begin{bmatrix} \gamma\\ \theta \end{bmatrix}$
$\begin{bmatrix} \alpha\\ \beta \end{bmatrix} = U \begin{bmatrix} \gamma\\ \theta \end{bmatrix}$
$||\ket{\Psi_2}||_2 = ||\ket{\Psi_1}||_2 = 1$ (l2 norm: $||x||_2 = \sqrt{\sum x_k^2}$)

### Unitary Transformation  
Unitary Matrices: $U^{-1} = U^T$, $UU^{-1} = UU^T = I$  
$\ket{u}, \ket{v}$  
$\ket{u'} = U\ket{u}, \ket{v'} = U\ket{v}$ 
$\braket{u'|v'} = \bra{u}U^TU\ket{v} = \braket{u|v}$