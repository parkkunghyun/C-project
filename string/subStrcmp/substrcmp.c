// int strncmp(const char *s1, const char *s2, size_t n)
// 확장된 아스키값이 들어올걸 고려해서 unsigned int로 처리!

#include<stdio.h>

int mystrlen(char *str);
int mystrncmp(const char *str1, const char *key, size_t n);

int main(void) {
    char src[100] = "This is test1. He is a student. she is a teacher.";
    char key[10] = "is";
    int len;
    int i;

    len = mystrlen(key);
    //printf("%d\n", len);
    printf("원본 문자열:%s\n\n", src);
    printf("is로 시작하는 부분 문자열 목록\n\n");

// is로  시작하면 나오게! -> 그 다음 is도!
    for(i =0; src[i]; i++) {
        if(mystrncmp(src+i, key, len) ==0) {
            printf("%s\n", src+i);
        }
    }

    return 0;
}

int mystrncmp(const char *str1, const char *str2, size_t n)
{
    unsigned int	i;
	i = 0;
	while ((*(str1 + i) || *(str2 + i)) && i < n)
	{
		if (*(str1 + i) != *(str2 + i))
		{
			return  *(str1 + i) - *(str2 + i);
		}
		++i;
	}
	return (0);
}

int mystrlen(char *str) {
    int cnt=0;
    int idx=0;

    while(*str++ != '\0') {
        cnt++;
    }
    return cnt;
}