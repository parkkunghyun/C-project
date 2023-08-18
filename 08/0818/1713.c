#include <stdio.h>
#include <stdlib.h>

int N;
int votes;
int arr[101];
int *box;

int main(void)
{
    int vote;
    int index;
    int minCheck;
    int min;
    int check = 0;

    index = 0;
    min = 9999;
    minCheck = 9999;
    scanf("%d", &N);
    scanf("%d", &votes);
    box = (int *)malloc(sizeof(int) * N);

    for (int i =0; i< votes; i++)
    {
        scanf("%d", &vote);
        if (index < N)
        {
            box[index] = vote;
            index++;
            arr[vote]++;
        }
        else
        {
            for (int i =0; i< N; i++)
            {
                if (vote == box[i])
                {
                    check = 1;
                    break;
                }
            }
            if (check == 1)
            {
                arr[vote]++;
                check = 0;
            }
            else
            {
                for (int i =0; i< N; i++)
                {
                    if (arr[box[i]] < minCheck)
                    {
                        min = box[i]; // 2 값
                        minCheck = arr[box[i]]; // 1 횟수
                        index = i; // 0 인덱스
                    }
                }
                arr[min] = 0;
                for (int i =index; i< N - 1; i++)
                {
                    box[i] = box[i + 1];
                }
                index = N - 1;
                box[index] = vote;
                index++;
                arr[vote]++;
                min = 9999;
                minCheck = 9999;
            }
        }
    }
    int result[101];
    int max = -1;
    int maxCheck = -1;
    index = 0;

    for (int j = 0; j < N; j++)
    {
        for (int i =0; i< N; i++)
        {
            if (arr[box[i]] > maxCheck )
            {
                max = box[i];
                maxCheck = arr[box[i]];
            }
        }

        result[index] = max;
        index++;
        arr[max] = -1;
        max = -1;
        maxCheck = -1;
    }
    for (int i =0; i< N; i++)
    {
        printf("%d ", result[i]);
    }
    
    return (0);
}