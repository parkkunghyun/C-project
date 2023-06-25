#include<stdio.h>

int mystrlen(const char *arr);

int main(void) {
    char arr[100] = {"hello world"};
    printf("%s\n", arr);
    printf("%d\n", mystrlen(arr));

    return 0;
}

int mystrlen(const char *arr){
    int cnt = 0;
    while(*arr != '\0') {
    	cnt++;
    	arr++;
    }
    return cnt;
}