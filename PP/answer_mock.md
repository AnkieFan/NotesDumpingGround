2. Find bugs
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

3. Send and Receive
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

4. Theory  
a) 
+ Synchronous communication requires the sending and receiving processes to coordinate directly at the time of the communication. The sender can only proceed once the receiver has started to receive the message. This can lead to blocking behavior, where the sender is stuck until the receiver is ready.
+ Asynchronous (buffered) communication allows the sender to send a message without waiting for the receiver to be ready. The system uses buffers: the message is copied into a system buffer from where the receiver can later retrieve it. This decouples the sender's progress from the receiver's, allowing the sender to continue its work without waiting. However, managing buffer space can add complexity, as there is a finite amount of memory for these buffers.
+ In summary, synchronous communication is like a face-to-face conversation that requires both parties to be present, while asynchronous communication is akin to leaving a voicemail, allowing the sender to continue with other tasks after leaving the message.  

b)   
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

c) 