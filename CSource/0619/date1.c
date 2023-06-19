// 년도와 일수 입력받아서 날짜 계산하기
// 2016년도의 102번째 날은 4월 11일입니다
// 1 3 5 7 8 10 12 - 31
// 2 - 29일
// 4 6 9 11 - 31

#include<stdio.h>

int main(void) {
    printf("년도와 남은 일수 입력(예: 2016 102): ");
    int year, day;
    scanf("%d %d", &year, &day);

    int mdays[12] = {31,28,31,30,31,30,31,31,30,31,30,31};
    int month;
    int mday = day;

    if((year%4 ==0) && (year % 100 !=0)) {
        mdays[1] = 29;
    }

    for(month=0; mday> mdays[month]; month++) {
        mday -= mdays[month];
    }
    printf("%d년도의 %d번째 날은 %d월 %d일입니다.\n", year, day, month + 1, mday);

    return 0;
}