import java.io.*;
import java.util.*;

public class b14719 {
    static int H,W;
    static int [] arr;
    static int sum = 0;
    static int left ,right;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        arr = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i =0; i< W; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
       
        for (int i =1; i< W - 1; i++) { //처음과 끝 제외!
            left = 0;
            right = 0;
            for (int j =0; j< i; j++) {
                left = Math.max(arr[j], left);
            }
            for (int j = i + 1; j<W; j++) {
                right = Math.max(arr[j],right);
            }
            if (arr[i] < left && arr[i] < right) sum += Math.min(left,right) - arr[i];    
        }

        System.out.println(sum);
    }
}
