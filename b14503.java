import java.io.*;
import java.util.*;

public class b14503 {
    static int N,M;
    static int map[][];
    static int clean[][];
    static int nowX,nowY,direction;

    public static void clean_method()
    {
        map[nowX][nowY] = 1;
        clean_explore();
        
    }
    public static int all_side_check()
    {
        if ((map[nowX - 1][nowY] == 1 || clean[nowX - 1][nowY] == 1) &&
        (map[nowX + 1][nowY] == 1 || clean[nowX + 1][nowY] == 1) &&
        (map[nowX][nowY - 1] == 1 || clean[nowX][nowY - 1] == 1) &&
        (map[nowX][nowY + 1] == 1 || clean[nowX][nowY + 1] == 1) )
        {
            return 1;
        }
        return 0;

    }
    public static int clean_check()
    {
        int cnt = 0;
        for (int i =0; i< N; i++)
        {
            for (int j =0; j< M; j++)
            {
                if (clean[i][j] == 1)
                    cnt++;
            }
        }
        return cnt;
    }

    public static void clean_explore()
    {
        switch(direction)
        {
            case 0:
                if (all_side_check() == 0)
                {
                    if (map[nowX + 1][nowY] != 1)
                    {
                        nowX++;
                        clean_explore();
                        return ;
                    }
                    return ;
                }
                direction = 3;
                if (map[nowX][nowY - 1] != 1 && clean[nowX][nowY - 1] == 0)
                {
                    nowY--;
                    clean_method();
                    return;
                }
                else
                {   
                    clean_explore();
                    return ;
                }
            case 1:
                if (all_side_check() == 0)
                {
                    if (map[nowX][nowY - 1] != 1)
                    {
                        nowY--;
                        clean_explore();
                        return ;
                    }
                    else
                        return ;
                }
                direction = 0;
                if (map[nowX + 1][nowY] != 1 && clean[nowX + 1][nowY - 1] == 0)
                {
                    nowX++;
                    clean_method();
                    return;
                }
                else
                {   
                    clean_explore();
                    return ;
                }
            case 2:
                if (all_side_check() == 0)
                {
                    if (map[nowX - 1][nowY] != 1)
                    {
                        nowX--;
                        clean_explore();
                        return ;
                    }
                    else
                        return ;
                }
                direction = 1;
                if (map[nowX][nowY + 1] != 1 && clean[nowX][nowY + 1] == 0)
                {
                    nowY++;
                    clean_method();
                    return;
                }
                else
                {   
                    clean_explore();
                    return ;
                }

            case 3:
                 if (all_side_check() == 0)
                {
                    if (map[nowX][nowY + 1] != 1)
                    {
                        nowY++;
                        clean_explore();
                        return ;
                    }
                    else
                        return ;
                }
                direction = 2;
                if (map[nowX - 1][nowY] != 1 && clean[nowX - 1][nowY - 1] == 0)
                {
                    nowX--;
                    clean_method();
                    return;
                }
                else
                {   
                    clean_explore();
                    return ;
                }
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        nowX = Integer.parseInt(st.nextToken());
        nowY = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        clean = new int[N][M];

        for (int i =0; i< N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for (int j =0; j<M; j++)
            {
                map[i][j] = Integer.parseInt(st.nextToken());
                clean[i][j] = 0;
            }
        }

        clean_method();
        int cnt = clean_check();

        System.out.println(cnt);
        
        //bw.write(String.valueOf(clean_check() + "\n"));

        //bw.flush();
        //bw.close();
    }
}
