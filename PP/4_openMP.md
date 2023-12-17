# OpenMP

## OpenMP Model
+ OpenMP programs start with just one thread: The Master
+ **Worker** threads are spawned
at **Parallel Regions**, together
with the Master they form the
**Team** of threads.
`#pragma omp parallel { ... }`

## Specification of number of threads:
+ Environment variable: `OMP_NUM_THREADS = ...`
+ via clause: `num_threads(num)`

## For Worksharing
+ the work is automatically divided among the threads
```
int i;
#pragma omp for
for(i = 0;i<100;i++)
{
    a[i] = b[i] + c[i];
}
```
### Parallel Loop Scheduling
+ the schedule clause:
  + `schedule(static [, chunk])`: Iteration space divided into blocks of chunk size, blocks are assigned to threads in a round-robin fashion.
  + `schedule(dynamic [, chunk])`: Iteration space divided into blocks of chunk (not specified: 1) size, blocks are scheduled to threads in the order in which threads finish previous blocks.
  + `schedule(guided [, chunk])`: Similar to dynamic, but block size starts with implementation-defined value, then is decreased exponentially down to chunk.
```
#pragma omp parallel for schedule(static, 10)
for (int i = 0; i < N; ++i) {
    // Each thread works on a chunk of 10 iterations
    sum += i;
}
```

## Synchronization
### Critical Region
+ A **Critical Region** is executed by all threads, but by only one thread simultaneously (Mutual Exclusion).
+ `#pragma omp critical (name) {... structured block ...}`

### Data Scoping 范围界定
+ *private*-list and *shared*-list on Parallel Region
+ *private*-list and *shared*-list on Worksharing constructs
+ **General default** is shared for Parallel Region, *firstprivate* for Tasks
+ Loop control variables on for-constructs are *private*
+ Non-static variables local to Parallel Regions are *private*
+ *private*: A new uninitialized instance is created for each thread
  + *firstprivate*: Initialization with Master‘s value
  + *lastprivate*: Value of last loop iteration is written back to Master
+ Static and Global variables are *shared*

```
int shared_var = 0;
#pragma omp parallel shared(shared_var)
{
    // code that can access and modify shared_var
}
```
### Clauses examples:
+ `num_threads=4`
+ `private(i)`
+ `shared(array)`
+ `reduction(+:sum)`
+ `firstprivate(x) lastprivate(result)`
+ `default(shared | none)`

## The Barrier Construct
+ Threads wait until all threads of the current Team have reached the barrier
+ `#pragma omp barrier`
+ All worksharing constructs contain an implicit barrier at the end

## The Reduction Clause
+ `#pragma omp parallel for reduction(operator: variable)`
+ Operators:  `+` for addition, `*` for multiplication, `-` for subtraction, `&` for bitwise AND, `|` for bitwise OR, `^` for bitwise XOR, `&&` for logical AND, `||` for logical OR, `min` for least number, `max` for largest number
+ E.g.: 
```
int sum = 0; 
#pragma omp parallel for reduction(+:sum) 
for (int i = 1; i <= n; ++i) {
    sum += i;
}
```
+ In a reduction-operation the operator is applied to all variables in the list. The variables have to be shared.

`#pragma omp parallel for private(fX,i) reduction(+:fSum)`

## Single and Master Construct
+ `#pragma omp single [clause]`: to enclose a block of code that should be executed by a single thread(I/O, setup work etc.)
+ `#pragma omp master[clause]`: to enclose a block of code that should be executed only by the master thread(ID=0).
  + The master construct is no worksharing construct and does not contain an implicit barrier at the end.

## Section and Ordered Construct
+ The Section Construct: divides the enclosed code into individual sections, and each section is executed by a different thread. 
+ The number of threads is determined by the `num_threads` clause or the number of available threads in the parallel region.
```
#pragma omp parallel sections
{
    #pragma omp section
    {
        // Code for section 1, executed by one thread
    }
    #pragma omp section
    {
        // Code for section 2, executed by another thread
    }
    // Additional sections can be added as needed
}
```
+ The ordered Construct
```
#pragma omp parallel for ordered
for (int i = 0; i < 10; ++i) {
        #pragma omp ordered
        {
            // Code for each iteration, executed in order
            printf("Thread %d executes iteration %d\n", omp_get_thread_num(), i);
    }
}
```

## Runtime Library
```
#include <omp.h>
#include <stdio.h>

int main() {
    omp_set_num_threads(4); 
    #pragma omp parallel //same with #pragma omp parallel num_threads=4
    {
        printf("Hello from thread %d of %d\n", omp_get_thread_num(), omp_get_num_threads());
    }

    return 0;
}
```

## Tasking
```
int fib(int n) {
    if (n < 2) return n;
    int x, y;
    #pragma omp task shared(x)
    {
        x = fib(n - 1);
    }
    #pragma omp task shared(y)
    {
        y = fib(n - 2);
    }
    #pragma omp taskwait
        return x+y; //Taskwait is required, as otherwise x and y would be lost
}
```

### Taskwait and Barrier:
`barrier` synchronizes **all threads** in the parallel region, while `taskwait` synchronizes **a thread** with the completion of its child tasks.

## More Environment Variables:
+ windows: `set VARIABLE_NAME=value`
+ linux: `setx VARIABLE_NAME value`
+ `OMP_NUM_THREADS`: Controls how many threads will be used to execute the program.
+ `OMP_SCHEDULE`: If the schedule-type runtime is specified in a schedule clause, the value specified in this environment variable will be used.
+ `OMP_DYNAMIC`: The OpenMP runtime is allowed to smartly guess how many threads might deliver the best performance. If you want full control, set this variable to false.
+ `OMP_NESTED`: Most OpenMP implementations require this to be set
to true in order to enabled nested Parallel Regions. Remember:
Nesting Worksharing constructs is not possible.

## False Sharing
Each processor has its own cache, and when one thread updates a variable, the entire cache line containing that variable is typically marked as modified. If another thread on a different processor is working with a different variable on the same cache line, it might experience unnecessary cache invalidations, leading to degraded performance.