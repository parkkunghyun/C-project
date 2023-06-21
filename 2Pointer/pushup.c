#include<stdio.h>
#include<stdlib.h>

int main(void) {
    unsigned char limit_table[3];
    unsigned char *p[3]; // 연령별 푸쉬업 횟수 저장 배열
    int age,member,sum,temp;

    for(age =0; age<3; age++) {
        printf("\n%d0대 연령의 윗몸 일으키기 횟수\n", age+2);
        printf("이 연령대는 몇명입니까?");

        scanf("%d", &temp);
        limit_table[age] = (unsigned char)temp;
        p[age] = (unsigned char*) malloc(limit_table[age]);

        for(member=0; member<limit_table[age]; member++) {
            printf("%dth : ", member+1);
            scanf("%d", &temp);
            *(p[age]+ member) = (unsigned char)temp;
        }


    }

    return 0;
}