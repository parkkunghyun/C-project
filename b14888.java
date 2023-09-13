import java.io.*;
import java.util.*;

/*
N - 1개의 연산자 주어짐 -> 
+ - * /  -> 최대 최소
각각의 개수가 주어질때 어떻게 구할지!

 */
public class b14888 {
    static int N;
    static int arr[];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int plus = Integer.parseInt(st.nextToken());
        int minus = Integer.parseInt(st.nextToken());
        int mul = Integer.parseInt(st.nextToken());
        int div  = Integer.parseInt(st.nextToken());

        check(1, arr[0], plus, minus, mul, div);

        System.out.println(max);
        System.out.println(min);

    }
    private static void check(int depth, int sum,  int plus, int minus, int mul, int div) {
        if (depth == N) {
            if (sum > max) max = sum;
            if (sum < min) min = sum;
            return ;
        }

       if (plus > 0) {
            check(depth + 1, sum + arr[depth], plus - 1,minus, mul, div );
        }
        if (minus > 0) {
            check(depth + 1, sum - arr[depth], plus ,minus - 1, mul, div );
        }
        if (mul > 0) {
            check(depth + 1, sum * arr[depth], plus ,minus, mul - 1, div );
        }
        if (div > 0) {
            check(depth + 1, sum / arr[depth], plus ,minus, mul, div -1 );
        }

    }
}
