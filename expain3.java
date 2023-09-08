public class expain3 {
    
}
/*
하나의 객체를 두개의 스레드가 접근할때 생긴 일!
상한 귤을 골라내기 -> 두 박스여서 스레드 두개를 사용

메모리에 heap메모리에서 badCounter객체가 있다!
state=0으로 시작
cpu는 싱글코어! 스레드는 t1,t2
중간중간 context switching이 일어나서 서로 번갈아 작업

for (귤 in 귤 박스)
    if (귤 상태 is 불량) 
        badCounter.increment(); 이걸 공유!
public class Counter {
    private int state = 0;
    public void increment() {state++;}
    public int get() { return state; }
}

state++;이라는 한줄짜리 코드가 실제 기계어에서는 한줄이 아니다!
LOAD state to R1 -> 레지스터 r1에 로드
R1 = R1 + 1 -> r1에 1을 더함
STORE R1 to state -> 그걸 state에 다시 저장!

명령 코드 중간에 context switching이 일어나면 제대로 state값이 반영이 안된다!

race condition(경쟁조건)
    여러 프로세스 / 스레드가 동시에 같은 데이터를 조작할 때 타이밍이나 접근 순서에 따라 결과가 달라지는 것!

동기화 synchronization - 여러 프로세스나 스레드를 동시에 실행해도 공유 데이터의 일관성을 유지

어떻게 동기화 시킬까?
    increment를 실행할때 한번에 하나의 스레드만 실행할 수 있게 해주자!
    
critical section(임계영역)
공유데이터의 일관성을 보장하기 위해 하나의 프로세스/스레드만 진입해서 실행 가능한 영역
do {
    entry section
        critical section
    exit section            -> state값을 그대로 저장!
        remainder section
}while (TRUE) 

critical section problem의 해결책이 되기 위한 조건 (전부 만족시키기)
    mutual exclusion - 상호 배제, 한번에 하나의 스레드만 임계영역에서 실행!
    progress - 진행 만약 현재 cs가 비어있으면 하나를 넣어주기
    bounded waiting - 한정된 대기 -> 무한정 대기는 안됨!


스핀락 / 뮤텍스 / 세마포

동기화
critical section

어떻게 mutual exclusion을 보장할까?
lock을 사용하자!

do {
    acquire lock - 하나의 스레드만 들어감!
        critical section
    release lock
}while ()


volatile int lock = 0;
void critical() {
    while (test_and_set(&lock) == 1):
    ...critical section
    lock = 0;
}
먼저 while루프에 통해 락을 획득하려고 함 
획득한 애가 critical section에서 움직임

int test_and_set(int *lockPtr) {
    int oldLock = *lockPtr;
    *locPtr = 1;
    return oldLock;
}
lock값이 이 함수를 부르면 1로 됨!

t1 t2 스레드가 있음
t1이 먼저 시작 -> while조건문 검사! lock=0이니까 while이 false여서 탈출
아래 critical section이 실행1
r그리고 t2가 시작! 근데 lock이 이제 1이니까 while이 참이어서 반복!

t2는 계속 돌고 있음!
t1이 자기 할일 마치면 lock=0으로 바뀌니까 t2는 나오게 됨! 그리고 critical section 실행!

만약 t1 t2가 동시에 들어온다면?? 그러면 걸리지 않나?
test_and_set 함수는 cpu의 atomic명령어!
    실행 중간에 간섭받거나 중단되지 않음
    그리고 같은 메모리영역에 대해 동시 실행안됨! -> 스레드 두개 동시 실행이 절대 안됨!

근데 while계속 반복하면서 락 가질 때 까지 시도 -> 스핀락
    cpu를 너무 낭비함!!

그래서 락이 준비되면 나 깨워...
class Mutex {
    int value = 1;
    int guard = 0;
}

mutex의 value를 취득해야만 자기자신을 실행 가능!
mutex->lock();
...critical section
mutex->unlock();

현재 스레드를 큐에 넣고 큐에 하나라도 있으면 다 끝난 후에 가져옴!
뮤텍스 - 락을 가질수 있을때까지 휴식!

뮤텍스가 스핀락보다 항상 좋을까?
cpu를 덜 잡아먹지만 스핀락은 실행을 계속 하고 있으므로 
큐에서 찾는 것보다 다음 스레드 실행하는게 더 빠를듯

멀티코어 환경이고 critical section에서 작업이 컨텍스트 스위칭보다 더 빨리 끝난다면
스핀락이 뮤텍스보다 더 이득임

다른 코어에서 스핀락으로 t2가 계속 확인하기 때문에 멀티 코어에서 이점!

세마포 - signal mechanism을 가진 하나이상의 프로세스/ 스레드가 c.s에 접근 가능하도록 하는 장치
semaphore->wait();
...critical section
semaphore->signal();

여러개 코어가 있을때 각각 스레드를 실행할때 이득!
세마포는 순서를 정해줄 때 사용 -> 무조건 전에 작업이 끝나야 내 작업 시작이 가능!
카운트를 조잘하여 진입 가능한 프로세스 수 나 스레드 수를 조절할 수 있다!

뮤텍스와 이진 세머포는 같은 것 아닐까?
    뮤텍스는 락을 가진 사람만 락 해제 가능!
    세마포는 옆에 가져올수있다'

*/