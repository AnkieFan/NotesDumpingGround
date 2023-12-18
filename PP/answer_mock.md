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
{
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
}
else
{
    int msg;
    MPI_Irecv(&msg, 1, MPI_INT, 0, 110, MPI_COMM_WORLD, &request);
    MPI_Wait(&request, &status);
    printf("Process %i out of %i: received msg=%d.\n", my_rank, size, msg);
}
```
## 4. Theory  
### a) 
+ Synchronous communication requires the sending and receiving processes to coordinate directly at the time of the communication. The sender can only proceed once the receiver has started to receive the message. This can lead to blocking behavior, where the sender is stuck until the receiver is ready.
+ Asynchronous (buffered) communication allows the sender to send a message without waiting for the receiver to be ready. The system uses buffers: the message is copied into a system buffer from where the receiver can later retrieve it. This decouples the sender's progress from the receiver's, allowing the sender to continue its work without waiting. However, managing buffer space can add complexity, as there is a finite amount of memory for these buffers.
+ In summary, synchronous communication is like a face-to-face conversation that requires both parties to be present, while asynchronous communication is akin to leaving a voicemail, allowing the sender to continue with other tasks after leaving the message.  

### b)   
+ Collective communication in parallel programming is a method where a single operation is automatically performed across multiple processes within a group. Unlike point-to-point communication, which involves explicit send and receive pairs between individual processes, collective operations involve all processes in a communicator.

+ Common collective operations include:
  + Broadcast: One process sends the same data to all other processes.
  + Gather: All processes send data to one designated process, which collects the data.
  + Scatter: One process has an array of data and distributes the elements to all other processes.
  + Reduce: All processes contribute their data to a single operation (like sum, max, etc.), and the result is made available to one or all processes.

+ Collective communication is useful because:
  + Efficiency: It is often optimized for performance on specific hardware, taking advantage of the underlying network topology.
  + Convenience: It simplifies the code, as the programmer doesn't need to write explicit send/receive pairs for all involved processes.
  + Synchronization: Many collective operations implicitly synchronize processes, which can simplify the design of parallel algorithms.
  + Scalability: It enables easier scaling of parallel applications to large numbers of processes.  

### c) 
+ Blocking communication in parallel programming means that the call to send or receive a message requires the process to wait until the operation is completed before proceeding. For a send operation, completion typically means the data has been transferred to a buffer so that the sender can reuse its send buffer. For a receive operation, it means the data has been received and is available to the process.
+ Non-blocking communication allows a process to initiate a send or receive operation and then proceed with its computation or other operations immediately. The actual data transfer happens in the background, and the process must later check if the communication has completed or wait for its completion before using the data involved in the operation.
+ The key difference is that blocking communication can cause a process to idle and waste computational resources if the other side is not ready, while non-blocking communication allows a process to continue doing useful work while the communication is still in progress. Non-blocking communication can lead to more efficient utilization of resources and better overall performance, especially in scenarios where communication and computation can be overlapped.

## 5. OpenMP
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
