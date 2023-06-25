// 제일 큰값 찾아 맨뒤와 교체
// n^2

#include<stdio.h>
#define SWAP(a,b) {int t=a; a=b; b=t;}

void SelectionSort(int *base, int n);
void ViewArr(int *arr, int n);

int main(void) {
    int arr[10] = { 9,4,3,10,5,8,7,6,2,1 };
    SelectionSort(arr, 10);
    return 0;
}

void SelectionSort(int *base, int n) {
    ViewArr(base,n);
     int maxi = 0;
    for(int i=n; i>1; i--) {
        maxi = 0;// 최대값이 들어있는 인덱스!
        for(int j=1; j<i; j++) {
            if(base[maxi] < base[j]) {
                maxi = j;
            }
        }
        SWAP(base[maxi], base[i-1]);
        ViewArr(base,n);
    }
}

void ViewArr(int *arr, int n) {
    for(int i =0; i<n; i++) {
        printf("%3d", *(arr+i));
    }

    printf("\n");
}