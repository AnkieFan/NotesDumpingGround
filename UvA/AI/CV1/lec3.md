# Local Features

## Edge Detection
+ Naive Way (with Dilation): dilated - original
+ Edge: A place of **rapid change** in image intensity function

### Image Gradient
+ $\nabla f = [\frac{\partial f}{\partial x}, \frac{\partial f}{\partial y}]$
+ Edge strength → Gradient magnitude: $||\nabla f||$
+ Gradient direction: $\theta = tan^{-1} (\frac{\partial f}{\partial x}/\frac{\partial f}{\partial y})$

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