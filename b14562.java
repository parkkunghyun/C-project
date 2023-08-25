import java.io.*;
import java.util.*;

/**
 * A - 현재 점수만큼 점수 얻기 -> 상대 3점 득점 가능
 * B - 1점 얻기
 * S / T -> 둘이 같아지는 연속 발차기 횟수
 * 10 20 
 *  -> 11 20 -> 22 23 -> 23 23 
 * 2 7 
 *  -> 4 10 -> 8 13 -> 16 16
 */

public class b14562 {
    static int C;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        C = Integer.parseInt(br.readLine());
        for (int i =0; i< C; i++) {
            count = 100000;
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());

            if (S == T) {
                System.out.println(0);
                continue;
            }
            dfs(0, S ,T);
            System.out.println(count);
        }
    }
    static void dfs(int depth, int S, int T) {
        if (S > T) return ;
        if (S == T) {
            count = Math.min(count, depth);
            return ;
        }

        dfs (depth + 1, S*2 , T + 3);
        dfs (depth + 1, S + 1, T);
    }
}
