// 3시 20분 - 3시50분 -> 10분 답보기!
// 왼쪽에서 정수 만큼 떨어진 거리만 물이 샘!
// L인 테이프 무한개
// 물을 막을때 좌우 0.5 간격 줘야함!
// 테이프 최소 개수! -> 겹쳐 붙이기 가능!
// 1 2 100 101

// 테이프를 어디에 붙일건지 고민해야함!
// 테이프길이 <= 시작지점부터 다른 누수지점까지 거리 ->필요한 테이프 개수 +1

#include<stdio.h>
#include<stdlib.h>

int arr[1001];
int n,L;

void qSort() {
    int temp;
    for(int i= n-1; i>0; i--) {
        for(int j =0; j<i; j++) {
            if(arr[j] > arr[i]) {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] =temp;
            }
        }
    }
}

int main() {
    
    scanf("%d %d", &n, &L);
    for(int i=0; i<n; i++){
        scanf("%d", &arr[i]);
    }

    qSort(); // 작은숫자가 앞에 오게 정렬! ->버블쓰자!
// 이게 n이 엄청커서 여러개 구멍이 들어갈수도 있다! -> 그 경우 놓침!
    int cnt =0;
    int start=arr[0]; // 맨처음에 테이프 붙여보기!
    
    for(int i = 1; i<n; i++) {
        if(L <= arr[i] - start) {
            // 테이프의 길이가 모자라게 된다면! +1을 해줘야함!
            cnt++;
            start = arr[i]; // 이제 시작 지점을 그 다음부분으로 바꿈!
        }
    }

    // for문에서 마지막에 붙인 테이프가 안세져서! +1 따로!
    printf("%d\n", cnt+1);

    return 0;
}