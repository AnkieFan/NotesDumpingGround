
## Computer Architectures
### Shared-Memory Parallel Systems
+ Implicit data distribution
+ Implicit communication
+ SMP Symmetric Multi Processing: Memory access time is uniform on all cores  
+ ccNUMA (cache coherent Non Uniform Memory Architecture): 
+ Cache Coherence (cc): If there are multiple caches not shared by all cores in the system, the system takes care of the cache coherence.

### Distributed-Memory Parallel Systems
+ Explicit data distribution
+ Explicit communication
+ Clusters: Various independent computers are connected to each other over a non cache coherent second level interconnect

## Parallelization at a Glance
### Basic Concepts
+ Processes: A process is the abstraction of a program in execution.
  + Statuses: Running, Waiting, Blocked
+ Threads: A thread is a lightweight process
+ Shared memory Parallelization: Memory can be accessed by several threads running on different cores in a multi socket / multi core system
+ Distributed memory Parallelization: Each process has its own distinct memory

### Parallelization Strategies
+ Time using 1 CPU: $T(1)$
+ Time using 𝑝 CPUs: $T(p)$
+ Speedup 𝑆: $S(p) = \frac{T(1)}{T(p)}$
+ Efficiency 𝐸: $E(p) = \frac{S(p)}{p}$

#### Amdahl’s Law
+ $f$: serial part $(0 < f \leq 1)$ the part that cannot be parallelized
+ $S(p) = \frac{T(1)}{T(p)} = \frac{T(1)}{f*T(1)+(1-f)*\frac{T(1)}{p}} = \frac{1}{f+\frac{1-f}{p}}$

### Granularity 粒度 子节点有多少
+ Parallelization on a High Level (low granularity)
  + Chances of low synchronization / communication cost
  + Danger of load balancing issues
+ Parallelization on a Low Level (high granularity)

### Prominent Issues
+ Data Race: Concurrent access of the same memory location by multiple threads without proper synchronization
+ Deadlock: When two or more threads / processes are waiting for another to release a resource in a circular chain, the program appears to 'hang'
+ Load Balancing: Some threads / processes take longer than others, but all threads / processes have to wait for the slowest thread / process
+ Serialization: When threads / processes wait 'too much'