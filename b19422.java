import java.io.*;

/*
() 길이가 L인 올바른 괄호 문자열 개수!
모든 경우를 만들어보고 각각 체크해서 개수세기?

dp인가?
2 -> 1 -> 1
4 -> 1 1 / 2 -> 2
6 -> 1 1 1 / 1 2 / 3 -> (()())   -> 5
8 -> 1 1 1 1 / 2 1 1 / 1 3 / 4 -> 
10 -> 1 1 1 1 1 / 1 1 1 2 / 1 1 3 / 1 4 / 5 -> 
12 -> 
((())) (())() ()(()) (()()) ()()()

dp[6] = dp[0]dp[4] + dp[2]dp[2] + dp[4]dp[4]
() ""()

(()) ()() 
dp[4] = dp[0]*dp[2] + dp[2]*dp[0]

dp[6] = dp[4]dp[0] + dp[2]dp[2] dp[0]dp[4]

문자열이 끝나게 만들기!


*/

public class b19422 {
    static int T, L;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        long dp[] = new long[5001];
        dp[0] = 1;
        dp[2] = 1;

       
    }
    
}
