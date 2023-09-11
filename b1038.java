import java.io.*;
import java.util.*;

/*
바로 나눠서 확인하는게 아니라 dfs를 사용해서 깊이 탐색하게 하자!
0-9까지 만들수있는 방법 1024개 -> 2의 10승! -> -1해줘야함 공집합!
겹치지 않게 만드는 방법이 그거임! 



 20 21 30 31 32 40 41 42 43
 만들수 있는 수들을 반복문으로 만들기!
 */

public class b1038{
    static int N;
    static ArrayList<Long> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();

        if ( N <= 10) {
            System.out.println(N);
        }
        else if (N >= 1023) {
            System.out.println(-1);
        }
        else {
            for (int i = 0; i< 10; i++) {
                bp(i);
            }
            Collections.sort(list);
            System.out.println(list.get(N));
        }
    }
    private static void bp(long num) {
        // 
        list.add(num);
       long modValue = num % 10; // 맨 끝이 0이면 그냥 끝! 왜냐면 더 작은 수가 없다!
       // 
       if (modValue == 0) {
        return;
       }

       for (long i = modValue - 1; i >= 0; i--) {
        long newValue = num * 10 + i;
        bp(newValue);
       }
    }

}
