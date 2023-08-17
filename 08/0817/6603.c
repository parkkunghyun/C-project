#include<stdio.h>

// 6개 수 고르기
// 1-49, 
// 모든 조합을 구하라?
// 즉 8개중 6개 -> 8c6 -> 8c2 -> 8 *7 / 2 = 28
// 사전순 출력이면 dfs같은거 사용해야할라나?
// 오름차순으로 주어지니까 visited사용해서 방문했는지 확인하고 6개 되면 끝내기!

int k;
int s[14];
int v[14];
int arr[14];

void check(int depth, int start)
{
    if (depth == 6)
    {
        for(int i =0; i<6; i++)
        {
            printf("%d ",arr[i]);
        }
        printf("\n");
        return ;
    }

    for (int i = start; i<k; i++)
    {
        if (v[i] == 0)
        {
            v[i] = 1;
            arr[depth] = s[i];
            check(depth + 1, i);
            v[i] = 0;
        }
    }
}

int main(void)
{
    while(1)
    {
        scanf("%d", &k);
        if (k == 0)
        {
            break;
        }
        for (int i = 0; i < k; i++)
        {
            scanf("%d", &s[i]);
        }
        check(0, 0);
        printf("\n");
    }
    return (0);
}