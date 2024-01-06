package programmers;


public class p1 {

    // 정규식
    // [a,b,c] -> abc중 아무거나
    // [^abc] -> abc제외
    // [a-g]
    // a* - a 0개 이상
    // a+ -> a 1개 이상
    // a? -> a 0개 또는1개
    // a{5} - a 5개
    // a{2,} -> 2개 이상
    // a{2,4} -> 2개 이상 4개 이하
    // ab | cd - ab 또는 cd
    // ^a - 처음 문자가 a
    // a$ 마지막 문자 a
    // \. 은 그냥 .을 표현 
    // 

    // s.replaceAll(정규식, 바꿀문자)
    // s.split(정규식) - String[] 원본 문자열을 잘라서 반환
    // 
    
    public static boolean regularExpression(String s) {
        boolean sR = s.matches("[0-9]{3,4}");
        return sR;
    }
    public static void main(String[] args) {
        
        char a = 'a';
        System.out.println(a == 'a');
       String p = "p00p";
       char [] arr3 = new char[4];
       for (int i = 0; i < 4; i++) {
        arr3[i] = p.charAt(i);
       }
       System.out.println(arr3);
       String s = "dd";
       System.out.println(!s.equals("dd"));
       

    }
}