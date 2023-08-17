// N 과 M
// 1-N 까지 자연수 중에 중복없이 M개를 고른 수열!
// 사전순으로 증가하는 순서로 수열 출력하기

// 10 -10:20까지 고민하기!
// 1 2 3 4
// 1 2 4 3
// 
#include<stdio.h>
int n, m;
int result[1000];
int check[1000];

void dfs(int depth) {
    if(depth==m) {
        for(int i =0; i<m; i++) {
            printf("%d ",result[i]);
        }
        printf("\n");
        return;
    }

// 4 ,2 
// check는 각 숫자를 넣고 검사하는 곳!
// 1 2
// 1 3
// 1 4
// 2 1
    for(int i =1; i<=n; i++) {
        if(check[i] ==0) {
            result[depth] = i;
            check[i] = 1;
            dfs(depth+1); 
            check[i] = 0;
        }
    }
}

int main() {
    scanf("%d %d",&n,&m);
    dfs(0);

    return 0;
}