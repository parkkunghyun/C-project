// 0을 외치면 최근에 재민이가 쓴 수를 지움
// 수를 부르고 0을 부르면 -> 그 들어가 있는수를 지우기!

#include<stdio.h>
#include<stdlib.h>

int main(void) {
    int k;
    scanf("%d", &k);

    int stack[k];
    int result[k];
    int sum =0;
    int top = 0;
    // 1

    for(int i=0; i<k; i++) {
        stack[i] = 0;
    }

    int n;
    for(int i=1; i<=k; i++) {
        scanf("%d", &n);
    }
    
    printf("%d\n",sum);
    return 0;
}