#include <stdio.h>
#include <stdlib.h>

typedef struct map {
    int area, cleaned;
} map;
map area[50][50];

int N,M;

typedef struct location {
    int x, y, direction;
}location;
location now;

void clean();
int all_side_check();
void clean_explore();
int cleaned_check();

int main(void)
{
    scanf("%d %d", &N, &M);
    scanf("%d %d %d", &now.x, &now.y, &now.direction);
    for (int i =0; i<N; i++)
    {
        for (int j =0; j< M; j++)
        {
            scanf("%d", &area[i][j].area);
        }
    }
    clean();
    printf("%d\n", cleaned_check());
    return (0);
}

void clean()
{
    area[now.x][now.y].cleaned = 1;
    clean_explore();
}

// 이지역의 상하좌우가 모두 벽이거나 청소가 되었으면 1을 반환!
// 아니면 0을 반환 -> 즉 청소 구역이 있다!
int all_side_check()
{
    if ( (area[now.x - 1][now.y].area == 1 || area[now.x - 1][now.y].cleaned == 1 ) &&
    (area[now.x + 1][now.y].area == 1 || area[now.x + 1][now.y].cleaned == 1 ) && 
    (area[now.x][now.y - 1].area == 1 || area[now.x][now.y - 1].cleaned == 1 ) &&
    (area[now.x][now.y + 1].area == 1 || area[now.x][now.y + 1].cleaned == 1 )  )
    {
        return 1;
    }
    return 0;
}

// 현재 방향에서 반시계를 체크하기 때문에!!!! 그걸 체크해줘야함!!
// 0 ->3
// 1 -> 0
// 2 -> 1 
// 3 -> 2
// 그리고 all_side_check()가 1이면 상하좌우 청소거나 막힌거
// 내 전에 있던곳이 벽이 아니면 뒤로 가기!--> 내가 바라보는거의 반대! 즉 0이면 +높이! 아니면 종료! 

// 아니고 0이면 -> 반시계로 가기! -> 그리고 일단 바꿔줘야함!
void clean_explore()
{
    map left;
    switch (now.direction)
    {
        case 0:
            if (all_side_check())
            {
                // 그럼 벽인지 아닌지 확인!
                if (area[now.x + 1][now.y].area == 0)
                {
                    now.x = now.x + 1;
                    return clean_explore();
                }
                return ;
            }
            now.direction = 3;
            left = area[now.x][now.y - 1];
            if (left.area != 1 && left.cleaned == 0)
            {
                now.y = now.y - 1;
                return clean();
            }
            else
                return clean_explore();
            break;

        case 1:
            if (all_side_check())
            { // 1은 동 즉 서를 확인!
                    // 그럼 벽인지 아닌지 확인!
                if (area[now.x][now.y - 1].area == 0)
                {
                    now.y = now.y - 1;
                    return clean_explore();
                }
                return ;
            }
            now.direction = 0;
            left = area[now.x - 1][now.y];
            if (left.area != 1 && left.cleaned == 0)
            {
                now.x = now.x - 1;
                return clean();
            }
            else
                return clean_explore();
            break;

        case 2:
            if (all_side_check())
            { // 1은 동 즉 서를 확인!
                    // 그럼 벽인지 아닌지 확인!
                if (area[now.x - 1][now.y].area == 0)
                {
                    now.x = now.x - 1;
                    return clean_explore();
                }
                return ;
            }
            now.direction = 1;
            left = area[now.x][now.y + 1];
            if (left.area != 1 && left.cleaned == 0)
            {
                now.y = now.y + 1;
                return clean();
            }
            else
                return clean_explore();
            break;

        case 3:
            if (all_side_check())
            { // 1은 동 즉 서를 확인!
                    // 그럼 벽인지 아닌지 확인!
                if (area[now.x][now.y + 1].area == 0)
                {
                    now.y = now.y + 1;
                    return clean_explore();
                }
                return ;
            }
            now.direction = 2;
            left = area[now.x + 1][now.y];
            if (left.area != 1 && left.cleaned == 0)
            {
                now.x = now.x + 1;
                return clean();
            }
            else
                return clean_explore();
            break;
    }

}

int cleaned_check()
{
    int cnt = 0;
    for (int i =0; i< N; i++)
    {
        for (int j =0; j<M; j++)
        {
            if (area[i][j].cleaned == 1)
                cnt++;
        }
    }
    return cnt;
}