// JadenCase 문자열 만들기
// https://programmers.co.kr/learn/courses/30/lessons/12951
package programmers.level2;

public class MakeJadenCaseString {

    public static void main(String[] args) {
        MakeJadenCaseString test = new MakeJadenCaseString();

        String str1 = "3people unFollowed me";
        String str2 = "for the last week";

        System.out.println(test.solution(str1));
        System.out.println(test.solution(str2));
    }

    public String solution(String s) {
        int len = s.length();

        StringBuilder sb = new StringBuilder();

        char pre = ' ';

        for (int i = 0; i < len; i++) {
            char now = s.charAt(i);

            if ('a' <= now && now <= 'z' && pre == ' ') {
                now -= 32;
            } else if ('A' <= now && now <= 'Z' && pre != ' ') {
                now += 32;
            }

            sb.append(now);
            pre = now;
        }

        return sb.toString();
    }

}

/*
 * Tip!
 * - 공백이 연속해서 여러번 나타날 수 있다.
 * - 따라서 공백을 지우지 말 것
 */
