import java.io.*;
import java.util.*;

public class b1421 {
    static int N,C,W;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        arr = new int[N];
        int max = 0;
        for (int i =0; i< N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max ,arr[i]);
        }

        long res = 0;
        for (int i = 1; i<= max; i++) {
            long sum = 0;
            for (int j = 0; j< N; j++) {
                if (arr[j] >= i) {
                    int piece, div;
                    piece = arr[j] / i;
                    if (arr[j] % i == 0)
                        div = arr[j] /i - 1;
                    else
                        div = arr[j] / i;
                    if (piece * W * i - div * C > 0)
                        sum += piece * W * i - div * C;
                }
            }
            res = Math.max(res, sum);
        }
        System.out.println(res);
    }
    
}
