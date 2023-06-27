#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int mystrlen(const char* arr);
int mystrcmp(const char* s, const char* t);

int gcd(int s, int t);
int lcm(int s, int t, int g);

int main(void) {
    char s[51];
    char t[51];
    scanf("%s", s);
    scanf("%s", t);
    int slen = mystrlen(s);
    int tlen = mystrlen(t);
    //printf("slen is %d <=====> tlen is %d \n", slen, tlen);
    int gcdNumber= gcd(slen, tlen);
    int lcmNumber = lcm(slen,tlen, gcdNumber);

    char* s1 = (char*)malloc(sizeof(char)* lcmNumber);
    char* t1 = (char*)malloc(sizeof(char)* lcmNumber);

    for(int i =0; i<lcmNumber ; i++) {
        s1[i] = s[i% slen];
        t1[i] = t[i% tlen];
    }
    if(mystrcmp(s1, t1) == 0) {
        printf("1\n");
    } else {
        printf("0\n");
    }

    return 0;
}

int gcd(int s, int t) {
    int tmp,n;
    if(s<t) {
        tmp = s;
        s = t;
        t = tmp;
    }

    while(t != 0) {
        n = s%t;
        s = t;
        t = n;
    }
    // 8 6
    // 8%6 = 2
    // 6
    // 2

    // 6 2
    // 6%2 = 0
    // 2
    // 0 
    
    return s;
}
int lcm(int s, int t, int g) {
    return (s*t) / g;
}

int mystrcmp(const char* s, const char* t) {
    int index = 0;
    while(s[index] != '\0') {
        if(s[index] != t[index]) {
            return -1;
        }
        index++;
    }
    return 0;
}

int mystrlen(const char* arr) {
    int cnt = 0;
    while(*arr !='\0') {
        cnt++;
        arr++;
    }
    return cnt;
}