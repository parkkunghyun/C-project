import java.io.*;
import java.util.*;

// 1-> 50분
// 연결리스트를 만들어서 저장해놓을까?
// 각각의 칸에 맞는 arrayList를 만들어서 사용하기?

class Point {
    int number;
    int discount;
    public Point(int number, int discount) {
        this.number = number;
        this.discount = discount;
    }
}

public class b2945 {
    static int N;
    static int [] c;
    static int [] pInfo;
    static int max = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[11];
    static HashMap<Integer, ArrayList<Point>> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        c = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i < N; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }
        
        for (int i = 1; i <= N; i++) {
            int p = Integer.parseInt(br.readLine());
            if (p == 0) continue;

            for (int j = 0; j < p; j++) {
                st = new StringTokenizer(br.readLine());
                if (map.get(i) == null) {
                    map.put(i, new ArrayList<>());
                }
                map.get(i).add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
        }
        // 그냥 모든 경우에 따른 순열을 돌리면 되는거였음!
        // 순열을 구해보자 그리고 돌리는 함수를 하나 만들자! - 근데 이거 그냥 dfs이긴함
        check();
    }

    private static void check() {
        for (int i =1; i<= N; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(1,c[i],i);
                visited[i] = false;
            }
        }
    }

    private static void dfs(int depth, int sum, int start) {
        if (depth == N) {
            max = Math.min(max, sum);
        }
        return ;
    }
    // 일단 현재 start에 할인이 있으면 무조건 해주기 
    // 그리고 for문 돌려서 visited 안한데 바로 들어가주는 재귀 하기!
    

}
