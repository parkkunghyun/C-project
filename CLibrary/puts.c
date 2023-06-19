// int puts(const char *str); 표준 출력파일 스트림에 문자열을 출력
// puts함수는 입력 문자열 뒤에 개행 문자를 뒤에 추가하여 출력

#include<stdio.h>

int main(void) {
    puts("Hello world"); //개행 문자를 포함해서 나옴!

    printf("%s\n", "Hello world"); 
    // printf는 내부에서 포맷을 지정한 형태로 출력

    return 0;
}
