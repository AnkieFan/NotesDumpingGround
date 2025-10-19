## Photometric Stereo
+ captures multiple images from the same viewpoint, but with different light settings
+ Per-pixel estimation of normal and albedo or material


## Reflectance
+ Ideal diffuse (Lambertian 漫反射)
+ Ideal specular
+ Directional diffuse

### Shape from Shading
+ I ∝ N · L
+ Image Intensity ∝ Surface Normal * Light Direction
+ Image Intensity ∝ cos(angle between N and L)
+ $I = k_d cos(\theta)$, k: Diffuse material 
+ Shape from Shading assumptions:
  + Diffuse material with spatially constant albedo (k=1)
  + Known point light source at infinity (L)
  + Known camera at infinity (orthography) (v)
+ $I = k_d NL$, 
  + $G=k_dN$, $||G|| = k_d$, $G = IL^{-1}$
  + N: normal, 1*3 (3d)
  + L: light direction 3*3
    + nonsingular (invertible) when: \>= 3 light directions are linearly independent (All light direction vectors cannot lie in a plane)
+ More than 3 Lights: $G = (IL^T)(LL^T)^{-1}$
+ More than 1 pixel: images: 
  + I: p*number of image
  + N: p*3
  + L: 3* number of image 

## Image processing operations
### Point-wise operations: histogram operation
+ each bin $f(x) \in [e_i, e_{i+1})$, where $f(x)$ is pixel value 
  + 1D: gray only, 8-bit:0~255
  + Color: 3x seperate 1D historgrams per channel $r(x), g(x), b(x)$
    +  Ignores color Correlations!
    +  Better solution → 3D Histogram
+ Sturges' rule(assume Gaussian data): $k = [log_2n]+1$ (k:amount of bins)
+ Too many (and too small) bins?
  + Many bins will be empty
  + ’High-frequency’ info
+ Too few (and too big) bins?
  + Will not encode ‘well enough’

#### Monadic Point Operator：
  + perform another function on each pixel: $\phi(𝑓(𝑥))$
  + $\phi$: Monadic Operator
  + do not consider neighbor or position
  + change the histogram
+ e.g. Histogram Contrast Stretching
  + Histogram range: [a,b], stretch to [0,1]
  + $\phi(f(x)) = \frac{f(x)-a}{b-a}$
  + increase contrast
+  Gamma Correction - Non-linear scaling (power-law transformation)
   +  就是PS里的曲线
   +  output grey level: $s(r) = cr^\gamma$
      +  r: input gray level
      +  c: normalization constant
+ Histogram Equalization
  + Calculate $P_k$, and then CDF value for each gray level
  + new gray level: $k' = CDF*(L-1)$, L: the number of gray levels
  + round new CDF to the nearest gray level
  + reassign pixel count to new k
+  Histogram Thresholding
   +  Binarize the grey image: set a threshold to divide histogram into two part

### Neighborhood image processing
#### handle borders:
1. Zero: fill with 0
2. Clamp: if need index = -3 then use index = 3
3. Wrap: similar to array index: if need index = -3, find the 3rd from end
4. mirror: if need index = -1, use index = 0
#### Connected Components Analysis
+ binary image
+ foreground pixels = object (1’s or white)
+ background pixels = 0’s or black
+ When you find a "foreground pixel" (white pixel), check its neighbors:
  + 4-connected: Up, Down, Left, Right
  + 8-connected: Also includes diagonals
+ Assign Labels:
  + no labeled neighbors: assign it a new label
  + has a labeled neighbor: give it the same label
  + has multiple different labels from neighbors: merge them into one region

#### Mathematical Morphology
+ Dilate (B: Binary image, S: the origin of structuring element)
  + Step 1: multiply each element with structuring element
  + Step 2: as long as there is 1, fill with 1
  + Can be used for:
    + growing features
    + filling holes and gaps
  + How to handle borders: zero/wrap/clamp/mirror
  + e.g.: edge detection
+ Erosion
  + Step 1: multiply each element with structuring element
  + Step 2: all positions are 1: fill with 1
  + e.g.: counting coins
+ Opening: Erosion → Dilation, with the same structuring element
  + Spot and noise removal
  + keep the foreground with similar structure with structuring element
+ Closing: Dilation → Erosion
  + Removal of holes
  + tends to enlarge regions, shrink background
+ Opening the foreground = Closing the background

### Linear Image Filtering
+ $g(i,j)=\sum_{k,l} f(i+k, j+l)·h(k,l)$
+ $f(x,y) -> H -> g(x,y)$
+ **Common H (2D)**:
  + 1. Sum: 
    + around 1: lightness is kept, smoothing/mean filtering/blurring
    + = 0: finding difference: edge detection/derivative filtering
    + \>1 or <0: sharpening/contrast enhancement
  + 2. +/-
    + All positive: smoothing
    + Symmetric and half + half -: edge detection
      + [+ 0 -]: vertical edge
      + [+ 0 -]^T: horizontal edge
      + 4-connected - and diag +: corner detection
+ **Frequency**: 
  + Low frequency: slow change in image (smooth area)
  + High frequency: quick change (edge, noise, details)
  + Low-pass filter: smoothen, denoise, blurring
    + e.g.: Gaussian filter, mean filter
    + when 1D kernel looks like Gaussian [1,2,1] -> low pass
  + High-pass filter: edge enhance, sharpening
    + e.g.: Sobel, Laplacian
  + Band-pass filter: allow only a certain frequency
    + DoG (Difference of Gaussians), Gabor filter

#### Mean Filtering:
+ the element = mean of surrounded elements
+ borders: zero/wrap/clamp/mirror
#### Median Filter:
+ the element = median of surrounded elements
 
#### Gaussian Filter:
+ pixel near center weights more
+ Property:
  + separable: $G(x,y) = G(x)·G(y)$ (row first then column, $O(n^2)->O(2n)$)
  + Cascadable: Approach to large $\sigma$ comes from identity
+ $\sigma$ standard derivative
  + smaller: blurring less, keep more high frequency details
  + bigger: kernel is wider, blurring more, keep only shape

#### Bilateral Filter：
+ add a pixel similarity weight to Gaussian
  + blur only similar pixel (not edge)
+ keep edge
+ $\sigma_s$: spatial Gaussian kernel
  + small: consider close pixels (center)
  + big: consider further pixels (filter range big)
+ $\sigma_r$ range sigma
  + small: effect on similar pixel, keep edge
  + big: grayscale effect less, $\infin$ = Gaussian

### Frequency Domain Analysis
#### Aliasing
+ Occurs when your sampling rate is not high enough to capture the amount of detail in your image
+ Can give you the wrong signal/image—an alias
+ To avoid aliasing:
  + sampling rate ≥ 2 * max frequency in the image
  + This minimum sampling rate is called the Nyquist rate

#### Fourier Transform
+ Spatial domain <-> Frequency domain
+ The Fourier transform (FT) is linear
+ There is an inverse FT
+ The FT of a Gaussian is a Gaussian
+ Convolution Theorem:
  + $g(x) = f(x) \ast h(x) = G(u) = F(u) · H(u)$ -> H: filter
  + convolution on Spatial domain = multiplication on Frequency domain