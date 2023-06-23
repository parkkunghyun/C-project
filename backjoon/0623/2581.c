// M과 N이하 자연수 중 소수 골라 소수합과 최솟값 찾기

#include<stdio.h>

int sosu(int x);

int main() {
    int n,m;
    scanf("%d",&m);
    scanf("%d", &n);

    int sum =0;
    int minSosu = 99999;

    for(int i=m; i<=n; i++) {

        if(sosu(i) && i !=1) {
            sum+=i;
            if(i < minSosu) {
                minSosu = i;
            }
        }
    }

    if(sum==0) {
        printf("-1");
    } else{
         printf("%d\n", sum);
        printf("%d\n", minSosu);
    }

    return 0;
}
int sosu(int x) {
    int maxs = x/2 +1;

    for(int j=2; j < maxs; j++ ) {
        if(x %j ==0) {
            return 0;
        }
    }
    return 1;
}