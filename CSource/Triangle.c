#include<stdio.h>

int main(void) {
    int n;
    int line, space, star;
    scanf("%d",&n);
    for(line=0; line<n; line++) {
        for(int space = 0; space<n-line; space++) {
            putchar(' ');
        }
        // 00000*00000
        for(star=0; star<2*line+1; star++) {
            printf("*");
        }

        for(int space = 0; space<n-line; space++) {
            putchar(' ');
        }

        printf("\n");
    }

    return 0;
}