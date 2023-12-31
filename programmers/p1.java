package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 모든 직선쌍에 대한 반복을 통해 -> 정수인 교점 좌표만 구해야함
 저장된 정수들 중에 x,y좌표 최고 최저를 각각 찾기
 최솟값 최댓값을 통해 2차원 배열 작성하기
 2차원 배열에 별 표시


1,4 / -4,4 / -4,-4 / 1, -4 / 4. 0

0,4 
3,0 3,8
8,0 8,8


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

public class p1 {
     public static void main(String[] args) {
        System.out.println("hello");
    }

    private static class Point {
        public final long x, y;
        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    private static Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double)( (b1 * c2 - c1 * b2) / (a1 * b2 - b1 * a2));
        double y = (double)( (c1 * a2 - a1 * c2) / (a1 * b2 - b1 * a2));
        if (x % 1 != 0 || y % 1 != 0) return null;
        return new Point((long)x, (long)y);
    }

    private static Point getMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;

        for (Point p : points) {
            if (p.x < x) x = p.x;
            if (p.y < y) y = p.x;
        }
        // 각각에서 가장 작은 x y를 구해서 포인트로 반환시킴!
        return new Point(x, y);
    }

    private static Point getMaximumPoint(List<Point> points) {
         long x = Long.MIN_VALUE;
         long y = Long.MIN_VALUE;

        for (Point p : points) {
            if (p.x > x) x = p.x;
            if (p.y > y) y = p.x;
        }
        // 각각에서 가장 작은 x y를 구해서 포인트로 반환시킴!
        return new Point(x, y);
    }


    public static String[] solution(int[][] line) {
        String [] answer = {};
        List<Point> points = new ArrayList<>();

        // 모든 직선 쌍에 대한 반복
        for (int i = 0; i < line.length; i++) {
            for (int j = i + 1; j < line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][1], line[j][1], line[j][2]);
                if (intersection != null) {
                    points.add(intersection);
                }
            }
        }

        Point minimum = getMinimumPoint(points);
        Point maximum = getMaximumPoint(points);

        int width = (int)(maximum.x - minimum.x + 1);
        int height= (int)(maximum.y - minimum.y + 1);

        char [][] arr = new char[height][width];
        for (char [] row : arr) {
            Arrays.fill(row, '.');
        }

        for (Point p : points) {
            int x =  (int)(p.x - minimum.x);
            int y = (int)(maximum.y - p.y);
            arr[y][x] = '*';
        }

        String [] result = new String[height];
        for (int i = 0; i < result.length; i++) {
            result[i] = new String(arr[i]);
        }

        return result;
    }
}
