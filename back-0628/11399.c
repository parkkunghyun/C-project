// N명 줄서있음 1- n p분
// p분을 구해서 각각 줄을 세워서 최솟값을 구해버리자!

#include<stdio.h>
#include<stdlib.h>

int* compare(int *arr,int n) {
    for(int i=0; i<n; i++) {
        for(int j =i+1; j<n; j++) {
            if(arr[j] <= arr[i]) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
    return arr;
}

int main(void){
    int n;
    scanf("%d", &n);
    int arr[n];
    for(int i=0; i<n; i++) {
        scanf("%d", &arr[i]);
    }
   // 작은수부터 정렬해주는 정렬 만들기!
    compare(arr, n);
    
    int sum =0;
    int subSum = 0;
    
    // 1 2 3 3 4
    // 1 1
    // 1 2 3
    // 1 2 3 6
    // 1 2 3 3 9
    // 1 2 3 3 4 13
    for(int i=0; i<n; i++) {
        for(int j=0; j<=i; j++) {
            subSum += arr[j];
        }
        sum += subSum;
        subSum = 0;
    }
    printf("%d\n", sum);
    return 0;
}