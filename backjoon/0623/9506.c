// 약수들의 합 자기 제외 -> 완전수 파악하기

#include<stdio.h>
#include<stdlib.h>

void measures(int *arr, int n);

int main(void) {
    while(1) {
        int n;
        scanf("%d", &n);
        if(n == -1) {
            break;
        }
        // 약수 구해서 넣기
        int *arr = (int*)malloc(sizeof(int)*n);
        int sum =0; // arr에 담겨온 애들을 전부 합쳤을때 n과 같은지 확인!

        measures(arr, n);

        for(int j=0; arr[j] != '\0'; j++) {
            sum += arr[j];
        }

        if(sum == n) {
            printf("%d = %d",n, arr[0]);

            for(int j=1; arr[j] != '\0'; j++) {
                printf(" + %d", arr[j]);
            }

            printf("\n");
        } else {
            printf("%d is NOT perfect.\n", n);
        }
        free(arr);
    }
    return 0;
}

void measures(int *arr, int n) {
    int idx = 0;
    for(int j=1; j<n; j++) {
        if(n%j==0) {
            arr[idx] = j;
            idx+=1;
        }
    }

}