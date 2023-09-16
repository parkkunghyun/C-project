import java.io.*;

public class b3568 {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String in = br.readLine();
        String [] data = in.split(" ");
        for (int i = 1; i< data.length; i++) {
            getParam(data[0], data[i]);
        }
        System.out.println(sb.toString());
    }
    private static void getParam(String type, String str) {
        StringBuilder sym = new StringBuilder();
        String out  = "";
        for (int i = 0; i< str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == '*' || curr == '&') {
                sym.append(curr);
            }
            else if (curr == '[') {
                sym.append(']');
            }
            else if (curr == ']') {
                sym.append('[');
            }
            else if (('a' <= curr && curr <='z') || ('A' <= curr && curr <='Z')) {
                out += curr;
            }
        }
        sb.append(type + sym.reverse()+" " + out + ";\n");
    }
}
