import java.io.*;
import java.util.*;

/*
  s 크기 n 모니터에 나타내야할 수
  - | 로 나타내기!

  s + 2 2s + 3

  _ _ _
  |    | 
  |    |
  - - - 
  |    |
  |    |
  - - -

  
  일단 애네를 전부 넣을 배열을 만들어야함!
  1일때 어떻게 그릴지  -> 그냥 s + 2 니까 5개 채운다 생각  2s + 3 - 2 = 2s + 1
  그리고 
| 2는 어떻게 그릴지 -> 

10개 + 9개의 공백

 */

public class b2290 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken(br.readLine()));
        String N = st.nextToken(br.readLine());

        for (int i = 0; i< N.length(); i++) {
            char c = N.charAt(i);
            if (c == '0') {
                

            }
            else if (c == '1') {

            }
            else if (c == '2') {
                
            }
            else if (c == '3') {
                
            }
            else if (c == '4') {
                
            }
            else if (c == '5') {
                
            }
            else if (c == '6') {
                
            }
            else if (c == '7') {
                
            }
            else if (c == '8') {
                
            }
            else if (c == '9') {
                
            }

        }
    }
    
}
