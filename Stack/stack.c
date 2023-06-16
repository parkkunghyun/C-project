#include<stdio.h>
#include<stdlib.h>

typedef struct Node
{
    int data;
    struct Node *next; // 이렇게 되면 접근할때 -> 로접근해야함!
    /* data */
}Node;

typedef struct Stack
{
    Node *top; // 
    /* data */
}Stack;

void InitStack(Stack *stack);//스택 초기화
int IsEmpty(Stack *stack); //스택이 비었는지 확인
void Push(Stack *stack, int data); //스택에 보관
int Pop(Stack *stack); //스택에서 꺼냄

int main(void)
{
    int i;
    Stack stack;

    InitStack(&stack);//스택 초기화
    for (i = 1; i <= 5; i++)//1~5까지 스택에 보관
    {
        Push(&stack, i);
    }
    while (!IsEmpty(&stack))//스택이 비어있지 않다면 반복
    {
        printf("%d ", Pop(&stack));//스택에서 꺼내온 값 출력
    }
    printf("\n");
    return 0;
}

void InitStack(Stack *stack)//스택 초기화
{
    stack->top=NULL;

}
int IsEmpty(Stack *stack) //스택이 비었는지 확인
{
    if(stack->top==NULL) {
        return 1;
    } 
    return 0;
}
void Push(Stack *stack, int data) //스택에 보관
{
    Node *now = (Node *)malloc(sizeof(Node));
    now->data = data;
    now->next=stack->top; // now의 next링크를 현재 top으로 설정!
    stack->top = now; // stack의 맨앞은 now
}

int Pop(Stack *stack)//스택에서 꺼냄
{
    int re;
    Node *now;
    if(IsEmpty(stack)){
        return 0;
    }
    now = stack->top;
    re = now->data;

    stack->top= now->next;
    free(now);
    return re;
}