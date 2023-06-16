#include<stdio.h>

int main(void) {
    int n, space, line, star;
    scanf("%d", &n);
    // 삼각형 + 역삼각형!
    for(line =0; line<n; line++) {
        for(space=0; space<n-line; space++){
            putchar(' ');
        }

        for(star=0; star<2*line+1; star++) {
            putchar('*');
        }

         for(space=0; space<n-line; space++){
            putchar(' ');
        }

        printf("\n");
    }

    for(line =0; line<n; line++) {
        for(space=0; space<line+1; space++){
            putchar(' ');
        }

        for(star=0; star<2*(n-line)-1; star++) {
            putchar('*');
        }

         for(space=0; space<line+1; space++){
            putchar(' ');
        }

        printf("\n");
    }

    return 0;
}