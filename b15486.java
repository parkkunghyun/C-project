import java.io.*;


/*
 12시 40분 -> 1시 20분까지

 일단 dp문제인건확실!
 점화실을 어떻게 세울건지 고민해보면 될듯!
 3  5  1   1   2  4 2
 10 20 10  20  15 40 200

 dp[i] = max(dp[dp[j]])
 일단 전부 0으로 바꾸고, 

dp[1] = 0 // 
nxt = 1 + T1 = 4
dp[4] = /math.max(dp[4], dp[1] + p1) = 10

dp[2] = 0
dp[7] = Math.max(dp[7], dp[2] + 20) = 20

dp[n] = 0
dp
 */

public class b15486 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N + 2][2];
        int dp[] = new int[N + 2];

        for (int i = 1; i <= N; i++) {
            String [] s = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(s[0]);
            arr[i][1] = Integer.parseInt(s[1]);
        }
        int max = -1;
        for (int i = 1; i<= N + 1; i++) {
            if (max < dp[i]) {
                max = dp[i];
            }
            int nxt = i + arr[i][0];
            if (nxt < N + 2) {
                dp[nxt] = Math.max(dp[nxt], max + arr[i][1]);
            }
        }
        System.out.println(dp[N+1]);
    }
    
}
