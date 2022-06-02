# Testing

## Partitioning/systematic test
1. Divide the input space into subdomains
2. Choose one test case from each subdomain (partitions)
+ boundaries: Bugs often occur at boundaries between subdomains e.g.: 0
  + Put boundaries to be a single test

## Test suite
+ Full Cartesian product: Every legal combination of the partition dimensions is covered by one test case
+ Cover each part: Every part of each dimension is covered by at least one test case, but **not necessarily every** combination

## Testing (Only need to know what it is)
### Black Box and Glass Box Testing
+ Black box testing: partitioned without looking at the actual code
+ Glass box testing: test cases from actual **implementation**

### Unit Testing vs. Integration Testing
+ Unit Testing: for single module in isolation
+ Integration testing:  for combination of modules, or even the entire program

### Automated Testing and Regression Testing
+ Automated testing: running the tests and checking their results automatically
  + Test driver: fixed test cases in code module **itself**, automatically check the result
  + **Rerun** tests after every code changes
+ Regression testing: running **all** your tests after every change
+ **Automated regression testing** to keep bugs from coming back

### **Test-first programming**: Write tests before you write code
+ ! not Automated regression testings

## First question answer model:

1. Partitioning:
   e.g.: 
   this: <0, = 0, and >0 
   val: <0, = 0, and >0 
   this × val: this > val, this = val, and this < val 

+ should be a relationship between tested things
  e.g.： start = 0, 0 < start < text.length(), start = text.length()
  instead of: start = 0, start = 5, start = 100

+ Diagram: slide page 32

2. Test cases：
   `assertEquals("real answer", testedMethod("tested object"));`
   `assertTrue(testedMethod("tested object").equals("real answer"));`
    `assertFalse(!testedMethod("tested object").equals("real answer"));`
    

## From assignment 1:
+ Partitions are part of the overall testing strategy for a method.
  + e.g.: Partition of a parameter should be in Test.java
+ @Test :  before a JUnit test method
+ The comment “covers a < b”: before a JUnit test method