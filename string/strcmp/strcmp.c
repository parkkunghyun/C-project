#include<stdio.h>

int mystrcmp(const char *str1, const char *str2);
// 사전식 비교 -> 앞에 나오는 단어가 작고 뒤에 나오는 단어가 크다 판별!

int main(void) {
    char names[5][20] =
    {
        "홍길동","강감찬","이순신","을지문덕","한석봉"
    };
    char name[20];
    

    printf("검색할 이름: ");
    scanf("%s", name);

    int value =0;
    for(int i=0; i<5; i++) {
        value = mystrcmp(name, names[i]);

        if(value == 0) {
            printf("인덱스 %d에서 %s를 찾았습니다.\n", i, name);
        } else if (value >0)
        {
            printf("%s > %s\n", name, names[i]);
            
        } else if (value <0)
        {
             printf("%s < %s\n", name, names[i]);
        }
        
    }
    return 0;
}

int mystrcmp(const char *str1, const char *str2) {
    unsigned char c1,c2;
    // 일단 길이 다르면 다른거긴함!
    int idx = 0;
    while(1) {
        //c1 = *str1++;
        c1 = str1[idx];
        c2 = *str2++;
        if(c1 != c2) {
            return c1 < c2 ? -1 : 1;
        }
        idx++;
        if(!c1) {
            break;
        }
    }

    return 0;
}
