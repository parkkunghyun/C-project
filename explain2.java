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
~~

signal(cv2); or broadcast(cv2)
release(m); -> 모니터 락 반환


*/