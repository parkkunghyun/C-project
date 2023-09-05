import java.util.*;
import java.io.*;

public class b1806 {
    static int N,S;
    static int [] arr;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i< N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int sum = 0;
        int end = 0;
        int start = 0;
        // 5 15
        // 5 1 3 5 25
        // 39
        // 34
        // 33
        // 28
        // 25
        
        while (start <= N && end <= N ) {
            if (sum >= S && result > end - start) {
                result = end - start;
            }
            if (sum < S) sum += arr[end++];
            else sum -= arr[start++];
        }
        if (result == Integer.MAX_VALUE) {
            System.out.println("0");
        }
        else {
            System.out.println(result);
        }
    }
}