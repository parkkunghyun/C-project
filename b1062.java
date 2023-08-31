import java.io.*;
import java.util.*;

public class b1062 {
    static int N,K;
    static int result = Integer.MIN_VALUE;
    static boolean [] visited = new boolean[26];
    static String [] words;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if (K < 5)
        {
            System.out.println(0);
            return;
        }
        else if (K == 26) {
            System.out.println(N);
            return;
        }
        
        words = new String[N];
        // replace("anti", "");
        for (int i =0; i< N; i++) {
            String word = br.readLine().substring(4);
            int len = word.length();
            word = word.substring(0,len-4);
            words[i] = word;
        }
        // 이제는 알파벳을 넣어주기!  -> a n t i c은 넣어줘야함! 97
        visited['a' - 97] = true;
        visited['n' - 97] = true;
        visited['t' - 97] = true;
        visited['i' - 97] = true;
        visited['c' - 97] = true;

        dfs(0,0);
        System.out.println(result);

    }
    private static void dfs(int alpha, int len) {
        if (len == K - 5) {
            int count = 0;
            for (int i = 0; i< N; i++) {
                boolean check = true;
                String word = words[i];
                for (int j =0; j< word.length(); j++) {
                    if (visited[word.charAt(j) - 'a'] == false) {
                        check = false;
                        break;
                    }
                }
                if (check) count++;
            }
            result = Math.max(result, count);
            return ;
        }

        for (int i = alpha; i < 26; i++ ) {
            if (visited[i] == false) {
                visited[i] = true;
                dfs(i, len + 1);
                visited[i] = false;
            }
        }
        
    }
    
}
