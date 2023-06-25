// 이웃한 원소를비교 -> 제일 큰값 제일 맨뒤!
// n^2
#include<stdio.h>

#define SWAP(a,b) {int t=a; a=b; b=t;}

void BubbleSort(int *base, int n);
void ViewArr(int *arr, int n);

int main(void) {
    int arr[10] = {9,4,3,10,5,8,7,6,2,1};
    BubbleSort(arr, 10);
    return 0;
}


void BubbleSort(int *base, int n) {
    ViewArr(base,n);

    for(int i=n; i>1; i--) {
        // i가 나타내는 의미는 고정 부분!
        for(int j = 1; j<i; j++) {
            if(base[j-1] > base[j]) {
                SWAP(base[j-1], base[j]);
                ViewArr(base,n);
            }
        }
    }

}
void ViewArr(int *arr, int n) {
    for(int i=0; i<n; i++) {
        printf("%3d", *(arr+i));
    }
    printf("\n");

}