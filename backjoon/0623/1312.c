// 소수점 아래 숫자 구하기!
// 소수를 구한다란?
// 20 7 8
// 정수 부분: 2
// 남은거 6
// 60  그래서 처음은 이걸 계산하면 되네!!

// 근데 소수점부터만 계산이네!!


#include<stdio.h>

int main(void) {
    int a,b,n;
    int result;

    scanf("%d %d %d", &a, &b, &n);
    // 25 7 5
    for(int i =0; i<n; i++) {
        a %=b; // 4 5 1 3 2 
        a*=10; //
        result = a/b; // 5 7 1 4 2
    }
    printf("%d",result);

    return 0;
}