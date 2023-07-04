// 3시 20분부터 3시 40분까지!

// N인 A,B S = A[0]*B[0] + .. A[n-1]*B[n-1]
// S값 작게 하기 위해 A를 재배열! B는말고!!

// 최대 50개
// B의 가장 작은 부분들에 대해 인덱스를 알고 A에서 큰 숫자들 
// 하나씩 넣어주면 될듯!

#include<stdio.h>
#include<stdlib.h>

// 오름차순
int upCompare(const void *a, const void *b) {
    int num1 = *(int*)a;
    int num2 = *(int*)b;

    if(num1 > num2) return 1;
    if(num1 < num2) return -1;
    return 0;    
}


int main() {
    int n;
    scanf("%d",&n);
    int A[n];
    int B[n];
    for(int i=0; i<n; i++) {
        scanf("%d",&A[i]);
    }
    for(int i=0; i<n; i++) {
        scanf("%d",&B[i]);
    }

    // 근데 내가 B를 재배열한지 어떻게 알아?
    qsort(A,n,sizeof(int), upCompare);
    qsort(B,n,sizeof(int), upCompare);

    
    int sum =0;
    for(int i=0; i<n; i++) {
        sum += A[i]*B[n-i-1];
    }
    printf("%d\n",sum);

    return 0;
}

/*
for(int i=0; i<n; i++) {
       printf("%d ", A[i]);
    }
    printf("\n");
    for(int i=0; i<n; i++) {
       printf("%d ", B[i]);
    }

    printf("\n");
    printf("\n");
*/