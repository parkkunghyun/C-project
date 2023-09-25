import java.io.*;
import java.util.*;

/*
 N개의 정수 양수인 부분수열
 S가 되는 경우의 수?

dfs사용?
모든 수열을 만들어서 저장했다가 계산하기?
 */
public class b1182 {
    static int N,S;
    static int cnt = 0;
    static int arr[];
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i <= N; i++) {
            visited = new boolean[N];
            check(0, 0, i);
        }
        System.out.println(cnt);
    }

    private static void check(int depth, int sum, int nidx) {
        if (depth == nidx) {
            if (S == sum) {
                cnt++;
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                check(depth + 1, sum + arr[i], nidx);
                visited[i] = false;
            }
        }
    }
}
