import java.io.*;
import java.util.*;

public class b3085 {
    static int N;
    static char board[][];
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i< N; i++) {
            String s = br.readLine();
            for (int j = 0; j< N; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        // 확인하는 함수만 따로 만들자
        
        // 가로 확인 -> row
        for (int i = 0; i< N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] != board[i][j + 1]) {
                    char temp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;

                    check();

                    temp = board[i][j];
                    board[i][j] = board[i][j + 1];
                    board[i][j + 1] = temp;
                }
            }
        }
        // 세로 확인 -> column

        for (int i = 0; i< N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (board[j][i] != board[j + 1][i]) {
                    char temp = board[j][i];
                    board[j][i] = board[j + 1][i];
                    board[j + 1][i] = temp;

                    check();

                    temp = board[j][i];
                    board[j][i] = board[j + 1][i];
                    board[j + 1][i] = temp;
                }
            }
        }

        System.out.println(max);

    }

    private static void check() {
        // 
        
        int sum = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j< N - 1; j++) {
                if (board[i][j] == board[i][j + 1]) {
                   sum++;
                    max = Math.max(max, sum);
                }
                else {
                    sum = 1;
                }
            }
            
            sum = 1;
        }

        sum = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j< N - 1; j++) {
                if (board[j][i] == board[j + 1][i]) {
                    sum++;
                    max = Math.max(max, sum);
                }
                else{
                    sum = 1;
                }
            }
            sum = 1;
        }
    }
}
