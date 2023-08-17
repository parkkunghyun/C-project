// N명의 학생의 번호, 키, 몸무게
// 키, 몸무게 평균값 -> 소수이하 첫째자리
// super, average, below

#include<stdio.h>
#include<stdlib.h>

typedef struct student {
    int studentNumber;
    double height;
    double weight;
}Student;

int main() {
    int n;
    scanf("%d", &n);
    Student students[n];

    double heightSum = 0;
    double weightSum = 0;
    for(int i =0; i<n; i++) {
        scanf("%d %lf %lf",&students[i].studentNumber, &students[i].height, &students[i].weight);
        heightSum += students[i].height;
        weightSum += students[i].weight;
    }
    // hieght평균 구하기
    double heightAvg = heightSum / (double)n;
    double weightAvg = weightSum / (double)n;

    printf("%.1lf  %.1lf\n", heightAvg, weightAvg);
    for(int i =0; i<n; i++) {
        if(students[i].height >= heightAvg && students[i].weight >= weightAvg) {
            printf("%d super\n",students[i].studentNumber);
        }
        else if( (students[i].height >= heightAvg && students[i].weight < weightAvg) ||  (students[i].height < heightAvg && students[i].weight >= weightAvg)  ) {
            printf("%d average\n",students[i].studentNumber);
        }
        if(students[i].height < heightAvg && students[i].weight < weightAvg) {
            printf("%d below\n",students[i].studentNumber);
        }
    }


    return 0;
}