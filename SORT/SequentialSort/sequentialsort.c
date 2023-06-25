// 순차정렬
// 배열의 시작주소, 원소 개수, 비교 알고리즘 필요!
// 맨앞부터 제일 작은 원소를 배치하게 만드는 알고리즘
// 작다는게 확인되면 일단 앞으로 가져옴!

// 이게 제일 무식한 정렬
// n^2 => n*(n+1)

#include<stdio.h>

#define SWAP(a,b) {int temp; temp=a; a=b; b=temp;}
// 매크로 함수
void SequenceSort(int *base, int n);

int main(void) {
    int arr[10] = {9,4,3,10,5,8,7,6,2,1};
    SequenceSort(arr, 10);

    return 0;
}
void ViewArr(int *base,int n);
void SequenceSort(int *base, int n) {
    // 가장 작은 값을 저장할 애가 필요!
    // 그리고 앞에가 제일 작게 되면 그 다음 작은애 넣어주기!
    int i,j;
    ViewArr(base,n); // 현재 상태 출력
    for(i=0; i<n; i++) {
        for(j=i+1; j<n; j++) {
            if(base[i] >base[j]) {
                SWAP(base[i], base[j]);
                ViewArr(base,n);
            }
        }
    }

}

void ViewArr(int *base,int n) {
    for(int i=0; i<n; i++) {
        printf("%3d", *(base+i));
    }
    printf("\n");
}