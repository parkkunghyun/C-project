// 피보나치 0 
#include<stdio.h>

int num[46];

int fibo(int n) {
    num[0] = 0;
    num[1] = 1;

    for(int i=2; i<=n; i++) {
        num[i] =  num[i-1] + num[i-2];
    }
    return num[n];
}

int main(void) {
    int n;
    scanf("%d",&n);
    // 현재인덱스, n, 현재 값 
    int result = fibo(n);
    printf("%d\n",result);

    return 0;
}