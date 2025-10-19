# Local Features

## Edge Detection
+ Naive Way (with Dilation): dilated - original
+ Edge: A place of **rapid change** in image intensity function

### Image Gradient
+ $\nabla f = [\frac{\partial f}{\partial x}, \frac{\partial f}{\partial y}]$
+ Edge strength → Gradient magnitude: $||\nabla f|| = \sqrt{G_x^2+G_y^2}$
+ Gradient direction: $\theta = tan^{-1} (\frac{\partial f}{\partial x}/\frac{\partial f}{\partial y})$
+ calculate gradient: x:$[1,0,-1]$

### Hog: Histogram of Gradients
1. find $G_x, G_y$
2. Calculate magnitude $M = \sqrt{G_x^2+ G_y^2}$ (3*3 matrix)
3. find $\theta$ (3*3 matrix)
4. HoG descriptor: Bins: 0-180°, n bins -> [0,180/n]
5. Descriptor weighted: ↑*magnitude

### Pre-smooth & Pre-Differentiate
+ To find edges, find peaks in $f\ast \frac{dh}{dx}$
  + Convolution is associative: $\frac{d}{dx}(f\ast h)=f\ast \frac{dh}{dx}$ -> differentiate every time
  + Differentiate kernel offline(only once) $\frac{dh}{dx}$
  + Online: convolution h pre-diff kernel
+ Extra Robustness: edge as zero-crossing of 2nd order derivative using LoG
  + Laplacian of Gaussian: $f \ast (\frac{d^2}{dx^2}h)$
    + $\nabla^2h = \frac{d^2h}{dx^2} + \frac{d^2h}{dy^2}$
  + Ideal case: 
    + 1st order derivative: local extremum $|f'(x)| >> 0$
    + 2nd order derivative is 0
  + Discrete signal in practice:
    + 2nd order crosses 0 → consider left/right samples!

### Difference of Gaussians (DoG)
+ $DoG=(I∗Gσ_1​​)−(I∗Gσ_2​​)$: applied Gaussian Filter twice and subtraction
+ Laplacian of Gaussian (LoG) can be approximated as Difference of Gaussians (DoG)
+ band-pass filter
+ Scale normalization:
  + the amplitude of higher-order Gaussian derivatives decreases with increasing scale ->  need to be normalized
  + $s^k$
+ Disadvantage:
  + sensitive to noise
  + thick, blur edge

### Canny Edge Detector
1. Gaussian pre-smoothing: use Gaussian Filter to reduce noise
2. Calculate gradient (magnitude + orientation)
3. Non-maximum suppression: 
   + keep only if pixel is local maximum along gradient direction
   + fine the edge
4. Double threshold + Hysteresis
   + above high threshold (strong) -> edge
   + below low threshold -> not edge
   + in between (weak) -> edge if connected to strong edge
+ Choice of 𝜎 depends on desired behavior:
  + Larger: 'lager-scale' edges
  + small: fine edges

## Line Fitting
### Ordinary Least Squares
+ Find the line parameters that minimize error in a least-square sense
+ Input: Data Point $(x_1, y_1), ..., (x_i, y_i)$, line model $y_i = x_im+b$
+ Output: find p = (m,b) that $argmin \sum(y_i-x_im-b)^2$
+ $\bf{A = [X\text{ } 1]}$ -> $\bf{p = A/y}$
+ Problem: Fails completely for **vertical lines** (Fitting performance affected by slope)
+ Solution: ‘Total least squares’ using a perpendicular distance

### RANSAC
+ Noise: outlines effect a lot
+ RANSAC: RANdom SAmple Consensus
+ aims to maximize the number of inliers through random sampling
1. Hypothesis generation:
   1. Sample Data Randomly
   2. Estimate Parameters using Sampled Data
2. Hypothesis evaluation:
   1. Choose your norm/cost func.: calculate error of data w.r.t. the estimation
   2. Count number of inlier candidates
   3. keep the parameters as the final estimation
   4. return if its enough
+ **Parameters**:
  + $p = 1-(1-w^n)^k$-> reliability
  + $k = \frac{log(1-p)}{log(1-w^n)}$
    + k: number of iterations
    + w: probability that a point is an inlier
    + n: minimal number  of samples for model
