#include<stdio.h>
#include<stdlib.h>

typedef struct Stack {
    int *buf;
    int ssize;
    int top;
}Stack;

void InitStack(Stack *stack , int size);
int IsFull(Stack *stack);
int IsEmpty(Stack *stack);
void Push(Stack *stack, int data);
int Pop(Stack *stack);
void DisposeStack(Stack *stack);

int main(void)
{
    int i;
    Stack stack;

    InitStack(&stack, 10);//스택 초기화
    for (i = 1; i <= 5; i++)//1~5까지 스택에 보관
    {
        Push(&stack, i);
    }
    while (!IsEmpty(&stack))//스택이 비어있지 않다면 반복
    {
        printf("%d ", Pop(&stack));//스택에서 꺼내온 값 출력
    }
    printf("\n");
    DisposeStack(&stack);//스택 해제화
    return 0;
}

void InitStack(Stack *stack, int size) {
    stack->buf = (int*)malloc(sizeof(int) * size);
    stack->ssize = size;
    stack->top = -1;
}
int IsFull(Stack *stack) {
    return stack->ssize == stack->top +1 ? 1: 0;
}
int IsEmpty(Stack *stack) {
    return stack->top == -1 ? 1 : 0;
}
void Push(Stack *stack, int data) {
    if(IsFull(stack)) {
        printf("동적할당한 만큼 다 찾음\n");
        return;
    }
    stack->top++;
    stack->buf[stack->top] = data;

}
int Pop(Stack *stack) {
    if(IsEmpty(stack)) {
        printf("top이 -1임 \n");
        return 0;
    }
    int re = stack->buf[stack->top];
    stack->top--;
    return re;

}
void DisposeStack(Stack *stack) {
    free(stack->buf);
}
