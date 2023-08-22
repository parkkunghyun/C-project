#include <stdio.h>
#include <stdlib.h>

// 12시 부터 - 12시 5분

// 정수를 순회
// 나누기 나머지를 사용?
// 일단 배열에 넣기? -> 만약 큰 숫자가 들어온다면?
int n;
int main(void)
{
    scanf("%d", &n);
    int *ptr;
    ptr = (int *)malloc(sizeof(int) * n);
    for(int i =0; i<n; i++)
        ptr[i] = i + 1;

    for (int i =0; i<n; i++)
    {
        for (int j = i; j < i + n; j++)
        {
            printf("%d ", ptr[j % n]);
        }
        printf("\n");
    }
    return (0);
}