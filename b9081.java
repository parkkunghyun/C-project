import java.io.*;

public class b9081 {
    static int T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
        T = Integer.parseInt(br.readLine());
        for (int i = 0; i< T; i++) {
            String word;
            word = br.readLine();
            boolean visited[] = new boolean[word.length()];
            if (i == T - 1) {
                System.out.println(word);
            }
            else {
                dfs(0,visited, "", word);
            }
        }
    }

    private static void dfs(int depth,boolean[] visited ,String sb, String answer) {
        if (depth == answer.length()) {
            if (answer.compareTo(sb) != 0) {
                System.out.println(sb.toString());
            }
            return ;
        }
        
        for (int i =depth; i< answer.length(); i++) {
            if (visited[i] == false) {
                sb = sb + answer.charAt(i);
                visited[i] = true;
                dfs(depth+1, visited, sb, answer );
            }
        }
    }
}
