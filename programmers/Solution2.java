package programmers;

import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {
        
    }
     public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = new StringBuilder(s);
            String subString = sb.substring(0,i);
            sb.delete(0,i);
            sb.append(subString);
            //System.out.println(sb.toString());
            if (rightString(sb.toString())) answer++;
        }
        
        return answer;
    }
    // [] {} ()
    private boolean rightString(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i <s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                if (c == ')' || c == '}' || c == ']') return false;
                else stack.push(c);
            } else {
                if (c == '(' || c == '{' || c =='[') stack.push(c);
                else {
                    if (stack.peek() == '(' && c == ')') stack.pop();
                    else if (stack.peek() == '{' && c == '}') stack.pop();
                    else if (stack.peek() == '[' && c == ']') stack.pop();
                    else return false;
                }
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
