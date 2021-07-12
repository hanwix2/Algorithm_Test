// 숫자 문자열과 영단어
// https://programmers.co.kr/learn/courses/30/lessons/81301

package programmers.level1;

public class NumStringAndEngWord {

    public static void main(String[] args) {
        NumStringAndEngWord test = new NumStringAndEngWord();

        System.out.println(test.solution("one4seveneight"));
        System.out.println(test.solution("23four5six7"));
        System.out.println(test.solution("2three45sixseven"));
        System.out.println(test.solution("123"));
    }

    public int solution(String s) {

        String[] nums = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        for (int i = 0; i < 10; i++) {
            s = s.replaceAll(words[i], nums[i]);
        }

        return Integer.parseInt(s);
    }

}
