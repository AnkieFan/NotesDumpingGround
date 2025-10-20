# image operations

## Global Transformation
+ For linear transformations, we can represent T as a matrix $p' = \bf{T}p$
+ $T = \begin{bmatrix} R_{n*n} & t_{n*1} \\ 0_{1*n} & 1 \end{bmatrix}$
  + n: dimension
  + Translation: $R = I$ 
  + Rotation: $R^TR = I$, see lec1 note
  + Scaling: diag matrix

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

## Image Stitching
+ Combine two or more overlapping images into one large image
1. Reprojection model
   1. Detect Keypoints (SIFT, Harris Corner, SURF, ORB)
   2. keypoint matching (Euclidean/cosine distance)
   3. solving transformation (directly compute the homography matrix)
   4. RANSAC
2. Planar mapping (planar projection)
3. Blending (Feathering, Pyramid blending, alpha blending)

### Recap: RANSAC
1. select 2 random points
2. fit the line
3. compute the distances
4. count the number of inliers
until maximum number of iteration k reached

# Image Classification
## Bag of Words
+ detect local keypoints (e.g., SIFT, SURF, ORB)
+ compute a descriptor (e.g., 128-D SIFT vector).
+ clustered (usually with k-means) into K clusters
  + Each cluster center = a visual word
  + The set of all cluster centers = the visual vocabulary (codebook)
+ An image is then represented by a histogram over this vocabulary:
  + Count how many of its descriptors fall into each cluster (word)
  + Result = a fixed-length vector (like a word count histogram in NLP)

### BoW model
1. build a visual dictionary by clustering the descriptors
2. Sample patches from the image
3. Extract local features from the patches
4. create a histogram of visual words

### Weakness
+ Loss of spatial information: two features are same but at completely different position -> still similar
+ Choice of vocabulary size: hard to choose a proper one, and very poor scalability -> cannot recognize new feature that is not in vocabulary
+ Sensitivity to background clutter: Background textures may dominate the histogram

### Classification steps:
1. Collect a large, annotated dataset
2. Split the dataset into training, validation and test sets
3. Compute the BoW vocabulary using both the training and validation sets
4. Generate BoW representation for all images in the training, validation and test sets
5. Use the training set to train the classifier and the validation set to select hyperparameters
6. Evaluate the performance

### K-means:
1. Select a value of K
2. Select a feature vector for every pixel (color, texture, position, or combination of these etc.)
3. Define a similarity measure between feature vectors 
(Usually Euclidean distance)
4. Apply the K-means algorithm to all the feature vectors

+ Pros: Finds cluster centers that minimize variance 
+ Cons: All clusters have spherical distribution, Prone to local minima, need to choose K