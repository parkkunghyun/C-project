import java.io.*;
import java.util.*;

/*
7시부터 7시 40분까지 빡코딩 그리고 답 보기
N가지 종류 동전, k원에 맞추기 -> 최소

이건 경우의 수 몇개인지 -> 카운트하라는 문제

k가 1인 경우 k >= coin[i]일때만 dp[k] 값이 달라짐

 */

public class b2294 {
    static int n, k;
    static int arr[];
    static int save[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        save = new int[k + 1];
        arr = new int[n];

        for (int i = 0; i< n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        save[0] = 1;
        for (int i = 0; i< n; i++) {
            for(int j = arr[i]; j <= k; j++) {
                save[j] = save[j] + save[j - arr[i]];
            }
        }
        System.out.println(save[k]);

    }

}
