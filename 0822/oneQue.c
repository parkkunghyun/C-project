// 원형큐 -> 동적 생성 해서 데이터 보관
// put,get 연산을 위주로!

#include <stdio.h>
#include <stdlib.h>

#define NEXT (index, QSIZE) ((index + 1) % QSIZE)
// 원형 큐에서 인덱스를 변경하는 메크로 함수

typedef struct Que {
    int *buf; // 저장소
    int qsize;
    int front;
    
} Que;