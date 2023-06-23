// char * strcpy(char *dst, const char* src);

#include<stdio.h>

char * mystrcpy(char *dst, const char* src);

int main(void) {
    char source[100] = "Hellwefwefwfewfewfwo World";
    char dest[100];

    printf("원본 문자열:%s\n", source);
    mystrcpy(dest, source);
    printf("복사 결과 문자열: %s\n", dest);

    return 0;
}

char * mystrcpy(char *dst, const char* src) {
    // dst에 src를 전부 복사하고 리턴하면 될듯! 

    int idx= 0;
    while(*(src+idx)) {
        dst[idx] = src[idx];
        idx++;
    }
    *(dst+idx) = '\0';
    return dst;
}