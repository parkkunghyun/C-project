#include<stdio.h>

int main(void) {
    int n, line,space,number;
    scanf("%d",&n);
    for(line=1; line<=n; line++) {
        for(space=0; space<n-line; space++) {
            putchar(' ');
        }

        for(number=1; number<line; number++) {
            printf("%d", number);
        }
        printf("%d",line);

        for(number=line-1; number>0; number--) {
            printf("%d", number);
        }

        for(space=0; space<n-line; space++) {
            putchar(' ');
        }

        printf("\n");
    }

    return 0;
}