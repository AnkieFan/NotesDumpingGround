# Optical Flow, Tracking
## Optical Flow
+ Optical flow: apparent pixel motion between consecutive frames, 
  + under assumption: **brightness constancy** and **small motion**
+ Optical flowd $o = (u,v)$, frame $f_{t+1} = f_t+o$

###  Apparent Motion (displacement) of Pixels
+ $I(x,y,t)$ pixe value at time t and location (x,y)
+ $u(x,y), v(x,y)$: horizontal/vertical component

### Optical Flow Lucas-Kanade Method !!!
+ Assume:
  + central point and surrounding points have same Optical Flow u -> Spatial Smoothness
  + small motion
  + high textured region
  + color/brightness constancy
+ $Au = -b$
+ $u = -(A^TA)^{-1}A^Tb$
+ $A^TA$: structure tensor
+ depends on the image neighborhood we focus on

### Optical Challenges
+ Large motion, motion blur
+ Texture-less regions
+ Occlusions
+ Lighting changes, noise…

## Tracking
### Template-based Tracking
+ Given a template image T(x) that shows a target object
+ Search for the target object in an image frame $I(x,t)$ by comparing the template image T(x) with image areas
+ Assume that the template is fixed and given in advance

### Mean Shift Algorithm
+ kernel (weights of neighborhood points), bandwidth (seach window's size)
+ For each point:
  + calculate weights in a window
  + move window to new gravity
+ very sensitive to bandwidth: too small -> cluster will be too small