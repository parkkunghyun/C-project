// 각 옆의 수를 빼고 그걸 더해서 최댓값만들기
// 순서를 바꾼 모든 배열을 구한뒤 그걸 빼고 더해주기?
// 8 개 숫자의 순설르 바꾼배열들 구하기?

#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>

int n;
int arr[9];
int Maxs = -100000;
int rep[9];
bool visited[9];
int result;

void dfs(int depth) {
    if(depth == n) {
        result = 0;
        for(int i=0; i<n-1; i++) {
            int subResult = (rep[i] - rep[i+1] );
            if(subResult < 0) { subResult *= -1;}

            result += subResult;
        }
        if(result > Maxs) {
            Maxs = result;
        }
        return;
    }

    for(int i =0; i<n; i++) {
        if(!visited[i]) {
            visited[i] = true;
            rep[depth] = arr[i];
            dfs(depth+1);
            visited[i] = false;
        }
    }
}


int main(){
    scanf("%d", &n);
    for(int i =0; i<n; i++) {
        scanf("%d", &arr[i]);
    }
    dfs(0);
    printf("%d\n", Maxs);

    return 0;
}