+ Pros: robust
+ Cons: large computation amount, sensitive with parameters, the results are random/not stable, Not good for getting multiple line fits (↓solution)

### Hough Transform
+ parameter space -> Hough space
+ Image space: $y_1 = mx_1+b$ -> $b = -x_1m+y_1$ Hough Space
+ For each edge:
  + Draw a line in Hough space
  + Add +1 in **accumulator** cells where the line going through
  + Find local maxima 
  + Map each maximum Point in Hough space
+ Pros: 
  + Detect multiple lines in image, easily extended for circles and ellipses
  + All points processed independently → Can cope with occlusion
  + some noise robustness
  + can detect multiple instances of a model in a single pass
+ Cons: 
  + Search-time complexity increases exponentially with number of model parameters (especially complex shapes have more parameters)
  + non-target shapes can produce spurious peaks in parameter space
  + quantization: difficult to pick a good grid size
+ **Polar Representation**: $x cos\theta + y sin\theta = \rho$
  + $\rho = \alpha_1 sin(\theta + \beta_1)$
  + reason: Parameters (m,b) are unbounded (m can be infinite), need an infinitely large Accumulator (memory hungry)
  + need an infinitely large accumulator (memory hungry)
+  Clean data points → ‘Clear’ peak in Hough space
+  Noisy data points → ‘Fuzzy’ peak in Hough space → Adjust grid size (sparser)

## Corners
+  Characteristic Scale: the scale that produces peak of Laplacian response
   +  change the number of pixels

### Calculation:
+ Gradient magnitude $M_A = \sqrt{A_x^2+A_y^2}$
### Harris Corner Detector  !
+ if move in a window, the corner will change the most
  + 'flat': no change in all directions
  + 'edge': no change along the edge direction
  + 'corner': significant change in all directions
+ Change the intensity for the shift [u,v]:
  + $E(u,v) = \sum_{x,y}w(x,y)[I(x+u, y+v)-I(x,y)]^2$
  + $w(x,y)$: window function
  + $I(x+u, y+v)$: shifted intensity
  + $I(x,y)$: intensity
  + $I_x,I_y$: partial derivative
+ $E(u,v) = [u,v]M[u,v]^T$ -> how much you cost if you move the window
  + $M = \sum_{(x,y)\in W} w(x,y) \begin{bmatrix} I_x^2 & I_xI_y \\ I_yI_x & I_y^2 \end{bmatrix}$
+ $R = detM-k(traceM)^2$
  + $R = \lambda_1\lambda_2 - k(\lambda_1+\lambda_2)^2$
   + how much change on two orthogonal directions -> both directions exhibit strong gradients
   + eigenvalues: $det(M-\lambda I)$
   + $det = ad-bc$
  + R depends only on eigenvalues of M ($\lambda_1, \lambda_2$)
  + R >> 0: corner
  + R << 0: edge
  + |R| is small for a flat region


### SIFT– Scale Invariant Feature Transform
1. Gaussian Scale Space s: apply gaussian filter in different $\sigma$
2. DoG
3. Find local extrema on both Spatial space (x,y) and Scale space(s) -> keypoints
4. Keypoint descriptor: describes each keypoint with a high dimensional vector
5. feature matching

+ Keypoints are:
  + Scale Invariant
  + Rotation invariant
    + do orientation assignment after by checking histogram around keypoints 

+ Orientation assignment (not for SIFT, but generally):
  + take 16x16 window around detected keypoint
  + compute edge orientation for each window pixel
    + $\theta = arctan \frac{I_y}{I_x}$
  + throw out weak edges (threshold gradient magnitude)
  + create histogram of surviving edge orientations
+ Descriptor (full version of SIFT):
  + Divide 16x16 window -> 4x4 cell grid
  + compute orientation histogram for each cell(8 orientation bins)
  + 16 cells(4x4 grid) * 8 orientations (per cell) -> 128 dimensional descriptor
+ For each patch:
  + Compute histogram of its gradient directions/orientations
  + Find **dominant orientation**
  + Descriptor represented relative to this orientation
+ Properties
  + Invariant to: scale, rotation
  + Partially invariant to: illumination changes, camera viewpoint, occlusion(遮挡), clutter(干扰，背景杂乱)