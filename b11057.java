import java.io.*;
import java.util.*;

/*
30분까지

 왼에서 오른쪽으로 봤을때 오름차수 출력
 N이 주어지면 몇개가오르막인가
 11 12 13 14 15 16 17 18 19 
 22 23 24 25 26 27 28 29

 


   0  1  2  3  4  5  6  7  8  9
1  1  1  1  1  1  1  1  1  1  1
2  10 9  8  7  6  5  4  3  2  1
3  55 45 36 28 21 15 10 6  3  1 
4  

[1][0] = 1
[1][9] = 1

[2][0] = dp[1][0 - 9] - d[1][0]

 dp[2][0] = dp[1][0]dp[1][1] .. dp[1][9] 


 그래서 다 적으면 그 숫자는 오름차순인지 비교하는 체크 함수에 넣어보기
 */

public class b11057 {
    static int N;
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int [][] dp = new int[N + 1][10];
        for (int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        System.out.println(dp[N][0] % 10007);
    }

}
