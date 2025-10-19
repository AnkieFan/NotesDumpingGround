# image operations

## Global Transformation
+ For linear transformations, we can represent T as a matrix $p' = \bf{T}p$

### Scaling
+ multiplying each of its components by a scalar
+ Uniform scaling: this scalar is the same for all 
components -> x=2x, y=2y
+ Non-uniform scaling: different scalars per component -> x=2x, y=0.5y
+ $S = \begin{bmatrix} a&0 \\ 0 & b\end{bmatrix}$
+ $\begin{bmatrix} x' \\ y' \\ 1 \end{bmatrix} =\begin{bmatrix} s_x & 0 & 0 \\ 0 & s_y & 0 \\ 0 & 0 & 1 \end{bmatrix}\begin{bmatrix} x \\ y \\ 1 \end{bmatrix}$

### 2D Rotation
+ $R = \begin{bmatrix} cos\theta & -sin\theta \\ sin\theta & cos\theta \end{bmatrix}$
+ $R^T = R$
+ $\begin{bmatrix} x' \\ y' \\ 1 \end{bmatrix} = \begin{bmatrix} \cos\theta & -\sin\theta & 0 \\ \sin\theta & \cos\theta & 0 \\ 0 & 0 & 1 \end{bmatrix} \begin{bmatrix} x \\ y \\ 1 \end{bmatrix}$

### 2D Translation
+ Cartesian -> Homog.
+ $\begin{bmatrix} x' \\ y' \\ 1 \end{bmatrix} = \begin{bmatrix} x+t_x \\ y+t_y \\ 1 \end{bmatrix} = \begin{bmatrix} 1 & 0 & t_x \\ 0 & 1 & t_y \\ 0 & 0 & 1 \end{bmatrix} \begin{bmatrix} x \\ y \\ 1 \end{bmatrix}$

### Shear
$\begin{bmatrix} x' \\ y' \end{bmatrix} = \begin{bmatrix} 1 & \alpha_x \\ \alpha_y & 1 \end{bmatrix} \begin{bmatrix} x \\ y \end{bmatrix}$  
$\begin{bmatrix} x' \\ y' \\ 1 \end{bmatrix} = \begin{bmatrix} 1 & \alpha_x & 0 \\ \alpha_y & 1 & 0 \\ 0 & 0 & 1 \end{bmatrix} \begin{bmatrix} x \\ y \\ 1 \end{bmatrix}$

### Affine: a combination of translation, scale, rotation and shear
+ = S\*R\*T...
+ $\begin{bmatrix} x' \\ y' \end{bmatrix} = \begin{bmatrix} a & b & c \\ d & e & f \end{bmatrix} \begin{bmatrix} x \\ y \\ 1 \end{bmatrix}$  
+ $\begin{bmatrix} x' \\ y' \\ 1 \end{bmatrix} = \begin{bmatrix} a & b & c \\ d & e & f \\ 0 & 0 & 1 \end{bmatrix} \begin{bmatrix} x \\ y \\ 1 \end{bmatrix}$

## Image Warping
+ Warping = applying a geometric transformation (e.g., affine, homography, optical flow field) to an image, which relocates pixels to new coordinates.
+ Forward Warping: $(x',y') = T(x,y)$
  + Some pixels may be skipped, leaving holes (black regions in the warped image).
  + (x',y') is usually not an integer → interpolation needed
+ Backward Warping: Output -> input, $(x,y) = T^{-1}(x', y')$