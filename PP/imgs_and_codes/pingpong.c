#include <stdio.h>
#include <stdlib.h>
#include <mpi.h>

int main (int argc , char * argv [])
{
   int procRank,procCount, error;
   MPI_Init(&argc, &argv);
   MPI_Comm_size(MPI_COMM_WORLD, &procCount);
   error = MPI_Comm_rank (MPI_COMM_WORLD, &procRank);
   printf("Start[%d]/[%d], error %d \n", procRank, procCount, error);

   const int length = 5; // change output if length!=5
   int message [length];
   enum{ tagSend = 1 };
   if(0 == procRank ) // root recv
   {
      for(int i=1; i<procCount; ++i)
      {
      //receive from process i
      MPI_Recv(message , length, MPI_INT, i, tagSend , MPI_COMM_WORLD , MPI_STATUS_IGNORE);  
      }
   }
   else
   // workers send
   {
   for(int i=0; i< length ; ++i)
      {
      message[i] = procRank+i;
      }
   MPI_Send(message , length , MPI_INT, 0, tagSend , MPI_COMM_WORLD);
   }
   MPI_Finalize();
   return EXIT_SUCCESS;
}