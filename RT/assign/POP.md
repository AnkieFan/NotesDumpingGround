## A possible POP:
Start:
1. At(Robot, Living room)
2. At(Alice, Living room)
3. At(Sandwich, Kitchen)
4. At(Shoes, Hallway)
5. Empty
6. Wants(Alice, Sandwich)
7. Wants(Alice, Shoes)
8. Go(Living, Kitchen)
9. Get(Sandwich, Kitchen)
10. Has(Sandwich)
11. Go(Kitchen, Living room)
12. Deliver(Sandwich, Alice)
13. Empty
14. Go(Living room, Hallway)
15. Get(Shoes, Hallway)
16. Has(Shoes)
17. Go(Hallway, Living room)
18. Deliver(Shoes, Alice)
End

Addition: If plotted as a chart, it would be a simple diagram going along order as above.  

### Causal links:
+ Step 8 is enabled by step 1 
  + Robot must be in the living room to go to the kitchen.
+ Step 9 is enabled by step 3, step 5 and step 8
  + Both Sandwich and Robot must be in the kitchen. Robot must be empty-handed to get the sandwich.
+ Step 10 is enabled by step 9 
  + Robot must get the sandwich to be considered as having it.
+ Step 11 is enabled by step 10
  + Robot must have the sandwich to go back to the living room.
+ Step 12 is enabled by step 2, step 6, step 10 and step 11
  + Robot and Alice must in the same room. Alice must want sandwich. Robot must have the sandwich to deliver it to Alice.
+ Step 13 is enabled by step 12
  + Robot must have delivered the sandwich to be considered empty-handed.
+ Step 14 is enabled by step 13
  + Robot must be empty-handed to go to the hallway.
+ Step 15 is enabled by step 4, step 13 and step 14 
  + Both Robot and Shoes must be in hallway and Robot must be empty-handed and in the hallway to get the shoes.
+ Step 16 is enabled by step 15
  + Robot must get the shoes to be considered as having them.
+ Step 17 is enabled by step 16 
  + Robot must have the shoes to go back to the living room.
+ Step 18 is enabled by step 2, step 7, step 16 and step 17
  + Robot and Alice must in the same room. Alice must want shoes. Robot must have the shoes to deliver them to Alice.

### Threats:
+ Alice might leave living room before Robot deliver her shoes and sandwich.
  + Solved by adding causal links between step 2 and step 12, 18: Robot and Alice must in the same (living) room.
+ Someone else might take the sandwich or shoes from the kitchen or hallway before the Robot gets them
  + Solved by adding causal links between step 3 and 9, step 4 and15: Both Robot and Sandwich/Shoes must be in kitchen/hallway.
+ Robot might leave without carrying objects
  + Add Has(object) and causal links between Has(object) and leaving where object is.
+ Robot might be carrying sandwich when getting shoes
  + Add Step 13 `Empty` and causal links between Step 13 and Step14: Robot must be empty-handed to go to the hallway.
