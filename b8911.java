import java.io.*;

/*
 F -> 앞
 B -> 뒤
 L ,R -> 회전
 가장 작은 직사각형 구하기
 한줄로만 계속 간다면 넓이는 0!

 배열을 그릴 필요가 없는 문제!
 가로 세로 구해서 계산해주면 될듯? 이때 가로나 세로가 0이면 걍 넓이는 0

 걍 모든 경우의 수를 계산해주면되는 문제긴하네

 지나온 구간들도 계산해주긴하네

 */

public class b8911 {
    static char []s;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int up = 0;
        int right = 0;
        for (int k = 0; k < T; k++) {
            s = br.readLine().toCharArray();
            up = 0;
            right = 0;
            int maxUp = 0;
            int maxLeft = 0;

            int dir = 1; // 1 2 3 4 (1이 위 2가 아래 3이 오른 4가 왼쪽)

            for (int i = 0; i< s.length; i++) {
                char word = s[i];
                if (dir == 1) {
                    if (word == 'F') {
                        up +=1;
                    }
                    else if (word == 'B') {
                        up -=1;
                    }
                    else if (word == 'L') {
                        dir = 3;
                    }
                     else if (word == 'R') {
                        dir = 4;
                    }
                }
                else if (dir == 2) {
                    if (word == 'F') {
                        up -=1;
                    }
                    else if (word == 'B') {
                        up += 1;
                    }
                    else if (word == 'L') {
                        dir = 4;
                    }
                     else if (word == 'R') {
                        dir = 3;
                    }
                }
                else if (dir == 3) {
                    if (word == 'F') {
                        right +=1;
                    }
                    else if (word == 'B') {
                        right -= 1;
                    }
                    else if (word == 'L') {
                        dir = 2;
                    }
                     else if (word == 'R') {
                        dir = 1;
                    }
                }
                else if (dir == 4) {
                    if (word == 'F') {
                        right -= 1;
                    }
                    else if (word == 'B') {
                        right += 1;
                    }
                    else if (word == 'L') {
                        dir = 1;
                    }
                     else if (word == 'R') {
                        dir = 2;
                    }
                }  

                if (right < 0) {
                    maxLeft = Math.max(maxLeft, -right);
                }
                else {
                    maxLeft = Math.max(maxLeft, right);
                }
               
               if (up < 0) {
                    maxUp = Math.max(maxUp, -up);
                }
                else {
                    maxUp = Math.max(maxUp, up);
                }
            }
           
            System.out.println(maxUp * maxLeft);
        }
    } 
}
