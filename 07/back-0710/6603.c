// 1-49에서 6개 고르기
// 7개중 6개 고르는 방법 -> 1,2,3,4,5,6

// 6 6 -> 1
// 7 6 -> 7 7c1
// 8 6 ->  8c 2 -> 28
// 9 6 -> 9 c 6 -> 84
// 10 6 -> 10 c 6 -> 
// 

#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>
#include<string.h>
#include<math.h>

#define MAX_SIZE 50

int order;
int * rand_n; // 
bool visited[MAX_SIZE];
int ans[6];

void func(int start, int depth) {
    if(depth == 6) {
        for(int i=0; i<6; i++) {
            printf("%d ", ans[i]);
        }
        printf("\n");
        return;
    }

    for(int i = start; i<order; i++) {
        ans[depth] = rand_n[i];
        func(i+1, depth+1);
    }
}

int main () {
    while(true) {
        scanf("%d", &order);
        if(!order) {break;}

        rand_n = (int*)malloc(sizeof(int)* order);
        for(int i=0; i<order; i++) {
            scanf("%d", &rand_n[i]);
        }
        func(0,0);
        printf("\n");

        free(rand_n);
    }
    return 0;
}