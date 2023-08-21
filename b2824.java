import java.util.*;
import java.io.*;

public class b2824 {
    static final int MOD = 1000000000;
    static int n,m,a,b;
    static long arr1 = 1, arr2 = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i =0; i<n; i++)
        {
            arr1 *= Integer.parseInt(st.nextToken());
        }
        m = Integer.parseInt(br.readLine());
        //arr2 = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i =0; i<m; i++)
        {
            arr2 *= Integer.parseInt(st.nextToken());
        }

        //long answer = 1;
        //boolean flag= false;

        long ret = gcd2(arr1, arr2);
        String str = String.valueOf(ret);
        int cnt = str.length();
        StringBuilder sb = new StringBuilder();

        if (ret / MOD > 0 )
        {
            while(cnt > 9)
                sb.append("0");
        }
        sb.append(ret);
        System.out.println(sb.toString());

    }
 
    static long gcd2(long p, long q) {
        if (q == 0) return p;
        return gcd2(q, p % q);
    }
}
