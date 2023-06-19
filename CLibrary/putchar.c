// int putchar(int ch);
// 표준 출력 파일 스트림에 문자를 출력하는 함수!
// ch 출력할 문자의 아스키 코드 값
// 성공시 문자 출력, 아니면 EOF(-1)

/**
 * #include<unistd.h>
 * void putchar(char c) {
 *  write(1,&c,1);
 * }
 *  
 * ssize_t write(int fd, const void *buf, size_t count);
 *  wirte(대상파일 , 쓸내용, 입력할 문자수);
 * 여기서 1은 출력, 0은 입력, 2는 에러
*/

#include<stdio.h>

int main(void) {
    int c;
    int result;

    printf(":%8s :%8s :%8s\n","10진수", "16진수", "8진수");

    // 숫자 문자
    for(c='0'; c<='9'; c++) {
        result = putchar(c);
        printf(":%8d :%#8X :%#8o\n", result, result, result);
    }

    for(c='a'; c<='z'; c++) {
        result = putchar(c);
        printf(":%8d :%#8X :%#8o\n", result, result, result);
    }

}