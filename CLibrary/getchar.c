// 버퍼에 데이터가 있을때 -> 버퍼 가장 앞의 데이터를 반환!
// 버퍼에 데이터가 없으면 -> 엔터가 올때까지 사용자로부터 문자를 받아 버퍼에 저장하고
// 가장 앞의 문자를 반환
// int getchar(void)

#include<stdio.h>
int main(void) {
    char s1, s2, s3;
    s1=getchar();
    while (getchar() != '\n') {}
    s2=getchar();
    while (getchar() != '\n') {}
    s3 = getchar();
    while (getchar() != '\n') {}
    printf("출력:%c %c %c", s1,s2,s3);
    
    return 0;
}