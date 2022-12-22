### Dataset:
color|size|sound|Good or bad
|:--:|:--:|:--:|:--:|
Green|small|loud|good
black|small|loud|good
green|big|light|Bad
black|mid|mid|Bad

### Hypothesis Space
index|color|size|sound|
|:--:|:--:|:--:|:--:|
1|*|*|*
2|green|*|*|
3|black|*|*|
4|*|small|*|
5|*|big|*|
6|*|mid|*|
7|*|*|loud
8|*|*|light
9|*|*|mid
10|green|small|*
11|green|big|*
12|green|mid|*
13|black|small|*
14|black|big|*
15|black|mid|*
16|green|*|loud
17|green|*|light
18|green|*|mid
19|black|*|loud
20|black|*|light
21|black|*|mid
22|*|small|loud
23|*|small|light
24|*|small|mid
25|*|big|loud
26|*|big|light
27|*|big|mid
28|*|mid|loud
29|*|mid|light
30|*|mid|mid
31|green|small|loud
32|green|small|light
33|green|small|mid
34|green|big|loud
35|green|big|light
36|green|big|mid
37|green|mid|loud
38|green|mid|light
39|green|mid|mid
40|black|small|loud
41|black|small|light
42|black|small|mid
43|black|big|loud
44|black|big|light
45|black|big|mid
46|black|mid|loud
47|black|mid|light
48|black|mid|mid
49|$\empty$

### Study process
Study from dataset:  
1. Green, small, loud = good  
   Delete 3, 5, 6, 8, 9, 11-15, 17-21, 23-30, 32-49 in hypothesis space
2. black, small, loud = good
   Delete 2、10、16、31 in hypothesis space
3. green, big, light = Bad
   Delete 1 in hypothesis space
4. black, mid, mid = Bad
   Nothing to delete

### Hypothesis after learning:
4: *, small, *
7: *, *, loud
22: *, small, loud
**THIS IS THE VERSION SPACE**
