import java.io.*;
import java.util.*;

/*
anta tica 를 두고 사용!
K개의 글자를 가르치는데 일단 5보다 작음 안됨!
소문자 26개 다 사용가능이면 모든 N개 단어 읽기 가능!

*/

public class b14719 {
   static int N,K;
   static String words[];
   static boolean visited[];
   static int result = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K < 5) {
            System.out.println(0);
            return;
        }
        if (K == 26) {
            System.out.println(N);
            return;
        }
        words = new String[N];
        visited = new boolean[26]; // 모든 알파벳을 돌거다! 어떤 알파벳들을 선택했을때 최대 개수가 나오는지!

        for (int i = 0; i < N; i++) {
            words[i] = br.readLine().replace("anta", "").replace("tica", "");
        }
        
        visited['a' - 'a'] = true;
        visited['n' - 'a'] = true;
        visited['t' - 'a'] = true;
        visited['c' - 'a'] = true;
        visited['i' - 'a'] = true;

        dfs(0,0);
        System.out.println(result);
    }
    private static void dfs(int depth, int start) {
        if (depth == K - 5) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                boolean check = true;
                for (int j = 0; j < words[i].length(); j++) {
                    if (visited[words[i].charAt(j) - 'a'] == false ) {
                        
                        check = false;
                        break;
                    }
                }

                if (check == true) {
                    count++;
                }
            }

            result = Math.max(count, result);
            return;
        }
        
        for (int i = start; i < 26; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(depth + 1, i);
                visited[i] = false;
            }
        }

    }
}
