package JavaGrammer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class javaGrammer {

    public static void main(String[] args) {
        stringGrammer();
        
        // String은 immutable이어서 mutable은 StringBuilder를 사용함!
        stringBuilderGrammer();
        listGrammer();
        // 정렬된 리스트에서 탐색 인덱스 주기
        collectionsGrammer();

        hashSetGrammer();
        // hash set - 중복 순서 안됨 linkedhashset - 중복 안되고 순서 보장 treeset - 정렬됨 중복 안됨

    }

    public static void stringGrammer() {
        String str = "apple";
        str.length();
        str.isEmpty();

        str.charAt(0); // 'a' 인덱스 범위 아니면 인덱스 범위 오류가 뜸
        str.indexOf("a"); // 맨 처음 이 단어 인덱스 반환 0 아니면 -1
        str.lastIndexOf("p"); // 

        str.substring(1,3); // pp
        str.substring(3);

        String str2 = str.replace("p", "z"); // 모든 p를 e로 바꿈
        // 없는 단어를 다른 단어로 바꾸려고 한다면 그때는 그냥 원 단어가 반환
        System.out.println(str2);

        String str3 = str.replaceAll(".", "/"); // 정규식임 .은 모든 단어
        System.out.println(str3);

        str.replaceFirst("a", "j");
        str.equals("apple");

        // str이란 다른 부분 문자열 빼기함!
        System.out.println(str.compareTo(str2)); // str 과 같으면 0 
        str.contains("a");

        String [] strArr = str.split(" ");
        System.out.println(strArr[0]);

        str.trim(); // 앞뒤 공백 제거
        Integer.parseInt("100"); // 숫자로 변환
        Integer.toString(100);
    }

    public static void stringBuilderGrammer() {
        StringBuilder sb = new StringBuilder();
        sb.append("apple");
        sb.append("b");
        sb.insert(2, "oo");
        System.out.println(sb.toString());

        sb.delete(0, 2);
        System.out.println(sb.toString());
        
        sb.deleteCharAt(2); // 특정 인덱스 문자 삭제
        System.out.println(sb.toString());

        sb.reverse();
        System.out.println(sb.toString());
        sb.setLength(2); // 절대 길이 줄이기 2전까지만 남음!
        System.out.println(sb.toString());

        sb.setLength(4);
        System.out.println(sb.toString()); // 뒤는 공백이다!
    }

    public static void listGrammer() {
        List<String> list = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        //String[] temp = {"apple", "banana", "lemon"};
        // asList는 immutable하게 반환하므로 값을 변경할 수가 없다
        //List<String>list3 = new ArrayList<>(Arrays.asList(temp));

        list.add("one");
        list.add(0, "z");
        System.out.println(list);

        list2.add("->two");
        list.addAll(list2);
        System.out.println(list);

        list.indexOf("zero"); //  -1 반환인줄 알았는데 z가 겹쳐서 삭제가되긴함
        list.remove(0);
        list.remove("one");
        System.out.println(list);

        list.removeAll(list2);
        System.out.println(list);
        list.clear();
        list.isEmpty();
        list.size();
        list.contains("one");
    }

    public static void collectionsGrammer() {
        Integer [] temp = {1,2,3,3,4,5,6};
        List<Integer> l = new ArrayList<>(Arrays.asList(temp));
        System.out.println(Collections.max(l));  // 숫자를 반환
        Collections.sort(l);
        Collections.sort(l, Collections.reverseOrder());
        System.out.println(l);

        Collections.reverse(l);
        System.out.println(l);
        System.out.println(Collections.frequency(l, 3)); // 원소 갯수 반환
    }

    public static void stackAndQueueGrammer() {
        Stack<Integer> stack = new Stack<>();
        Queue<Integer> que = new LinkedList<>();

        que.add(1); // 문제에서 예외 발생
        que.offer(2); // 문제상황에서 false리턴
        que.remove(); //  문제상황 즉 비어있을때 예외
        que.poll(); // 문제 상황 널 리턴
        que.clear();
        // 큐 앞부분 확인
        que.element(); // 문제 상황 예외
        que.peek(); //문제 상황 널리턴

        stack.push(1);
        stack.pop(); // 문제상황에서 예외 발생
        stack.clear();
        stack.size();
        stack.isEmpty();
        stack.contains(1);
        stack.peek(); 
    }

    public static void hashSetGrammer() {
        HashSet<Integer> hashSet = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();

        hashSet.add(1);
        hashSet.add(5);
        hashSet.add(6);
        hashSet.add(7);
        hashSet2.add(2);
        for(int item : hashSet) {
            System.out.print(item + ", ");
        }
        System.out.println();


        hashSet.remove(1); // 값이 1인거 삭제
        hashSet.removeAll(hashSet2); // 차집합 - 안겹치는것만 남기고 전부 삭제
        hashSet.retainAll(hashSet2); // 교집합

        for(int item : hashSet) {
            System.out.println(item);
        }
    }

    public static void hashMapGrammer() {
        HashMap<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "바나나");
        hashMap.put(2, "바나나2");

        hashMap.remove(1);
        hashMap.containsKey(2);
        hashMap.containsValue("바나나2");

        for (Integer key : hashMap.keySet()) {
            System.out.print(key + ", ");
        }
        System.out.println();

    }

}
