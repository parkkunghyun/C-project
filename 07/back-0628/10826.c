#include<stdio.h>

int n[10001];
int num;

void fibo(int index){
    // 재귀로 할꺼여서 인덱스를 설정
    n[0] = 0;
    n[1] = 1;
    if(index == num) {
        n[index] = n[index-1] + n[index-2];
        return;
    }else {
        n[index] = n[index-1] + n[index-2];
        fibo(index+1);
    }
}

int main(void) {

    scanf("%d", &num);
    fibo(2);
    printf("%d", n[num] );

    return 0;
}