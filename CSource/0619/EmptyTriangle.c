#include<stdio.h>
// 마지막 칸은 다채우기
// 그 다음부터는 꼬투리만 남기기!
// 0 1 3 5 까지

int main(void) {
    printf("높이: ");
    int n;
    scanf("%d", &n);
    int line, space, star;
    for(line=1; line<=n; line++) {
        for(space=line; space<n; space++) {
            printf(" ");
        }
        if(line==n) {
            for(star=1; star<=2*line-1; star++) {
                    printf("*");
            }
        }else {
            for(star=1; star<=2*line-1; star++) {
            
                if(star==1 || star== 2*line-1) {
                    printf("*");
                }
                else {
                    printf(" ");
                }    
            }
        }
        printf("\n");
    }


    return 0;
}