// char * strncpy(char * dst, const char *src, size_t len);

#include<stdio.h>

char *mystrncpy(char * dst, const char *src, size_t len);

int main(void) {
    char source[100] = "Hello World";
    char dest[100] = "abcde Yahoo";

    printf("원본 문자열:%s 의 5개 문자 복사\n", source);
    printf("복사 전 현재 결과 문자열:%s\n", dest);
    mystrncpy(dest, source, 5);
    printf("복사 후 결과 문자열: %s\n", dest);

    return 0;
}
char *mystrncpy(char * dst, const char *src, size_t len) {
    // len만큼만 주기?
    unsigned int idx = 0;
    while(*(src+idx) && idx <len) {
        *(dst+idx) = *(src+idx);
        idx++;
    }

// 만약 src문자열 길이가 size와같거나 더 클령우 
// '\0'을 붙여줄 공간이 없어서 붙이지 않는다
// 하지만 src크기보다 size가 더 클령우 남은 부분은 '\0'으로!

// 버퍼수용성안에서 원본 보존력은 높지만 오류 가능정존재!
    while(idx<len) {
        *(dst + idx) = '\0';
        idx++;
    }
    
    return dst;
}
