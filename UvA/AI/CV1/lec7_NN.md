# Neuron Network
## multilayer perceptron (MLP)
+ Full connected layer:
  + features combination
  + last layer softmax -> classification
  + extremely large amount of parameters for images
  + number of parameters = (number of input features X number of output features) + number of biases
  + number of biases: same as #neuron
  + For an image I with dimensions $(H\times W \times C)$, FC Layer: $(H\times W \times C) \rightarrow D$.
   + number of features (inputs to FC): $H\times W \times C$
   + number of parameters in FC: input features x output features + number of biases -> $H\times W \times C \times D + D$ 
  
## CNN
+ exploit the spatial structure of image
+ use convolutions to extract local patterns (edges, textures, shapes) and gradually build up to high-level features (objects, scenes)
+ Building:
  + Convolution Layer
  + Activation Function (ReLU)
  + Pooling Layer -> reduces size, keeps important features
  + FC Layer
+ input size $W_{inp}$, a filter/kernel size $k$, padding $p$, stride $s$:
  + **output size** = $W_{out} = floor(\frac{W_{inp} -k+2p}{s}+1)$
+ the number of weights (in one filter) = kernel size * the number of input channels
  + in this layer = ↑ * number of filters
  + #filters = #output channels
+ in 1st layer: receptive field size = kernel size
+ the depth of filter in the next layer = the number of output channels from the previous layer

## 3D reconstruction
### Shape from X
+ shading
+ texture
+ focus/defocus
+ specularities
+ shadows
+ motion
+ ...

### Camera Calibration
+ Camera 'Motion': given a set of cooresponding 2D/3D points in two or more images, compute the camera parameters
+ $X = K[R\textbf{ }t]X$
+ Intrinsic Calibration: Non-linear Distortion
  + Barrel distortion
  + Pincushion distribution

## 2-view Case
### Stereo
+ human stereo: Human eyes fixate on point in space – rotate so that corresponding images form in centers of fovea
+ Stereo Image Rectification: Project each image onto a common plane parallel to the baseline using homographies
+ rectified stereo pair: 
  + search disparity on a epipolar line
  + Rectified → the images are aligned so that corresponding points lie on the same horizontal scanline (epipolar line)
  + Epipoles are the projections of the other camera center onto each image plane
  + Stereo pair → two slightly different viewpoints
  + match with Sum of Squared Differences(SSD)
+ Stereo as Energy Minimization:
  + assign correct disparity for each pixel
  + both consistent with local pixel features and globally reasonable
  + $E(d) = E_{data}(d) + \lambda E_{smooth}(d)$
    + $E_{data}$: test if disparity match the pixel in two pictures
    + $E_{smooth}$: penalty for large change

### Rectified stereo - Simiarity measure
check if (x,y) match (x+d, y), need a **cost function** to measure if two pixel **windows** are similar
+ SAD (Sum of Absolute Differences): simple, robust, hard to be effect on an outlier
+ SSD (Sum of Squared Differences): emphasize the difference, sensitive to outliers
+ Zero-mean SAD: avoid additive brightness changes
+ Locally scaled SAD: normalize to reduce effect from the brightness change -> contrast
+ Window size:
  + small: more detail(edge, boundary), sensitive to noise
  + big: more stable, but mix foreground and background


### Structure-from-Motion (SfM)
+ when camera filming from different position, the same 3D point appears in different 2D pictures
  + -> calculate the extrinsic 
+ Bundle Adjustment: adjust the bundle of rays (intrinsic params) to make these rays go through real 3D point
+ feature matching → pose estimation → triangulation → multi-view stereo
1. Capture many images of a scene
2. Find and describe feature points
3. Search for feature point correspondences across images
4. Compute camera positions
5. Triangulate feature points
6. bundle adjustment
   1. Non-linear refinement of structure and motion 
   2. Minimize reprojection error:
