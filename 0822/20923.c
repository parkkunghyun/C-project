// N장의 카드로 이루어진 덱
// 그라운드에 내려놓을때는 자기 카드 보이게
// 카드 숫자 위에있는거 합이 5면 종 침 두 그라운드가 비면 안된다 -> 수연
// 가장 위가 5면 침 -> 도도
// 종 치면 상대꺼 내 덱 아래에 놔두고 내 덱도 아래로 가져와 합치기!

// 2-4번 진행 하는것 -> 1번 진행 
// 내 덱이 0이면 상대방 승리, M번 진행 비기거나 이김

// 스택으로 두어야하나? - deque로 해서 둬야할듯!
// 시작은 도도
// 알고리즘 고민해보자!

/*
5 2 -> 왜 su일까? -> 5만 처음에 있으면 이때는 su가 치는건가
그러네 그라운드 비면 안되서

1 2 1 2 3 2 2 2 5 2 - d
2 2 2 3 1 2 5 1 1 3 - s

2 3 1 2 1 2 3 2 2 2 5 -d
2 2 2 3 1 2 5 1 1  - s

5 1 2 3 1 2 1 2 3 2 2 2 
2 2 2 3 1 2 5 1 

2 1 / 2 5

*/

#include <stdio.h>
#include <stdlib.h>

int main(void)
{


    return (0);
}