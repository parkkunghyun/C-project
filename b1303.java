import java.io.*;
import java.util.*;

/*
 N명 모이면 제곱으로 힘
 대각선은 패스

 상하좌우 계산해서 전부 막혀있으면 그때 제곱해서 더하기!
 dfs이네!

 */

public class b1303 {
    static int wSum = 0, bSum = 0;
    static double subW = 1, subB = 1;
    static char map[][];
    static boolean visited[][];
    static int N,M;
    static int []dy = {1,0,-1,0};
    static int []dx = {0,1,0,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i<M; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i< M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == false) {
                    visited[i][j] = true;
                    // count, 단어, 위치
                    check(map[i][j], i, j);
                    if (map[i][j] == 'W') {
                        wSum += Math.pow(subW, 2);
                        //System.out.println( " sub w ---> " + subW);
                        subW = 1;
                    }
                    else {
                        bSum += Math.pow(subB, 2);
                        //System.out.println( " sub b ---> " + subB);
                        subB = 1;
                    }
                }
            }
        }
        System.out.println(wSum + " " + bSum);


    }

    private static void check( char word, int y, int x ) {

        for (int i = 0; i< 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (0<= ny && ny < M && 0<= nx && nx < N) {
                if (visited[ny][nx] == false && map[ny][nx] == word) {
                    visited[ny][nx] = true;
                    if (map[ny][nx] == 'W') subW++;
                    else subB++;
                    check(word, ny, nx);
                }
            }
        }
    }
    
}
