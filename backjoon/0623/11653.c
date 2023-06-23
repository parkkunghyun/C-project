// N 을 소인수 분해! -> 숫자 천만
// 72 -> 2 2 2 3 3 아마 이숫자로 분해되면 계속 분해야하하는듯?
// 동적할당 받을 구간도 있어야할듯?

#include<stdio.h>
#include<stdlib.h>

int main(void) {
    int n;
    scanf("%d",&n);

    int *arr = (int*)malloc(sizeof(int)* n);

    if(n !=1) {
        int i =2;
        int idx =0;
        while (n != 1)
        {
            if(n % i ==0) {
                arr[idx] = i;
                n = n/i;
                idx+=1;
            }else {
                i+=1;
            }

        }

        for(int j=0; j<idx; j++) {
            printf("%d\n", arr[j]);
        }
        free(arr);
    }


    return 0;
}