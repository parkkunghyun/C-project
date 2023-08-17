#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

#define MAX_VERTICES 1001


int arr[MAX_VERTICES][MAX_VERTICES] = {0,};
int dfs_v[MAX_VERTICES] = {0,};
int bfs_v[MAX_VERTICES] = {0,};
int queue[MAX_VERTICES];

void dfs(int v, int n) {
    int w;
    dfs_v[v] = 1;
    printf("%d ", v);
    for(w = 1; w<= n; w++) {
        if(arr[v][w] == 1 && dfs_v[w] == 0) {
            dfs(w, n);
        }
    }
    

}
void bfs(int v, int n) {

}

int main() {
    int N,M,V; // 정점, 간선, 정점 번호
    scanf("%d %d %d", &N, &M, &V);
    
    for(int z =0; z<M; z++) {
        int i,j;
        scanf("%d %d",&i,&j);
        arr[i][j] = 1;
        arr[j][i] = 1;
    }
    dfs(V,N);
    printf("\n");
    bfs(V,N);

    return 0;
}