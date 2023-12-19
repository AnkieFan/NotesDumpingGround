## 1. Theory
+ Data race: If between two synchronization points at least one thread writes to a memory location from which at least one other thread reads, the result is not deterministic (race condition).   
+ Deadlock: A deadlock is a situation in parallel programming where a set of processes are blocked because each process is waiting for a resource that another process holds. None of the processes can proceed, because there is a circular chain of processes each of which is waiting for a resource held by the next member of the chain.

## 2. Find bugs
```
#include <stdio.h>
#include "mpi.h"
int main(int argc, char** argv) {
    int procRank, procCount, n;
    MPI_Init(&argc, &argv); // not MPI_Initialize
    MPI_Comm_size(MPI_COMM_WORLD, &procCount); //1. Return error, send memory address of procCount to this function 2. should be MPI_COMM_WORLD
    MPI_Comm_rank(MPI_COMM_WORLD, &procRank);

    if (procRank == 0) {
        printf("Please enter an integer number\n");
        scanf("%d", &n);
    }

    MPI_Bcast(&n, 1, MPI_INT, 0, MPI_COMM_WORLD); //wrong usage of MPI_Bcast

    if (procRank != 0) {
        printf("Number %d received by process %d\n", n, procRank);
    }

    MPI_Finalize();
    return 0; // after finalization
}
```

## 3. Send and Receive
Modify the following program so that it uses non-blocking methods instead of blocking methods.
Hint: The behavior of the program does not need to stay exactly the same.
```
MPI_Request request;
...
if(procRank ==0){
    int* msg = (int*) malloc(size * sizeof(int));
    for(i=1; i<size; i++)
    {
        msg[i-1] = 4711 + i;
        MPI_Isend(&msg[i - 1], 1, MPI_INT, i, 110, MPI_COMM_WORLD, &request);
        MPI_Wait(&request, &status);
        /* Or use MPI_Test, same when receiving:
        MPI_Test(&request, &flag, &status);

        while (!flag) {
            MPI_Test(&request, &flag, &status);
        }
        */
    }
    free(msg);
}else{
    int msg;
    MPI_Irecv(&msg, 1, MPI_INT, 0, 110, MPI_COMM_WORLD, &request);
    MPI_Wait(&request, &status);
    printf("Process %i out of %i: received msg=%d.\n", my_rank, size, msg);
}
```

### 3.1 Max-Norm (MPI) 
Compute in parallel and efficiently as possible the max-norm of a vector v with length L that has real numbers as components. The vector v and its length L are known to the master process (rank 0). The computation should be done evenly divided on all available processes.
Hints:
1. Assume that L is divisable by the number of processes without a rest.
2. Assume that procCount (number of processes) and procRank (rank of the process) are initialized.
3. The vector v contains only positive numbers
4. The max-norm is defined as follows $||x||_{\infin} = max^n_{i=1}|x_i|$

```
#include <stdio.h>
#include <stdlib.h>
#include "mpi.h"

void initVector(double *v, const int length){
    for(int i =0;i<length;i++)
        v[i] = read() % 100 + ((double) rand()/RAND_MAX)
}

void printVector(double* v, const int length){
    for(int i =0;i<length;i++)
        printf("%lf\n", v[i]);
}

int main(int argc, char** argv){
    int procRank, procCount, L;
    double norm;
    double* v;

    MPI_Init(&argc, &argv);
    MPI_Comm_rank(MPI_COMM_WORLD, &procRank);
    MPI_Comm_size(MPI_COMM_WORLD, &procCount);

    if(procRank == 0){
        L = 25;
        v = (double *)malloc(L * sizeof(double));

        initVector(v,L);
        printVector(v,L);
        
        // Here, code may be missing
        MPI_Scatter(v, L / procCount, MPI_DOUBLE, MPI_IN_PLACE, L / procCount, MPI_DOUBLE, 0, MPI_COMM_WORLD);

    } // Here, code may be missing
    else{
        v = (double *)malloc((L / procCount) * sizeof(double));
        MPI_Scatter(NULL, L / procCount, MPI_DOUBLE, v, L / procCount, MPI_DOUBLE, 0, MPI_COMM_WORLD);
    }

    double localMaxNorm = 0.0;
    for (int i = 0; i < L / procCount; i++) {
        if (v[i] > localMaxNorm) {
            localMaxNorm = v[i];
        }
    }

    MPI_Gather(&localMaxNorm, 1, MPI_DOUBLE, &norm, 1, MPI_DOUBLE, 0, MPI_COMM_WORLD);

    if(procRank == 0){
        for (int i = 0; i < procCount; i++) {
            if (norms[i] > norm) {
                norm = norms[i];
            }
        }
        printf("the max norm in %f\n", norm)
    }

    // Here, code may be missing
    MPI_Finalize();

    return 0;
}
```
## 4. Theory  
### a) Difference between asynchronous (buffered) and synchronous communication
+ Synchronous: 
  + send call will only start when the destination has started synchronous receive
  + send operation will complete only after acknowledgement that the message was safely received by the receiving process (destination has copied data out of incoming buffer into memory)
+ Asynchronous (buffered):
  + a send operation may "complete" even though the receiving process has not actually received the message
  + only know that message has left
+ Asynchronous (buffered) communication allows processes to continue execution without waiting for data transfer completion, while synchronous communication ensures processes are synchronized and wait until the data transfer is finished before proceeding. 

