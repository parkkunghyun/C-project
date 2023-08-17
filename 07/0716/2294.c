// 7시45 - 8시
// 동전 개수는 상관없이 가치의 합이 k원이 되도록하기
// 개수 최소

// 불가능하면 -1
// 그냥 백트래킹으로 전부 검사하면 될듯?
// 힌트가 dp?

// 하나의 동전을 여러번 사용한경우? -> 즉  %를 했는데 0이면 가능!
// 그리고 섞는거? -? 이건 가장 큰거로 먼저 빼주고 현재 값에서 계속 비교해서 적어주기!

// dp배열의 index를 동전으로 할지, 가치로 할지 정해야함!
// dp[가치] = 최소 동전개수
// dp[k]로 한 뒤 각 동전을 얼마나 사용하면 이 값이 되는지를 보여줌!
// dp[5] = 1
// dp[12] + dp[3] = dp[15] => dp[3]은 3이다!
// dp[15] = dp[10] + dp[5] => dp[5] + dp[5] + dp[0]+1
#include<stdio.h>

int n,k;
int input[101];
int dp[10001];

int MIN(int x, int y) { return x<y ? x : y ;}

int main() {
    scanf("%d %d",&n, &k);
    for(int i =1; i<=n; i++) {
        scanf("%d",&input[i]);
    }
    for(int i=1; i<=k; i++) { dp[i] = 100001; }

    dp[0] = 0;
    for(int i=1; i<=n; i++) {
        for(int j = input[i]; j<=k; j++) {
            dp[j] = MIN(dp[j], dp[j-input[i]]+1 );
        }
    }
    // 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
    // dp[5] = 1
    // dp[10] = 2
    //


    return 0;
}