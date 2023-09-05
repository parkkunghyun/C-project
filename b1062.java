import java.io.*;
import java.util.*;

/*
이 문제에서는 양 옆이 없으면 그 끝을 포함해서 계산하지 않는다!
왼쪽에서 제일 큰데랑 오른쪽에서 제일 큰데를 찾아서 -> 둘 중 min한거를 내 현재랑 빼주기!
*/

public class b1062 {
    static int H,W;
    static int result = 0;
    static int left,right;

    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      H = Integer.parseInt(st.nextToken());
      W = Integer.parseInt(st.nextToken());
      int []arr = new int[W];
      st = new StringTokenizer(br.readLine());  
      for (int i =0; i< W; i++) {
        arr[i] = Integer.parseInt(st.nextToken());
      }

      for (int i = 1; i < W - 1; i++) {
        left = arr[i];
        right = arr[i];
        
        // 왼쪽 찾기
        for (int j = 0; j<=i; j++) {
            if (left < arr[j]) {
                left = arr[j];
            }
        }
        // 오른쪽 찾기
        for (int j = i ; j< W; j++) {
            if (right < arr[j]) {
                right = arr[j];
            }
        }
        if (left > arr[i] && right > arr[i]) {
            result += Math.min(left, right) - arr[i];
        }

      }
      System.out.println(result);
    }
    
}
