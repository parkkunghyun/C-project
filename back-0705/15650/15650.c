// 중복없이 오름차순!
// 수열은 사전순으로 증가하는 순서! -> 이때 숫자들도 증가해야함!

#include<stdio.h>
int n,m;
int result[10000];
int check[1000];

void dfs(int depth, int cut) {
    if(depth==m) {
        for(int i=0; i<m; i++) {
            printf("%d ",result[i]);
        }
        printf("\n");
        return;
    }
    // 1 2 3
    // 1 2 4
    // 1 3 4
    // 2 3 4

    for(int i = 1; i<=n; i++) {
        if(check[i] == 0 && cut < i) {
            result[depth] = i;
            check[i] = 1;
            dfs(depth+1, i);
            check[i] = 0;
        }
    }

}

int main() {
    scanf("%d %d",&n,&m);

    dfs(0, 0);

    return 0;
}