# Retrieval, Detection, Segmentation
## Image Retrieval
+ TP: actual P, predict P
+ FP: actual N, predict P
+ FN: actual P, predidt N
+ TN: actual N, predict N
+ Precision = $\frac{TP}{TP+FP}$
+ Recall = $\frac{TP}{TP+FN}$
+ Accuracy = $\frac{TN+TP}{TN+FP+TP+FN}$
+ F1 = 2$\frac{Precision*Recall}{Precision+Recall}$
+ Precision @K:
  + $P@K = \frac{TP}{TP+FP} = \frac{TP}{K}$
  + Set a rank threshold K
  + Compute % relevant in top K
  + Ignores images ranked lower than K
+ $AP@K$: = average of $P@K$
+ mAP (Mean Average Precision): $mAP@K$

## Object Detection
+ Sliding window
  + anchor ratio: 1:1/3:4/4:3
  + scale: small/big
  + for each location anchor boxes
  + **possible positions**: $(W-w+1)*(H-h+1)$
  + **total possible boxes**: $\sum_h\sum_w (W-w+1)(H-h+1) = \frac{H(H+1)}{2}\frac{W(W+1)}{2}$
  + apply strides: number of positions along one axis = $\frac{N-w}{s} + 1$
  + **total number of windows** = product along both axes (× #scales × #orientations × #classes if used)
  1. inspect every window and generate candidates
  2. extract features from each window
  3. classify each window (accept if it scores > threshold)
  4. perform post-processing to clean up overlapping detections

+ Selective Search
  + groups similar pixels into regions and then hierarchically merges them to produce candidate object regions
  + merges regions hierarchically in multiple ways, it generates a diverse set of candidate boxes (scales/aspect ratios/colors/textures)
  1. initial segmentation: break the image into many small regions (superpixels)
  2. Iteratively merge regions based on similarity(color/texture/size/shape)
  3. generate bounding boxes around merged regions at each merging stage
+ Region proposals
+  Duplicate Filter: Non-Maximum Suppression (NMS)
   +  Calculate IoU = $\frac{Intersection}{Union} = \frac{|A∩B|}{|A\cup B|}$
+ Evaluating Object Detectors: mAP

### Detectors:
#### Single-Shot Detectors (YOLO, SDD, RetinaNet):
+ No seperate proposal stage, detection is done in a single network pass
  + The image is divided into a dense grid (YOLO) or anchors of multiple sizes/aspect ratios (SSD)
  + each grid cell/anchor directly predicts:
    + class probabilities
    + bounding box coordinates

#### Two-stage Detectors (R-CNN)
+ Stage 1: region proposals
  + generate a set of candidate regions where object might be
    + R-CNN/Fast R-CNN: selective search -> region proposals
    + Faster R-CNN: Region Proposal Network (RPN, learned)
+ Stage 2: Classification & Refinement
  + each candidate region is cropped/pooled and fed into another network
  + The second stage classifies the object (which category?) and refines the bounding box coordinates
#### R-CNN:
+ R-CNN (2014):
  + Uses selective search for ~2000 region proposals.
  + Runs a CNN on each proposal separately → very slow.
+ Fast R-CNN (2015):
  + Single CNN feature extraction for the whole image.
  + Uses RoI pooling to crop features per proposal.
  + Still depends on selective search for proposals.
+ Faster R-CNN (2015):
  + Adds a Region Proposal Network (RPN) → proposals are learned end-to-end.
  + Shares convolutional backbone between RPN and detection head.
  + Much faster, state-of-the-art for years.

## Image Segmentation
+ partition the image into semantically-meaningful or perceptually-similar regions
+ Label each pixel in the image with a category label