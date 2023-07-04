#include<stdio.h>
#define MIN(a,b) a < b ? a : b
int dp[1000001];

int main() {
    int n;
    scanf("%d",&n);
    
    for(int i =2; i<=n; i++) {
        dp[i] = dp[i-1] + 1; // dp[2] = dp[1] + 1;
        if(i %2 ==0) {
            dp[i] = ( MIN(dp[i],dp[i/2] +1 ));
        }
        
        if(i %3 ==0) {
            dp[i] = ( MIN(dp[i], dp[i/3]+1));
        }
    }
    printf("%d\n", dp[n]);

    return 0;
}