/**
 * 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람 앞에 오게 정렬!
 * 1, 100000
 * 그러면 일단 각 인덱스를 저장할 공간도 있어야할듯!
 * 구조체로 만들어야하나?
 * 
 * 여기서 핵심은 나이를 비교하고 같으면 가입 순서대로 출력하라이다!
 * 나이가 1 - 200까지이니까 그걸 지정해주고 움직이기!
*/

#include<stdio.h>
#include<stdlib.h>
#include<string.h>

typedef struct p {
    int age;
    char name[201];
}w;

w member[100001];

int main() {
    int n;
    scanf("%d", &n);
    
    for(int i=0; i<n; i++) {
        scanf("%d %s", &member[i].age, member[i].name);
    }

    for(int a=1; a<=200; a++) {
        for(int b=0; b< n; b++) {
            if(a == member[b].age) {
                printf("%d %s\n", member[b].age, member[b].name);
            }
        }
    }

    

    return 0;
}
