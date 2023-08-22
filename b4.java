// oop란 -> 사람이 살고 있는 세상과 비슷한 구조로 프로그래밍 언어를 표현하려고 노력
// oop언어는 사용자 정의 형식을 만들때 데이터와 기능을 하나로 캡슐화!
/*
 *  주로 클래스로 정의함! 클래스 내 데이터를 멤버데이터, 기능은 멤버 메서드!
 *  캡술화를 하게 되면 멤버마다 접근 범위 지정가능해서 은닉화가 가능
 *  상속을 통해 공통구조를 묶고 파생시킴 -> 클래스 문법의 확장성을 높였다
 *  
 * 생성자 - 클래스 형식의 개체를 생성할대 해야할 일을 정의한 메서드!
 * public Musician(String name, int num) {
 *      this.name = name;
 *      this.num = num;
 * }
 */

 /*
  * 접근 지정자 
    public -> 모든 곳에서 접근이 가능!
    protected -> 클래스 자신의 내부와 파생 클래스에서는접근이 가능!
    private -> 자신 내부에서만 접근이 가능!
    클래스의 멤버 데이터는 기본이 private로 지정을 해두면 다른 클래스에서 함부로 못바꾸기 때문에 좋다

  */

  /*
   *    오버 로딩 -> 메서드 이름은 같은데 리턴 값이나 인자가 달라서 다른 메서드로 분류
   *    객체의 생과 사
   *    개체의 생성은 개발자 코드에 의해 결정 하지만 소멸은 결정 못함
   *    왜나면 JVM의 Managed Heap이 개체를 할당하여 관리를 하기 때문이다!
   *    Managed Heap은 JVM에서 개체를 참조하는 변수의 개수를 카운팅
   *    그리고 GC에 의해 관리 힙의 개체를 참조하는 변수의 카운터가 0이되면 제거!
   *    
   */

   /* 
   static을 사용하면 메모리에 한번 할당되고 프로그램 종료될때 해제
   static-> 영역에는 클래스들이 모여있다
   heap -> 객체들이 모여있다 GC가 관리!
    static변수는 클래스 변수, 객체 생성 안하고도 접근이 가능!

    * 
    */

//import java.io.*;
//import java.util.*;

class Person {
    public static final String name = "MangKyu";
    public static void printName() {
        //System.out.println(this.name);
    }
}

class Musician {
    String name;
    int skill;
    int num;
    public Musician(String name, int num) {
        this.name = name;
        this.num = num;
        skill = 0;
    }
    public void introduce() {
        System.out.println("이름 : " + this.name);
    }
}

class Unit {
    int num;
    public Unit(int num){
        this.num = num;
    }
    public int getNum(){
        return num;
    }
    //protected void finalize(){
    //    System.out.println(num+"번 개체 정리");
    //}
}

public class b4 {
    public static void main(String[] args) {
        Musician musician = new Musician("홍", 1);

        musician.introduce();

        Unit unit = new Unit(1);
        System.out.println("유닛생성" + unit.getNum());
        Unit unit2 = new Unit(2);
        System.out.println("유닛생성" + unit2.getNum());

        unit = null;
        System.gc(); // GC가 가동
       // System.runFinalization();
        System.out.println("음");
    }
}
