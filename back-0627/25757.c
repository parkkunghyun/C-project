#include<stdio.h>
#include<stdlib.h>
#include<string.h>

int main(void) {
    // 
    int dy[] = {1,0,-1,0, 1, 1 ,-1,-1 };
    int dx[] = {0,1, 0,-1,1,-1, -1, 1 };
    
    // 상하좌우 대각선까지 봐서 개수 체크!
    int row,col;
    scanf("%d %d", &row, &col);
    // 이차원배열 전체 할당!
    char **matrix = malloc(sizeof(char*) * row);

    for(int i=0; i<row; i++) {
        matrix[i] = malloc(sizeof(char)* (col+1));
        
        for(int j=0; j<col; j++) {

        }
    }

    return 0;
}