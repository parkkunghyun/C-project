// 1 3 5 7 9 -> 이게 n-2개 만큼
//
#include<stdio.h>

void makeMountin(int n);
int main(void) {
    printf("높이: ");
    int n;
    scanf("%d",&n);

    // 첫번째 산
    makeMountin(n);
    // 두번째 산 *2
    makeMountin(2*n);
    // 마지막 산
    makeMountin(n);
    return 0;
}

void makeMountin(int n) {
    for(int i =1; i<=n; i++) {
        // space
        for(int j=i; j<n; j++) {
            printf(" ");
        }
        // *
        for(int j=1; j<=2*i-1; j++) {
            printf("*");
        }
        // space
        for(int j=i; j<n; j++) {
            printf(" ");
        }
        printf("\n");
    }

    return;
}