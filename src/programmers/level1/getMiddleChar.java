// 가운데 글자 가져오기
// https://programmers.co.kr/learn/courses/30/lessons/12903

package programmers.level1;

public class getMiddleChar {

    public static void main(String[] args) {

        getMiddleChar test = new getMiddleChar();

        System.out.println(test.solution("abcde"));
        System.out.println(test.solution("qwer"));

    }

    public String solution(String s) {
        int len = s.length();
        int mid = len / 2;

        if (len % 2 == 0) {
            return s.substring(mid - 1, mid + 1);
        } else {
            return String.valueOf(s.charAt(mid));
        }
    }

}
