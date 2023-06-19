#include<stdio.h>

// int arr[10];
// GetOddSum

int GetOddSum(const int *base, int asize);

int main(void){
    int arr[10] = {1,2,3,4,5,6,7,8,9, 10};
    printf("홀수의 합계: %d\n", GetOddSum(arr,10));
    return 0;
}
int GetOddSum(const int *base, int asize) {
    int sum =0;
    for(int i =0; i<asize; i++) {
        if(base[i] %2 != 0) {
            sum += base[i];
        }
    }
    
    return sum;
}