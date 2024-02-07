package programmers;

import java.util.HashMap;

public class Solution {
   
    // 가장 빠르게 그 언어가 나오는 위치를 찾아보기
    // 
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> keypad = new HashMap<>();

        for (int i = 0; i<keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char cur = keymap[i].charAt(j);
                if (keypad.containsKey(cur)) {
                    int idx = keypad.get(cur);
                    keypad.put(cur, Math.min(j + 1, idx));
                } else {
                    keypad.put(cur, j + 1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int count = 0;
            boolean flag = true;
            for (char cur : target.toCharArray()) {
                if (keypad.containsKey(cur)) {
                    count += keypad.get(cur);
                }else {
                    flag = false;
                    break;
                }
            }

            answer[i] = flag ? count : -1;
        }
        
        
        return answer;
    }
    
}
