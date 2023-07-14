#include<stdio.h>
#include<stdlib.h>

typedef struct Stack {
    int *buf;
    int ssize;
    int top;
}Stack;

Stack *NewStack();
void InitStack(Stack *stack, int ssize);
void DeleteStack(Stack *stack);
int IsFull(Stack *stack); 
int IsEmpty(Stack *stack); 
void Push(Stack *stack, int data); 
int Pop(Stack *stack); 
void DisposeStack(Stack *stack);//스택 해제화

int main(void)
{
    int i;
    Stack *stack = NewStack(); //스택 생성

    for (i = 1; i <= 5; i++)//1~5까지 스택에 보관
    {
        Push(stack, i);
    }
    while (!IsEmpty(stack))//스택이 비어있지 않다면 반복
    {
        printf("%d ", Pop(stack));//스택에서 꺼내온 값 출력
    }
    printf("\n");
    DeleteStack(stack);//스택 소멸
    return 0;
}

Stack *NewStack() {
   Stack *stack = (Stack*)malloc(sizeof(Stack));
   InitStack(stack, 1);
   return stack;
}
void InitStack(Stack *stack, int ssize) {
    stack->buf = (int*)malloc(sizeof(stack) * ssize);
    stack->ssize = ssize;
    stack->top = -1;
}
void DeleteStack(Stack *stack) {
    DisposeStack(stack);
    free(stack);
}
void DisposeStack(Stack *stack) {
    free(stack->buf);
}
int IsFull(Stack *stack) {
    return stack->top +1 == stack->ssize ? 1: 0;

}
int IsEmpty(Stack *stack) {
    return stack->top == -1 ? 1: 0;

}
void Push(Stack *stack, int data) {
    if(IsFull(stack)) {
        printf("꽉 참\n");
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