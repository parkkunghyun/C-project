

#include<stdio.h>

int main() {
    int n, k;
    scanf("%d %d", &n, &k);
    int coins[n];
    for(int i =0; i<n; i++) {
        scanf("%d", &coins[i]);
    }

    int count = 0;
    int index = n-1;

    while(1) {
        if(k == 0) {
            break;
        }

        if(k < coins[index]) {
            index--;
        } 
        else { // 4200 1000
            while(1) {
                if(k < coins[index]) {
                    index--;
                    break;
                }
                else {
                    k -= coins[index];
                    count++;
                }
            }
        }
    }

    printf("%d\n", count);
    return 0;
}