import java.io.*;
import java.util.StringTokenizer;

/*
 N,K x일때 걸으면 1초후에 +-1로 이동
 순간이동 2*x로 이동
 수빈이가 동생 찾는 가장 빠른 초 -> 

 */

public class b12851 {
    
    static int cnt = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        check(N, 0,K);
        System.out.println(cnt);
    }

    private static void check(int curr, int sub, int K) {
        if (curr > K || curr <= -1) {
            return ;
        }

        else if (curr == K) {
            System.out.println(curr+" ddd " + K+ " fff " + sub);
            if (sub < cnt) {
                cnt = sub;
            }
            return;
        }

        check(curr + 1, sub + 1, K);
        check(curr - 1, sub + 1, K);
        check(curr * 2, sub + 1, K);

    }
    
}
