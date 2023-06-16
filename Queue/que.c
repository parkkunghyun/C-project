#include<stdio.h>
#include<stdlib.h> // 동적할당!
#include<string.h> // 문자열 관련!

typedef struct Node
{
    int data;
    struct  Node *next; // 다음 주소를 넣는 곳!
}Node;

typedef struct Queue
{
    Node *front; // 맨앞 -> 꺼낼 위치!
    Node *rear; // 맨 뒤 -> 보관 위치!
    int count; // 보관개수
}Queue;

void InitQueue(Queue *queue); // z큐 초기화
int IsEmpty(Queue *queue); 
void Enqueue(Queue *queue, int data); // push
int Dequeue(Queue *queue);

int main(void)
{
    int i;
    Queue queue;

    InitQueue(&queue);//큐 초기화
    for (i = 1; i <= 5; i++)//1~5까지 큐에 보관
    {
        Enqueue(&queue, i);
    }
    while (!IsEmpty(&queue))//큐가 비어있지 않다면 반복
    {
        printf("%d ", Dequeue(&queue));//큐에서 꺼내온 값 출력
    }
    printf("\n");
    return 0;
}

void InitQueue(Queue *queue) {
    // 초기화 하는 코드! 
    // 구조체에 대해 동적 할당해주기?
    
    // 1. 일단 앞뒤 둘다 NULL로 설정해서 아에 비었다는거 알림!
    queue->front = queue->rear = NULL;
    queue->count = 0;
}
int IsEmpty(Queue *queue) {
    if(queue->count==0) {
        return 1;
    }
    return 0;
}

void Enqueue(Queue *queue, int data) {
    
    Node *now = (Node*)malloc(sizeof(Node));
    now->data = data;
    now->next=NULL; // 아직 뒤가 없으니까!!
    
    if(IsEmpty(queue)) {
        queue->front = now;
    }else {
        queue->rear->next = now;
    }
   queue->rear = now;
    queue->count +=1;
}

int Dequeue(Queue *queue) {
    int re = 0;
    Node *now;
    if(IsEmpty(queue)) {
        return re;
    }
    now = queue->front;
    re = now->data;
    queue->front = now->next; // 맨앞을 now의 다음 노드로 설정!
    free(now);
    queue->count--;
    return re;
}