# Computer Vision

## Introduction
+ Low Level Vision
  + Measurements
  + Enhancements
  + Region Segmentation
  + Features
+ Mid Level Vision
  + Reconstruction
  + Depth
  + Motion Estimation
+ High Level Vision
  + Category detection
  + Activity recognition
  + Deep understandings
  + Pose estimation

## Pinhole camera model
+ Pinhole model 小孔成像
  + Captures **pencil** of rays - all rays through a single point
  + the point is called **Center of Projection (focal point)**
  + the image is formed on the Image Plane
+ camera obscura 暗箱
  + image is inverted
  + **depth of the room** is the **focal length**
+ aperture 光圈
  + Aperture size↑: sharpness↓ brightness↑
  + more clear if shrink the aperture
  + too small: less light, diffraction
+ Focal length: from lens(aperture) to sensor(image plain)
  + focal length↓:Object size (shrinking)↓, Field of view (more things fit the image)↑
  + focal length↑:Object size (magnification)↑, Field of view (less things fit the image)↓
+ Projection: world coordinates to image coordinates

## Projection matrix
  + Z: perpendicular to image plain
  + 3D -> 2D: $p = [X, Y, Z]^T -> p'=[f\frac{X}{Z}, f\frac{Y}{Z}]^T$, f:focal length
    + -> virtual image $p_v' = [f\frac{X}{Z}, f\frac{Y}{Z}, -f]^T$

### Homogeneous Coordinates
+ Cartesian Coordinates: 2D: $[X, Y]^T$ 3D: $[X, Y, Z]^T$ 
  + Rotation, Scaling, NOT Translation
+ Homog -> Cartesian: $[X,Y,W] => [X/W, Y/W]$ $[X,Y,Z,W] => [X/W, Y/W, Z/W]$
+ Car -> Homog: $(X,Y) => [X,Y,1]$, $(X,Y,Z) => [X,Y,Z,1]$

### 3D→2D Projection Matrix
+ $\bf{x = K[I\text{ }0]X}$
+ $[I\text{ }0]$ Extrinsic Matrix: $[R∣t]$
  + R: Rotation (3*3)
    + R=I: no rotation
    + 3 DoG
  + t: translation (3*1)
    + t=0: no translation
  + 描述相机在世界坐标系中的位置和朝向 Where the camera is
+ K: Intrinsic Matrix, 描述相机成像的内部参数 How the camera project from 3D to 2D
  + $K = \begin{bmatrix} f_x & s & u_0 \\ 0 & f_y & v_0 \\ 0 & 0 & 1 \end{bmatrix}$
  + $f_x, f_y$: focal length: y: vertical x:horizontal
  + $u_0, v_0$: optical/principal point, normally in the middle of projection image
  + $s$  skew
