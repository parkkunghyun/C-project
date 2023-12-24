package back;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class b18110 {
    public static void main(String [] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         Integer opinionCount = Integer.parseInt(br.readLine());

         
         
            List<Integer> difficulties = new ArrayList<>();
            for (int i = 0; i < opinionCount; i++) {
                difficulties.add(Integer.parseInt(br.readLine()));
            }
            Collections.sort(difficulties);
            //System.out.println(difficulties);
            // 일단은 함수 빼지 말고 해보기 - 리팩토링은 결과 맞고 하기
            double up15 = opinionCount * 0.15;
            int upRounds = (int) Math.round(up15);
            
            double sum = 0;
            for (int i = upRounds; i < opinionCount - upRounds; i++) {
                sum += difficulties.get(i);
            }
            sum = sum / (opinionCount - 2 * upRounds);
            System.out.println((int)Math.round(sum));
         }
}