### b) Principle of collective communication
+ Collective communication in parallel programming is a method where a single operation is automatically performed across multiple processes within a group. All processes in the communicator must call the same routine.
+ Collective communication is useful in parallel computing because it enables efficient coordination and information exchange among processes, enhancing overall performance by synchronizing and distributing data collectively.

### c) Difference between blocking and non-blocking communication
+ Blocking: Relates to the completion of an operation in the sense, that used resources, i.e. buffers, are free to use again
+ Non-blocking: Functions return as soon as possible but provided buffers must not be touched until another appropriate call successfully indicates that they are not in use anymore. Even read only access may be prohibited.
+ Blocking communication waits for the completion of data transfer, while non-blocking communication allows tasks to proceed without waiting for the transfer to finish.

### d) Explain what the metoh MPI_Barrier(MPI_Comm comm) does.
It forces all processes within the specified communication group (comm) to wait until they have all reached the same point in their execution before proceeding. It is a collective operation that acts as a synchronization barrier, ensuring that no process moves ahead until all processes have arrived at the barrier.

## 5. Sum of an Array (OpenMP)
### a)
```
void sum_up(long* a, int num){
    long s = 0;
    #pragma omp parallel for reduction(+:s)
    {
        for(int i = 0;i<num; i++)
            s += a[i];
    }
    printf("Sum: %ld\n", s);
}
```

### b)
```
void sum_up(long* a, int num) {
    long s = 0;

    #pragma omp parallel for
    {
        long local_sum = 0;
        for(int i = 0;i<num;i++){
            local_sum += a[i];
        }

        #pragma omp critical
        {
            s += local_sum;
        }
    }
    printf("Sum: %ld\n", s);
}
```

## 6.
1. `static`: In static scheduling, the iterations are divided into chunks of a fixed size (chunk). Each thread is assigned a chunk of iterations to work on. The chunk size is specified as an optional parameter.
   + clause: `schedule(static, chunk)`
2. `dynamic`: In dynamic scheduling, the iterations are dynamically assigned to threads. Each thread picks up a chunk of iterations as it completes its previous chunk. The chunk size is again an optional parameter.
   + clause: `schedule(dynamic, chunk)`
3. `guided`: Guided scheduling is similar to dynamic scheduling, but the chunk size starts large and decreases exponentially. This can be beneficial for load balancing as threads that finish early can pick up smaller chunks of remaining work.
   + clause: `schedule(guided, chunk)`

## 6.1 Recursion (OpenMP)
Explain how you would parallelise a recursive algorithm with OpenMP. give an example to illustrate your explanation  
1. Identify Recursive Structure
2. Define Parallel Regions: Use OpenMP directives to define parallel regions where tasks can be executed concurrently using `#pragma omp parallel` and `#pragma omp single`.
3. Use `#pragma omp task` directives to create tasks for the parallel execution of recursive calls. Each task represents an independent computation.
4. Task Synchronization: Use `#pragma omp taskwait` or other synchronization mechanisms to ensure that the program waits for the completion of parallel tasks before proceeding.

```
int fib(int n){
    if (n<2) return n;
    int x,y;
    #pragma omp task shared(x)
    {
        x = fib(x-1);
    }

    #pragma omp task shared(y)
    {
        y = fib(y-2);
    }

    #pragma omp taskwait
    return x+y;
}

int main(){
    int n = 10;

    #pragma omp parallel
    #pragma omp single
    {
        #pragma omp task shared(n)
        int result = fibonacci(n);

        #pragma omp taskwait
        printf("Fibonacci(%d) = %d\n",n,result)
    }
    return 0;
}
```

## 7. Java Streams
### a)
```
public static Stream<String> getLetters() {
    // Using Stream.of to create a stream with the letters A-Z followed by a-z
    return Stream.concat(
            Stream.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M","N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"),
            Stream.of("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m","n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z")
        );
}
```

### b)
```
public static int[] getPositiveNumbers(int[] arr) {
    return Arrays.stream(arr)
                .parallel()  // Enable parallel processing
                .filter(x -> x > 0)
                .toArray();
}
```

### c)
```
import java.util.stream.IntStream;


public static int[] checkGoldbachsConjecture(int z) {
    if (z % 2 != 0 || z < 4) {
        throw new RuntimeException(z + " must be even and >=4");
    }

    int[] primes = getPrimes(z).toArray();

    return IntStream.range(0, primes.length)
                .parallel()
                .boxed()
                .flatMap(i -> IntStream.range(i, primes.length)
                        .filter(j -> primes[i] + primes[j] == z)
                        .mapToObj(j -> new int[]{primes[i], primes[j]})
                )
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Goldbach's conjecture is disproved for " + z));
}

private static IntStream getPrimes(int z) {
    return IntStream.range(2, z)
                .filter(GoldbachConjecture::isPrime);
}

private static boolean isPrime(int n) {
    return n > 1 && IntStream.range(2, (int) Math.sqrt(n) + 1).noneMatch(i -> n % i == 0);
}
```

## 7.1
### a)
```
public static IntStream infinite(int z){
    if(z > 1)
        return IntStream.iterate(1, i -> (i % z) + 1);
    else
        return IntStream.iterate(1,i -> 1);
}
```
### b)
```
public static void norm(double[] arr){
    OptionalDouble max = Arrays.stream(arr).parallel().max();
    Arrays.setAll(arr, i -> arr[i] / max);
}
```

### c)

```
public static double getSum(double[][] matrix){
    return Arrays.stream(matrix).parallel().flatMapToDouble(Arrays::stream).sum();
}
```