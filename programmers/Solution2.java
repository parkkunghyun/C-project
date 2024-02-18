package programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution2 {
    // 2시 50분
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        
        for (int i=0; i<starts.length; i++) {
            int s = starts[i];
            int result = 0;
            int resultIdx = 0;
            
            for(int j = s; j <= e; j++) {
                int cnt = 0;
                if (j == 1) cnt = 1;
                else if (isNotPrime(j)) {
                    // 소수가 아니다 
                    cnt = abbreviation(j);
                } else {
                    cnt = 2;
                }
                if (result < cnt) {
                    result = cnt;
                    resultIdx = j;
                }
            }
            answer[i] = resultIdx;
        }
        return answer;
    }
    // 이건 정상 작동함!
    private boolean isNotPrime(int j) {
        boolean flag = false;
        for (int i = 2; i <= Math.sqrt(j); i++) {
            if (j % i == 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    private static int primeCount(int n) {
        int cnt = 0;
        for (int i = 1; i*i <= n; i++) {
            if (i*i == n) cnt++;
            else if (n % i == 0) cnt+=2;
        }
        return cnt;
    }
}