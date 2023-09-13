public class explain2 {
    public static void main(String[] args) {
        
    }
    
}
/* 
모니터 - mutual exclusion을 보장, 조건에 따라 스레드가 waiting 상태로 전환 가능
언제 사용? -> 한번에 하나의 스레드만 사용되어이할때나 협업이나 협력 필요할때

mutex, condition variables
mutex -> critical section에서 mutual exclusion을 보장하는 장치
    진입하려면 mutex lock을 취득해야함! -> 아직 취득 못한 스레드는 큐에 들어가 대기!
    mutex lock을 쥔 스레드가 락을 반환하면 큐에 있던 스레드 중 하나가 실행!

condition variable - waiting queue를 가짐, 스레드 대기 공간
    wait - 스레드가 자기 자신을 condition variable의 waiting queue에 넣고 대기 상태로 전환
    signal - 웨이팅 큐에서 스레드 중 하나를 깨움
    broadcast - 전부 깨움

acquire(m)
while(!p) {
    wait(m,cv);
}
~~~~이런 저런 코드들
signal(cv2); or broadcast(cv2)
release(m); -> 모니터 락 반환

뮤텍스 락을 갖지 못한 스레드는 waite queue에 대기!

두개의 큐 
entry queue : critical section에 진입을 기다리는 큐 , 뮤텍스가 관리
waiting queue: 조건 충족 기다림! cv에 의해 관리

bounded producer / consumer problem
고정된 버퍼
producer는 버퍼에 아이템을 넣고 consumer가 아이템을 꺼내 사용!

문제
buffer가 가득 차도 계속 생산 -> 계속 끊임없이 버퍼 확인해야할까?
consumer는 버퍼에 아이템 확인을 해야할까?

c1 스레드 p1 스레드가 있다고 가정
c1이 먼저 시작! -> 모니터에 뮤텍스 락 취득하려고 함 -> 그리고 성공!
while에서 버퍼 비어있는지 확인! -> p1이 그리고 시작이 됨
p1은 아직 뮤텍스 락을 못 가짐 -> p1은 엔트리 큐에서 대기! -> 
c1은 버퍼에 아무것도 없어서 wait하게 됨! -> 뮤텍스 락을 반환 -> p1을 깨우고 엔트리 큐 빠져나오기
p1이 while에서 자기 역할 수행! 즉 버퍼에 아이템 채우기  -> t1이라는 아이템이 버퍼에 들어감
기다리고 있는 스레드를 깨우는 걸 하나냐 전부에 따라 signal , broadcast!

p1이 일단 깨우고 자기 역할 다하고 c1에게 락을 줌!
c1은 그 전까지 entry queue에 있었다!


자바에서 모니터란
자바에서는 모든 객체가 내부적으로 모니터를 가짐!
synchronized 키워드를 사용해서 mutual exclusion을 보장 받는다!

*/