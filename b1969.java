import java.io.*;
import java.util.*;

/*
 두 개수의 차이가 가장작은 dna구하기?
 무슨 단어를 했을때 다른 단어들과 최소한으로 다를까...

 각 분기마다 가장 많이 나온 애로 하기?
 근데 개수가 같으면? 그냥 가?  -> 사전순! 영단어 보고 개수 같으면 사전순!

 */

public class b1969 {
    static int N,M;
    static String [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        // 개수 세기!
        // 
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i< M; i++) {
            char maxWord = ' ';
            int cnt = -1;
            int [] alpha = new int [26];
            
            for (int j = 0; j< N; j++) {
                char s = arr[j].charAt(i);
                alpha[s - 65]++;
            }

            // alpha 검사!
            for (int j = 0; j< 26; j++) {
                if (cnt < alpha[j]) {
                    cnt = alpha[j];
                    maxWord = (char) (j + 65 );
                }
            }
            sb.append(maxWord);
        }
        String curr = sb.toString();

        int sum = 0;
        for (int i = 0; i< N; i++) {
            String w = arr[i];
            for (int j = 0; j< M; j++) {
                if (curr.charAt(j) != w.charAt(j)) {
                    sum+=1;
                }
            }
        }
        System.out.println(curr);
        System.out.println(sum);
    }
}
