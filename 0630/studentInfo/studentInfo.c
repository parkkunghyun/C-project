//학생성적 정렬
// 구조체, 입력한 학생 수 만큼 동적 메모리 할당
// n 명의 학생 정보를 입력받아 성적 순으로 내림차순!

#include<stdio.h>
#include<stdlib.h>

#define MAX_NAME_LEN 20 // 학생 이름 최대 길이
#define SUM(stu) (stu.middle + stu.final) // 구조체를 받아서 계산!

typedef struct student {
    char name[MAX_NAME_LEN];
    int snum; // 학생 번호
    int middle; // 중간고사 성적
    int final; // 기말고사 성적

}Student;

void Sort(Student* base, int n); // 
void View(Student* base, int n); 

int main() {
    int n =0;
    Student *base = 0; // NULL로 초기화함!
    int i =0;

    printf("학생 수: ");
    scanf("%d",&n);
    base = (Student*)malloc(sizeof(Student)*n);
    printf("학생 정보 입력: 번호 이름 중간고사(0-100) 기말고사(0-100)\n");
    for(i=0; i<n; i++) {
        printf("%d 번째 학생정보 ", i+1);
        scanf("%d %s %d %d",&base[i].snum, base[i].name, &base[i].middle, &base[i].final);
    }
    Sort(base, n);
    View(base , n);

    free(base);
    return 0;
}
void Sort(Student* base, int n) {
    Student temp; // 임시 변경을 위해 사용!

    for(int i =n; i>1; i--) { //i는 고정! 그 외 나머지만 서로 비교!
        for(int j=1; j<i; j++) {
            if(SUM(base[j]) > SUM(base[j-1])  ) {
                temp = base[j-1];
                base[j-1] = base[j];
                base[j] = temp;
            }
        }
    }
}

void View(Student* base, int n)
{
    int i= 0;
    printf("%4s| %8s| %4s| %4s| %4s| %s\n", "번호", "이름", "중간", "기말", "합계", "평균");
    for (i = 0; i < n; i++)
    {
        printf("%4d| %8s| %4d| %4d| %4d| %.1f\n",
            base[i].snum, base[i].name, base[i].middle, base[i].final, SUM(base[i]), SUM(base[i]) / 2.0);
    }
}