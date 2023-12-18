## OpenMP


## Java Stream
### 1. Returns the maximum value of arr
```
public static int getMax(int[] arr){
    return Arrays.stream(arr).parallel().max().getAsInt();
}
```

### 2. Convert the ArrayList<Integer> into an int-Array
```
public static int[] toArray(ArrayList<Integer> list){
    Stream<Integer> s = list.stream();
    return s.parallel().mapToInt((Integer x) -> x.intValue()).toArray(); // Integer::intValue
}
```

### 3. Find the index of the maximum value
```
public static int getMaxIndex(double[] arr){
    return IntStream.range(0, arr.length)
                .boxed()     // Convert to Stream<Integer>
                .parallel()  // Enable parallel processing
                .reduce((i, j) -> arr[i] >= arr[j] ? i : j);
}
```

### 4. To determine if z is prime or not.
```
public static boolean isPrime(long z){
    return z > 1 && IntStream.range(0,(long)Math.sqrt(z))
                    .parallel()
                    .boxed()
                    .noneMatch(i -> z % i == 0);;

}
```

### 5. Create an array of cnt random numbers between 0 (incl.) and 1 (excl.) 
```
public static double[] getRandNumbers(int cnt){
    return DoubleStream.generate(() -> Math.random()).limit(cnt).toArray(); // generate: infinite sequence; limit: truncate to cnt element
}
```

### 6. Returns an infinite stream of prime numbers (2,3,5,7,...)
```
public static IntStream getPrimeStream(){
    return IntStream.iterate(2,x->x+1).filter((x) -> isPrime(x));
}
```

### 7. Returns an IntStream with the factors of the number n
```
public static IntStream getFactors(int n){
    return IntStream.rangeClosed(1,n).filter(i -> n%i == 0);
}
```

### 8. Returns an infinite double stream of the factorial numbers 1!, 2!, 3!, ...
```
public static DoubleStream getFactorialStream(){
    final double[] d = { 0 }; 
    return DoubleStream.iterate(1, x -> {
        d[0]++;
        return x*d[0];
    })
}
```

### 9.
```
public static IntStream getSequence() {
        return generateSequence(1);
}

private static IntStream generateSequence(int x) {
    return IntStream.concat(
            IntStream.of(x),
            IntStream.concat(generateSequence(2 * x + 1), generateSequence(3 * x + 1))
    );
}
```