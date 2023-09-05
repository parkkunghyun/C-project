import java.io.*;
import java.util.*;

/*
더해서 숫자로! - 일단 더해서 숫자로 나타낸뒤
숫자를 최대값부터 해서 반복시켜서 아라비아 숫자로 만들기!

저걸 다 넣은 key 값 쌍의 map을 만들어서 계산해주자!
VLD가 한번만 사용!
IXCM은 3번만 연속!
IV IX / XL XC / CD CM / 그리고 한번씩만 사용이 가능!
A B E F G H
그러면 한번 사용했을때 막는게 필요하다!

일단 칸이 두개씩 차지하는 애들을 바꿔주자! -> 그러면 훨씬 편함!

*/

public class b2608 {
    static String first;
    static String second;
    static HashMap<String, Integer> map = new HashMap<>();
    static int sum = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        first = br.readLine().replaceAll("IV", "A");
        first = first.replaceAll("IX", "B");
        first = first.replaceAll("XL", "E");
        first = first.replaceAll("XC", "F");
        first = first.replaceAll("CD", "G");
        first = first.replaceAll("CM", "H");

        second = br.readLine().replaceAll("IV", "A");
        second = second.replaceAll("IX", "B");
        second = second.replaceAll("XL", "E");
        second = second.replaceAll("XC", "F");
        second = second.replaceAll("CD", "G");
        second = second.replaceAll("CM", "H");

        int firstNum = 0;
        char firstAray[] = first.toCharArray();
        int secondNum = 0;
        char secondArray[] = second.toCharArray();

        for (char i : firstAray) {
            firstNum += charChanger(i);
        }
        for (char i : secondArray) {
            secondNum += charChanger(i);
        }
        int resultNum = firstNum + secondNum;

        String resultString = numChanger(resultNum);
        System.out.println(resultNum);
        System.out.println(resultString);

    }
    /*
    규칙을 적어보자
    V L D 는 한번씩
    L X C M은 연속 세번만! - 두 수의 합이 4000보다 작아서 3999가 최대-> 이러면 M을 고려 안해도 됨!
    IV IX
    XL XC
    CD CM -> 400 900 D는 더는 못씀! D만 따로!

    XL XC -> 40 90은 L과 묶기!

    IV IX V 이렇게 묶기!
    */
    private static String numChanger(int n) {
        StringBuilder sb = new StringBuilder();
       
        while (n >= 1000) {
            n -= 1000;
            sb.append("M");
        }

        // CM D CD
        if (n >= 900) {
            n -=900;
            sb.append("CM");
        }
        else if (n >= 500) {
            n -= 500;
            sb.append("D");
        }
        else if (n >= 400) {
            n -= 400;
            sb.append("CD");
        }

        while (n >= 100) {
            n -=100;
            sb.append("C");
        }

        // XL L XC
        if (n >= 90) {
            n -= 90;
            sb.append("XC");
        }
        else if(n >= 50) {
            n -= 50;
            sb.append("L");
        }
        else if (n >= 40) {
            sb.append("XL");
            n -= 40;
        }

        while(n >= 10) {
			sb.append("X");
			n -= 10;
		}

		if(n >= 9) {
			sb.append("IX");
			n -= 9;
		}

		if(n >= 5) {
			sb.append("V");
			n -= 5;
		}
		
		if(n >= 4) {
			sb.append("IV");
			n -= 4;
		}
		// 여기도 같다.
		while(n >= 1) {
			sb.append("I");
			n -= 1;
		}
 
        return sb.toString();
    }
    private static int charChanger(char c) {
        int comp = 0;
        if (c == 'I') comp = 1;
        else if (c == 'V') comp = 5;
        else if (c=='X') comp = 10;
        else if (c=='L') comp = 50;
        else if (c=='C') comp = 100;
        else if (c=='D') comp = 500;
        else if (c=='M') comp = 1000;
        else if (c=='A') comp = 4;
        else if (c=='B') comp = 9;
        else if (c=='E') comp = 40;
        else if (c=='F') comp = 90;
        else if (c=='G') comp = 400;
        else if (c=='H') comp = 900;

        return comp;
    }
}
