import java.io.*;

/*
 7331
 N이 주어졌을때 소수 찾기 -> 이거 다 찾아봐야함?

근데 생각해보면  모든애들을 다하는게 아니라!  2 3 5 7 로만 이뤄줘야하는거 아님?
맨 앞자리가 2일때  맨 앞자리가 3일때  ~ 4 ** (N)
맨 앞자리가 5일때 ~ 6 ** (N)
맨 앞자리가 7일때 ~ 8 ** (N)
 */

public class b2023 {
    
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        getResult(0,N);
        System.out.println(sb);
        
    }
    private static void getResult(int output, int n) {
        if (n == 0) {
            if (isPrime(output)) {
                sb.append(output).append("\n");
            }
            return;
        }

        for (int i = 0; i< 10; i++) {
         int next = output * 10 + i;
         if (isPrime(next)) {
            getResult(next, n - 1);
         }   
        }
    }
   private static boolean isPrime(int num) {
    if (num < 2) return false;

    for (int i = 2; i<= Math.sqrt(num); i++) {
        if (num % i == 0) {
            return false;
        }
    }
    return true;
   }
    
}
