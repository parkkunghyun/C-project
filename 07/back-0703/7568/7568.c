// 몸무게와 키가 전부 커야 덩치가 큰거
// 

#include<stdio.h>

int main() {
    int n;
    scanf("%d",&n);
    int persons[n][n];

    for(int i=0; i<n; i++) {
        scanf("%d %d", &persons[i][0], &persons[i][1]);
    }

    int rates[n];

    for(int i=0; i<n; i++) {
        int rate = 1;
        for(int j=0; j<n; j++) {
            if( persons[i][0] < persons[j][0]  && persons[i][1] < persons[j][1]  ) {
                rate++;
            }
        }

        rates[i] = rate;
    }
    
    for(int i=0; i<n; i++) {
        if(i==n-1) {
            printf("%d", rates[i]);
        }else {
            printf("%d ",rates[i]);
        }
        
    }

    return 0;
}