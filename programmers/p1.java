package programmers;

/*
 모든 직선쌍에 대한 반복을 통해 -> 정수인 교점 좌표만 구해야함
 저장된 정수들 중에 x,y좌표 최고 최저를 각각 찾기
 최솟값 최댓값을 통해 2차원 배열 작성하기
 2차원 배열에 별 표시

maxy = 4 -
maxX = 4
minY = -4
minX = -4 - 

 해결법
  좌표 문제가 나왔을때 Point라는 클래스를 만들어주자

  데이터를 나타내는 클래스이므로 final을 사용해서 불변성을 갖게 해주기
  생성자로 초기화도! 추가로 x,y범위가 나오지 않았기에 혹시 몰라 long으로 표현

double에서 정수일때만을 찾는다면 1로 나눴을때 나머지가 0이어야한다! -> 소수점이 있으면 아래 소수가 너머지로 나옴
 */

 /*
  삼각달팽이

  n n 2차원 배열로 선언
  숫자를 채울 현재 위치를 0,0으로 설정
  방향에 따라 이동 못할때 까지 숫자 채우기
    - 아래로 이동하면서 숫자
    - 오른쪽으로 이동하면서 숫자
    - 왼쪽 위로 이동하면서 숫자
  다시 1차원에 넣기
  */

  // 각 더한것만큼 개수를 구하려면 반복문을 쓰지 말고 (n - 1) * n / 2를 사용하자!
  // 

public class p1 {
    public static int[][] solution(int[][] arr1, int[][] arr2) {
        
        int[][] answer = new int[arr1.length][arr2[0].length];
        //System.out.println(arr1.length * arr2[0].length);
        System.out.println(arr2[1][0]);
        arr2[1][0] = 3;
        int aIdx = 0;
        int aIdx2 = 0;
        
        for (int i = 0; i < arr1.length; i++) {
            for (int k = 0; k < arr2[0].length; k++) {
                int temp = 0;
                for (int j = 0; j < arr2.length; j++) {
                   temp += arr1[i][j] * arr2[j][k];
                }
                answer[aIdx][aIdx2] = temp;
                aIdx2++;
            }
            aIdx2 = 0;
            aIdx++;
        }
        return answer;
    }

     public static void main(String[] args) {
        int [][] arr1 = new int[3][2];
        int [][] arr2 = new int[2][2];

        arr1[0][0] = 1;
        arr1[0][1] = 4;
        arr1[1][0] = 3;
        arr1[1][1] = 2;
        arr1[2][0] = 4;
        arr1[2][1] = 1;

        arr2[0][0] = 3;
        arr2[0][1] = 3;
        arr2[0][0] = 3;
        arr2[1][1] = 3;

       //solution(arr1, arr2);
        char a = 'a';
        System.out.println(a == 'a');
       String p = "p00p";
       char [] arr3 = new char[4];
       for (int i = 0; i < 4; i++) {
        arr3[i] = p.charAt(i);
       }
       System.out.println(arr3);

    }
}