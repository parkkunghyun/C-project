// 1-N까지 자연수 중에서 M개 고른 수열
// 중복가능, 비 내림차순!
// 걍 오름차순처럼 적혀야하나봄!

#include<stdio.h>

int n,m;
int result[1000];

void dfs(int depth, int cut) {
    if(depth ==m) {
        for(int i=0; i<m; i++) {
            printf("%d ", result[i]);
        }
        printf("\n");
        return;
    }

    for(int i=1; i<=n; i++) {
        if(cut <=i) {
            result[depth] = i;
            dfs(depth+1, i);
            
        }
    }
}

int main(){
    scanf("%d %d", &n, &m);
    dfs(0, 0);

    return 0;
}