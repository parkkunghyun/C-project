// char *gets(char *buffer) 버퍼에서 문자열 읽음
// 들어온 문자열에 대해 \0을 붙여줌
// 개행 앞까지 짤라서 char* 타입 문자열로 저장하고 자동으로 저장
// get_s가 버퍼 오버 플로우를 막을수 있어서 권장

#include<stdio.h>

int main(void) {
    char buf[256];
    int i;
    int nc = 0, lc=0, bc=0, ec=0;
    printf("입력: ");
    gets(buf);
    for (i = 0; buf[i]; i++)//buf[i]가 참인 문자면 반복
    {
        if ((buf[i] >= '0') && (buf[i] <= '9'))//숫자일 때
        {
            nc++;
        }
        else if ((buf[i] >= 'a') && (buf[i] <= 'z'))//소문자일 때
        {
            lc++;
        }
        else if ((buf[i] >= 'A') && (buf[i] <= 'Z'))//대문자일 때
        {
            bc++;
        }
        else//다른 문자일 때
        {
            ec++;
        }
    }
    printf("숫자: %d개 소문자: %d개 대문자: %d개 기타: %d개\n", nc, lc, bc, ec);

    return 0;
}