//import java.io.*;
//import java.util.*;

// 상속 -> 파생클래스를 정의할때 extends를 붙여서 어떤 클래스를 부모로 할건지 정함!
//

class Musician2 {
    public void play() {
        System.out.println("연주");
    }
}
class Pianist extends Musician2 {
    public void tuning() {
        System.out.println("조율");
    }
}

public class b5 {
    public static void main(String[] args) {
       Pianist pianist = new Pianist();
       pianist.tuning();
       pianist.play(); 
    }
}
