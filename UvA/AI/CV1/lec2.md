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