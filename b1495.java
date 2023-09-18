import java.io.*;
import java.util.*;

/*
 공연이 시작하기 전에 바꿀수있는 불륨의 리스트를 만들었다.
 v , v[i]는 p i p + v[i], p-v[i] 0보다 작거나 M보다 크게는 못바꿈
 마지막 곡을 연주 할수있는 블륨중 최댓값

 마지막 곡을 연주 할수없다면 -1을 출력!

 dp인거 같긴한데  dfs 즉 재귀로도 풀 수 있긴 할듯

 dp에 무엇을 저장할 것인가 그리고 마지막이 최대가 나오려면 중간에 빼주는것도 해줘야함!


 */
public class b1495 {
    static int N,S,M;
    static int arr[], dp[];
    
    static int maxs = Integer.MIN_VALUE;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M + 1];
       
        for (int i = 0; i <= M; i++) {
            arr[i] = -1;
        }
        arr[S] = 0;

         st = new StringTokenizer(br.readLine());
        for (int i = 1; i<= N; i++) 
        {
            int V = Integer.parseInt(st.nextToken());
            for (int j = 0; j<= M; j++) {
                if (arr[j] == i - 1) {
                    int res1 = j + V;
                    int res2 = j - V;

                    if (0<= res1 && res1 <= M) {
                        arr[res1] = i;
                    }
                    if (0<= res2 && res2 <= M) {
                        arr[res2] = i;
                    }

                }
            }
        }

        int max = -1;
        for (int i = 0; i<= M; i++) {
            if (arr[i] == N) {
                max = Math.max(max, arr[i]);
            }
        }

        System.out.println(max);
        
    }
    
}
