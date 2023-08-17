// a e i o u 중 한개 이상
// 두개이상 자음으로 구성 -> bcdfghjklmnpqrstwxyz
// 오름차순 배열들 abc (0) bca(x)


// 일단 모음 2개 자음4개인거 알아냄 -> 그래서 각 배열에 담음
// 그리고 모든 경우의 수를 출력 후 -> 오름차순인 것만 출력!
// 모음1개 ->자음 3개 -> 2*4 = 8
// 모음2개 -> 자음 2개 -> 6
// 

#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<stdbool.h>

#define MAX 18

int L,C;
char password[MAX];
char ans[MAX];
int visited[MAX];

int cmp(const void* lhs, const void* rhs) {
    if (*(char*)lhs > (*(char*)rhs) ) return 1;
    else return -1;
}

void Input_Base_password() {
    scanf("%d %d", &L, &C);
    for(int i =0; i<C; i++) {
        scanf("%c", &password[i]);
    }
    qsort(password, C, sizeof(char), cmp);
}

void dfs(int depth, int start) {
    if(depth == L) {
        bool flag = false;
        int cnt = 0;
        for(int i =0; i< depth; i++) {
            if(ans[i] == 'a' || ans[i] == 'e' || ans[i] =='i' || ans[i] == 'o' || ans[i] =='u') {
                flag = true;
            }
            else {
                cnt++;
            }
        }

        if(flag && cnt >=2) {
            for(int i =0; i<depth; i++) {
                printf("%c", ans[i]);
            }
            printf("\n");
            return;
        }
        else{
            return;
        }
    }

    for(int i = start; i<C; i++) {
        if(!visited[i]) {
            visited[i] = 1;
            ans[depth] = password[i];
            dfs(depth+1, i+1);
            visited[i] = 0;
        }
    }
}

int main() {
    Input_Base_password();
    dfs(0,0);
    return 0;
}