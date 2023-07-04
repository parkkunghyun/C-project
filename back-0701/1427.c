// 1- 1000000 백만가지 주어짐-> 오름차순으로 한개씩 출력 , 중복 안됨

// 2-55분부터 3-20분까지만 고민하자!
// 그러고 답보기!

// qsort -> 퀵 정렬을 사용한다! qsort(정렬할 배열, 요소개수, 크기, 비교함수);
// pivot을 정하고 더 작으면 왼쪽, 크면 오른쪽으로 재귀를 이용해 분할정복한다!

// 일반적으로 O(nlogn)임
// 

#include<stdio.h>
#include<stdlib.h>

int arr[1000000];

// 문자열비교일수도 있고 숫자 비교일수도 있어서 인자는 이걸적었고
// 현재는 정수 비교니까  내부에서 *(int*)a; 를 해준다!
int compare(const void *a, const void *b) {
    int num1 = *(int*)a;
    int num2 = *(int*)b;

    if(num1 < num2) {
        return -1;
    }
    if (num1 > num2) {
        return 1;
    }
    return 0;
}

int main() {
    int n;
    scanf("%d",&n);
    
    for(int i=0; i<n; i++) {
        scanf("%d", &arr[i]);
    }
    
    qsort(arr,n,sizeof(int), compare);
    // 정렬할배열, 요소개수, 요소크기(int인지) , 비교 함수

    for(int i=0; i<n; i++) {
        printf("%d\n",arr[i]);
    }

    return 0;
}
