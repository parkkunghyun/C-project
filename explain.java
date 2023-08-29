public class explain {
    public static void main(String[] args) {
        int a = 7;
        int b = 3;
        int c = a + b; // 
        System.out.println(c);

        int d = 100;
        d = wow(d);

        Counter cc = new Counter();
        System.out.println(cc);
    }

    static int wow(int num) {
        int b = num * 4;
        return b;
    }
}
class Counter {
    private int state = 0;
    public void increment() { state++; }
    public int get() {return state; }
}

/*
 * 어플리케이션은 어떻게 실행 될까?
 * 어플리케이션: 일반사용자가 사용할 기능을 제공하는 컴퓨터가 실행 할 수 있는 명령어들의 집합
 * 메모리: 실행된 어플리케이션이 상주하는 곳, cpu: 명령어를 실행하는 추세
 * 
 * cpu에서 메모리에 7을 저장하고 a라는 이름을 붙이고 b도 그렇게 함!
 * 그리고 a + b를 더해서 메모리에 저장하라라는 명령어를 cpu가 던지고 메모리에 c라는 이름으로 저장된다
 * 
 * runtime -> 실행상태 실행되고 있는 시간을 의미!
 * 
 * 어플리케이션이 될때 데이터는 어떻게 저장 될까?
 * 
 * 메모리 구조
 * stack 메모리 -> 함수나 메서드의 지역변수와 매개변수가 저장됨, 함수 호출 시 스택 프레임에 쌓인다!
 * heap메모리 -> 객체가 저장
 * 
 * stack frame에는 main메소드 실행하면 -> 메인스택프레임이 만들어짐! 이 안에 매개변수와 지역변수가 저장
 * args 저장 -> 그 다음 7이 a라는 이름으로 저장 -> 계속 쌓임!
 * 
 * wow 함수를 불렀을때
 * stack memory -> main에 앞에 꺼 쌓이고 이름 d로 100이 쌓임! 
 * 그 다음 wow 스택이 만들어진다! -> num 넣고 b가 쌓인다! 
 * wow메소드가 리턴하게 되면스택 프레임이 사라진다!!! 그리고 메인 프레임에서 d가 400으로 바뀐다!
 * 
 * 알아서 함수 리턴할때 스택에서 사라지니까 개발자가 콜백지옥에서 안빠지게만 만들면 됨
 * 재귀를 조심하기! -> 스택 프레임이 다 차버리면 종료됨
 * 
 * Heap !!! -> 매우 중요!
 * 
 * main메소드가 먼저 실행 -> 스택프레임이 생성 그리고 각각이 쌓임
 * new로 하면 생성자임! 이것도 메소드의 일종!!
 * 그래서 Counter라는 스택 프레임이 생기긴함!!
 * 
 * 그리고 heap에 드디어객체가 생성! state = 0으로 들어감
 * 그리고 main에서는 Counter객체를 가리킴!! - heap메모리에 있는 객체의 주소가 저장!
 * 
 * this -> 숨겨진 변수다! heap의 객체를 가리키는 역할 주소를 담고 있다!
 * 그리고 이제 c도 가리킴! -> 객체의 상태를 바꿀때는 신중하게 하기!
 * 
 * 쓰레기 객체-> garbage object 
 * heap 메모리에는 있는데 실제로 참조를 안하고 있으면 gc에서 보고 제거한다!
 * 
 * public static void main(String [] args) {
 *  Counter c = make();
 * }
 *
 * public static Counter make() {
 *  Counter c = new Counter();
 * return new Counter();
 * }
 */
