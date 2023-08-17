#include <stdio.h>
#include <stdlib.h>
// 문제를 N개 가지고 있고 난이도는 정수 배열
// 두문제이상, 합은L과 R사이 둘 포함, 차는 X만큼 차이
// 브루트포스? 다 확인해야하나?
// 백트래킹 -> x가 안맞으면 나가리! L R사이 아니면 나가리!
// 숫자가 같아도 배열 인덱스가 다르면 다르게 보네!
// 일단 모든 조합을 구하고 그거를 계산해서 맞으면 count+1 아니면 pass

int N,L,R,X;
int arr[16];
int count = 0;
int visited[16];


void clear()
{
    for (int i =0; i< N; i++)
    {
        visited[i] = 0;
    }
}

void combination(int len, int depth, int start, int sum, int min, int max)
{
    // 여기서 만들어지는 즉시 체크하는 함수로 보내버리자!
    if (depth == len)
    {
        
        if (L <= sum && sum <= R && (max - min >= X) )
        {
            //printf("%d %d %d \n", sum , max, min);
            count += 1;
        }
        return ;
    }

    for (int i = start; i<N; i++)
    {
        if (visited[i] == 0)
        {
            visited[i] = 1;
            if (min > arr[i])
                combination(len, depth + 1, i, sum + arr[i],arr[i], max );
            if (max < arr[i])
                 combination(len, depth + 1, i, sum + arr[i], min, arr[i] );
            visited[i] = 0;
        }
    }
}

int main(void)
{
    scanf("%d %d %d %d", &N,&L, &R, &X);
    for(int i =0; i< N; i++)
    {
        scanf("%d", &arr[i]);
    }

    for(int i = 2; i<=N; i++)
    {
        clear();
        combination(i, 0, 0, 0, 99999, -10000); // 일단 조합을 만들고 그 조합들을 계산하기
    }
    
    printf("%d\n", count);
    return (0);
}