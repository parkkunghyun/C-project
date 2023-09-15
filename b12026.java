import java.io.*;
import java.util.*;

/*
8시 10분까지!

 N개 보도블록 - 1-ㅡN
 1번은 무조건 b
 k *k 만큼 필요
 못만나면 -1
boj순서로 밟으면서 가야함!

점화식 세워보자
b 면 o를 찾고
o면 j를 찾고
j면 b를 찾게

다다음 문자 만나기 전까지 모든 
dp[i] = Math.min(dp[j], );

현재가 b니까 다음은 o 그다음은 j 그리고 다시 b가 나오게 찾기

 */

public class b12026 {
    static int N;
    static char [] arr;
    static int [] dp;
    static char curr;
    static int max = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N];
        arr = br.readLine().toCharArray();

        Arrays.fill(dp,max);
        curr = 'B';
        dp[0] = 0;
        // dp[j] != Integer.MAX_VALUE => 즉 이전에 여길 들렸다!
        for (int i = 1; i< N; i++) {
            for (int j = 0; j< i; j++) {
                if (arr[i] == 'O' && arr[j] == 'B' && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + (i - j) * (i - j));
                }
                else if (arr[i] == 'J' && arr[j] == 'O' && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + (i - j) * (i - j));
                }
                else if (arr[i] == 'B' && arr[j] == 'J' && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + (i - j) * (i - j));
                }
            }
        }
        System.out.println( (dp[N - 1] == Integer.MAX_VALUE ? -1 : dp[N - 1] ) );
       
    }
    
}
