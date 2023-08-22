// 스택을 완전 이해하고 넘어가자!
// 스택은 쌓이고 마지막을 내보내줌!

// 12시 20 - 30분까지 스스로 고민
// 30 - 40분까지 보고 만들기
// 40-50 분까지 터미널에서 받아서 만들기 + 다 차면 *2로 사이즈 할당하기!

#include <stdio.h>
#include <stdlib.h>
// 스택에는 맨 위를 알려주는 top, 자체 노드? ,근데 int만 하니까 int*로!!
// 그리고 사이즈 알려주는애 설정하기! 
typedef struct Stack {
    int top;
    int *buf;
    int ssize;
} Stack;

void InitStack(Stack *stack, int ssize);
int IsFull(Stack *stack);
int IsEmpty(Stack *stack);
void Push(Stack *stack, int data);
int Pop(Stack *stack);
void DisposeStack(Stack *stack);

int main(int argc, char **av)
{
    int i,data;
    char *say;

    Stack stack;
    printf("스택의 사이즈를 정해주세요 :");
    scanf("%d", &i);
    printf("데이터 추가는 1, 데이터 pop은 2 ,종료는 0입니다\n");

    InitStack(&stack, i);

    while (1)
    {
        printf("하나를 넣어주세요 : ");
        scanf("%d", &i);
        if (i == 1)
        {
            printf("추가할 데이터를 적어주세요 : ");
            scanf("%d", &data);
            Push(&stack, data);
        }
        else if (i == 2)
        {

            printf("맨 위에 있던 숫자는 %d 였습니다\n", Pop(&stack));
        }
        else if (i == 0)
        {
            printf("종로되었습니다\n");
            break;
        }
        else
        {
            printf("잘못된 숫자를 넣었습니다 다시 넣어주세요\n");
        }
       
    }
    printf("\n");
    DisposeStack(&stack);
    return (0);
}

void DisposeStack(Stack *stack)
{
    free(stack->buf);
}

void InitStack(Stack *stack, int ssize)
{
    stack->buf = (int *)malloc(sizeof(int) * ssize);
    stack->ssize = ssize;
    stack->top = -1;
}
int IsFull(Stack *stack)
{
    if (stack->top+1 == stack->ssize)
    {
        printf("stack 사이즈를 두배 늘렸습니다\n");
        stack->ssize *= 2;
        stack->buf = (int *)realloc(stack->buf, sizeof(int) * (stack->ssize)); 
        return (1);
    }
    return (0);
}
int IsEmpty(Stack *stack)
{
    if (stack->top == -1)
        return (1);
    return (0);
}
void Push(Stack *stack, int data)
{
    if (!IsFull(stack))
    {
        stack->top++;
        stack->buf[stack->top] = data; 
    }
    else
    {
        stack->top++;
        stack->buf[stack->top] = data; 
    }
}
int Pop(Stack *stack)
{
    if (!IsEmpty(stack))
    {
        int s = stack->buf[stack->top];
        stack->top--;
        return (s);
    }
    else
    {
        printf("현재 스택이 비어있습니다1!\n");
    }
    return 0;
}