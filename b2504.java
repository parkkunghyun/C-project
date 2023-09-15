import java.io.*;
import java.util.*;

public class b2504 {
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        boolean check = true;

        for (int i = 0; i< s.length(); i++) {
            if (s.charAt(0) == ']' || s.charAt(0) == ')') {
                check = false;
                break;
            }
            else if (s.charAt(i) == '(' || s.charAt(i) == '[') {
                stack.add(s.charAt(i));
            }
            else if (s.charAt(i) == ']' || s.charAt(i) == ')') {
                if (s.charAt(i) ==']' && stack.peek() == '[' ) {
                    stack.pop();
                }
                else if (s.charAt(i) ==')' && stack.peek() == '(' ) {
                    stack.pop();
                }
            }
        }

        if (check == false || !stack.isEmpty()) {
            System.out.println(0);
        }
        else {
            int result = 0;
            int cnt = 1;

            // 2 랑 3의 환장 콜라보
            // 맨 마지막 일때 무조건 sub값 전부 result로 옮기기
            // )( 이거나 )[ 이거 ]( 이거  ][ 면 그때 sub값 result로 옮기자 아니면 맨 마지막일때
            // ( [ 만 쌓자! 그리고 
            // ([ ]
            for (int i = 0; i< s.length(); i++) {
               char curr = s.charAt(i);

               if (curr == '[') {
                    cnt *= 3;
                    stack.push(curr);
               }
               else if (curr == '(') {
                cnt *=2;
                stack.push(curr);
               }
               else {
                    if (curr == ')' ) {
                        if (s.charAt(i - 1) == '(') {
                            result += cnt;
                        }
                        stack.pop();
                        cnt /=2;
                    }
                    else if (curr == ']') {
                        if (s.charAt(i - 1) == '[')  {
                            result += cnt;
                        }
                        stack.pop();
                        cnt /=3;
                    }
               }

            }
            System.out.println(result);
        }
    }   
}
