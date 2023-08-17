// 지구 - E 태양 - S 달- M
// 1 - 15, 1- 28,1 - 19
// 1 1 1
// 16이 되면 지구는 1이됨!

#include<stdio.h>
#include<stdbool.h>

int main() {
    int E,S,M;
    scanf("%d %d %d", &E, &S, &M);

    int result =1;
    while(true) {
        int earth = result%15;
        int sun = result%28;
        int moon = result % 19;

        if(earth ==0 ) { earth = 15;}
        if(sun ==0) {sun =28;}
        if(moon ==0) {moon = 19;}

        if(earth == E && sun == S && moon == M) {
            printf("%d",result);
            break;
        }

        result++;
    }

    return 0;
}