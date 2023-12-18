# Java Threads

## Threads

## Streams
+ sequence of data: I/O stream, loop
+ Stream types: `IntStream, DoubleStream, LongStream, Stream<V>`
+ Stream object:
  + First data element
  + Operation to iterate over the elements
  + Marker for the last element
  + Probably backing data
+ E.g.: `IntStreams = IntStream.range(0,100);//(First: x=0; x=x+1; Last: x=99)`
  + Iterates over the stream and puts data in array: `int[] arr= s.toArray();//--> array[100] with 0,1,2,….`
  + Short: `int[] arr= IntStream.range(0,100).toArray();`

### Open
#### Open stream of an array:
+ `Arrays.stream(arr);` Returns a stream with the content of the array
+ `col.stream();` Returns a stream with the content of a collection(e.g. ArrayList, LinkedList, …)
+ `col.parallelStream();` Same with parallel stream
+ `IntStream.range(int start, int end)` Stream from start(incl.) to end (excl.)
+ `IntStream.rangeClosed(int start, int end)` Same, but end (incl.)
+ `IntStream.iterate(int seed, IntUnityOperator f)` IntUnityOperator: can be a lambda function  
E.g.:  
```
//Array -> Stream
int[] arr= {2,6,3,9,4,1,8,3,7};
IntStreams = Arrays.stream(arr);

//ArrayList-> Stream
ArrayList<Integer> list= newArrayList<>();
…
Stream<Integer> s = list.stream();

//Stream from0 to9
IntStreams = IntStream.range(0,10);

//Infinite Stream 1,2,3,4,…
IntStreams = IntStream.iterate(1,(int i)->i+1);
```

#### Open stream from a file
`Stream<String> s = new BufferedReader(new FileReader(filename)).lines();`

### Modify
#### Casting stream types
+ IntStream <-> DoubleStream
  + `IntStream.asDoubleStream()`
  + `DoubleStream.mapToInt(DoubleToIntFunction mapper)`
+ IntStream <-> Stream
  + `IntStream.boxed()`
  + `Stream.mapToInt(ToIntFunctionmapper)`

#### `IntStream`:
  + Cuts the stream to x elements: `limit(int x)`
  + Apply a function for each element: `map(IntUnityOperator mapper)`
  + Filter the stream: `filter(IntPredicate predicate)`
  + Only distinct elements: `distinct()`
  + Sort the elements: `sorted()`  

Examples:  
```
//Convert an IntStream to a DoubleStream and back.
IntStream s = IntStream.range(0,10);
DoubleStream ds= s.asDoubleStream();
IntStream s2 = ds.mapToInt((double d) -> (int) d);

//Stream from 2 to 100, only even numbers
IntStream s = IntStream.iterate(2,(int i)->i+2).limit(50);
//or
IntStream s = IntStream.rangeClosed(1,50).map((int i)->i*2);
//or
IntStream s = IntStream.rangeClosed(2,100).filter((int i)->(i%2==0));
```
#### Lambda expression
+ `Integer::intValue`, `(Integer x) -> x.IntValue()`
+ `(int i) -> (i%2 ==0)`
+ `reduce((i, j) -> arr[i] >= arr[j] ? i : j)` find the index of max value
+ `reduce((a, b) -> a >= b ? a : b)` find the max value 原理：先比较前两个元素，再用结果对比下一个元素, same as `max(Integer::compareTo)`

### Close
+ Collect stream in array `toarray()`
+ Collect stream in collection: `collect()`
+ Apply a function for each element: `forEach()`
+ Apply a reduction function: `reduce()` (combine elements of a stream into a single result)
+ `average()`, `count()`, `max()`, `min()`, `sum()`
+ `boxed()` Boxing is the process of converting a primitive type to its corresponding wrapper class (e.g., int to Integer). Conversely, unboxing is the process of converting a wrapper class to its primitive type.

Examples:
```
//array[100] with 0,1,2,….
int[] arr= IntStream.range(0,100).toArray();
//ArrayList with 0,1,2,….99
List<Integer> list=(List<Integer>)IntStream.range(0,100).boxed().collect(Collectors.toList());
//or 
ArrayList<Integer> list= newArrayList<>();
IntStream.range(0,100).forEach((inti)-> list.add(i));
//Print the elements of a stream
IntStream.range(0,100).forEach(System.out::println);

// Boxing:
IntStream intStream = IntStream.of(intArray);
// Use boxed() to convert IntStream to Stream<Integer>
Stream<Integer> boxedStream = intStream.boxed()

// Unboxing:
IntStream intStream = boxedStream.mapToInt(Integer::intValue);
```

### Parallel Loops with Streams
Add 1 toeachelementofan arrayx
```
//Serial version:
IntStream.range(0,x.length).forEach((inti)->x[i]++);
//or
x = Arrays.stream(x).map((intz)->z+1).toArray();

Parallel version:
IntStream.range(0,x.length).parallel().forEach((inti)->x[i]++);
//or
x = Arrays.stream(x).parallel().map((intz)->z+1).toArray();
```