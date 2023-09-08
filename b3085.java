import java.io.*;

public class b3085 {
    static int N;
    static char board[][];
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i< N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = s.charAt(j);
            }
        }

        // 행
        for (int i = 0; i<N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (board[i][j] != board[i][j + 1]) {
                    System.out.println("ddddddd  "+ i +"  "+ j);
                    changeBoardX(i,j);
                }
            }
        }

        // 열
        for (int i = 0; i<N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (board[j][i] != board[j + 1][i]) {
                    System.out.println("f  "+ j +"  "+ i);
                    changeBoardY(j,i);
                }
            }
        }

        System.out.println(max);
    }

    static void changeBoardX(int y, int x) {
        char copyBoard[][] = board.clone();
        char temp;
        temp = copyBoard[y][x];
        copyBoard[y][x] = copyBoard[y][x + 1];
        copyBoard[y][x + 1] = temp;

        countBoard(copyBoard);
    }

    static void changeBoardY(int y, int x) {
        char copyBoard[][] = board.clone();
        char temp;
        temp = copyBoard[y][x];
        copyBoard[y][x] = copyBoard[y + 1][x];
        copyBoard[y + 1][x] = temp;

        countBoard(copyBoard);
    }

    static void countBoard(char [][] copyBoard) {
        int count = 0;

        // 열 계산 
        for (int i = 0; i < N; i++) {
            for (int j = 0; j<N - 1; j++) {
                if (copyBoard[i][j] == copyBoard[i][j + 1]) {
                    count++;
                }else {
                    if (count > max) {
                        max = count;
                    }
                    count = 0;
                    break;
                }
            }
            if (count > max) {
                max = count;
            }
            count = 0;
        }


        count = 0;
        // 행 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j< N - 1; j++) {
                if (copyBoard[j][i] == copyBoard[j + 1][i]) {
                    count++;
                }else {
                    if (count > max) {
                        max = count;
                    }
                    count = 0;
                    break;
                }
            }
            if (count > max) {
                max = count;
            }
            count = 0;
        }
    }
}
