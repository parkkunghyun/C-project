// dfs bfs
// dfs를 위한 visited가 필요!
// bfs는 끝까지 갔을때 돌아오기 -> 큐 필요?

#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

int Graph[1001][1001] = {0};
int DfsVisit[1001] = {0};
int BfsVisit[1001] = {0};
int queue[1001];


void dfs(int v, int n) {
    int i;
    DfsVisit[v] = 1;
    printf("%d",v );
    for(i=1; i<=n; i++) {
        if(Graph[v][i] == 1 && DfsVisit[i] == 0) {
            dfs(i,n);
        }
    }
    return;
}

void bfs(int v, int n) {
    int front = 0, rear=0, Pop, i;
    printf("%d",v);

    queue[0] = v;
    rear++;
    BfsVisit[v] = 1;

    while(front < rear) {
        Pop = queue[front];
        front++;

        for(i = 1; i<=n; i++) {
            if(Graph[Pop][i] == 1 && BfsVisit[i]==0) {
                printf("%d", i);
                queue[rear] = i;
                rear++;
                BfsVisit[i] = 1;
            }
        }
    }
    return;
}

int main() {
    int n,m,v;
    scanf("%d %d %d",&n,&m,&v);
    
    for(int i =0; i<m; i++) {
        int y,x;
        scanf("%d %d",&y, &x);
        Graph[y][x] = 1;
        Graph[x][y] = 1;
    }

    dfs(v,n);
    printf("\n");
    bfs(v,n);

    return 0;
}