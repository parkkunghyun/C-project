import java.io.*;
import java.util.*;

public class b1916 {
    static int N,M;
    static int start, end;
    static int map[][];
    static boolean visited[][];
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];

        for (int i = 1; i<= N; i++) {
            for (int j =1; j<= N; j++) {
                map[i][j] = -1;
            }
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int startBus = Integer.parseInt(st.nextToken());
            int endBus = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            if (map[startBus][endBus] != -1  ) {
                if (cost < map[startBus][endBus]) {
                    map[startBus][endBus] = cost;
                }
            }
            else 
            {
                map[startBus][endBus] = cost;
            }   
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dfs(start, end, 0);
        System.out.println(result);
    }

    private static void dfs(int now, int end, int sum) {
        
        if (now == end) {
            result = Math.min(result, sum);
            return;
        }
        if (sum > result) {
            return;
        }

        int mins = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 1; i <= N; i++) {
            if (map[now][i] != -1 && map[now][i] < mins && visited[now][i] == false) {
                mins = map[now][i];
                minIndex = i;
            }
        }

        // 방문하지 않은 노드 중 가장 비용이 적은 노드를 어케 선택하자..
        for (int i = 1; i <= N; i++) {
            if (minIndex == i && mins == map[now][i]) {
                visited[now][i] = true;
                dfs(i, end, sum + map[now][i]);
                visited[now][i] = false;
            }
        }
    }
}
