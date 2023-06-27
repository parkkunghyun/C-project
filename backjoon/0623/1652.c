#include <stdio.h>
 
void find_sleeping_space()
{
    int N;
    scanf("%d", &N);
    int i, j;
    int T_col_cnt = 0;
    int T_row_cnt = 0;
    int col_cnt = 0;
    int row_cnt = 0;
    char A[101][101];

    // 내가 scanf로 문자를 받게 되면 버퍼에서 a하고 엔터 치면 둘다 아스키코드로 인식!
    // 그래서 버퍼에서 빼주기 위해서 getchar()를 사용해서 엔터를 빼주자! -> 버퍼에 한문자 가져오기!
    getchar();

    for (i = 0;i < N;i++)
    {
        for (j = 0;j < N;j++)
        {
            scanf("%c", &A[i][j]);
        }
        getchar();
    }
    for (i = 0;i < N;i++)
    {
        for (j = 0;j < N;j++)
        {
            if (A[i][j] == '.')
                col_cnt++;
            else if (A[i][j] == 'X')
            {
                if (col_cnt>=2)
                    T_col_cnt++;
                col_cnt = 0;
            }
            if (A[j][i] == '.')
                row_cnt++;
            else if (A[j][i] == 'X')
            {
                if (row_cnt >= 2)
                    T_row_cnt++;
                row_cnt = 0;
            }
        }
        if (col_cnt >=2)
            T_col_cnt++;
        if (row_cnt >= 2)
            T_row_cnt++;
        col_cnt = row_cnt = 0;
    }
    printf("%d %d", T_col_cnt, T_row_cnt);
}

int main()
{
    find_sleeping_space();

    return 0;
}