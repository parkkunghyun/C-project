#include<stdio.h>

int main(void) {
    int n;
    int star, line, space;
    scanf("%d", &n);

    for(line=0; line<n; line++) {
        for(space = 0; space<line+1; space++) {
            putchar(' ');
        }

        for(star=0; star<2*(n-line)-1; star++) {
            putchar('*');
        }

        for(space = 0; space<line+1; space++) {
            putchar(' ');
        }
        printf("\n");
    }

    return 0;
}