#include <stdlib.h>
#include <stdio.h>


int main(int argc, char** argv){
    int i = 5;
    printf("value of i: %i", i);


    int j[10];
    printf("value of i: %i", j[0]); //不一定出现什么值，不是0

    int a;
    scanf("%i", &a); //键盘输入,返回值是占位符的数量%i
    int *l = malloc(a*sizeof(int)); //*var指针 存的是地址值 malloc返回的是地址
    printf("value of i: %i", l[1]);

    return 0;
}