// 짝지어 제거하기
// https://programmers.co.kr/learn/courses/30/lessons/12973

package programmers.level2;

import java.util.Stack;

public class PairDeletion {

    public static void main(String[] args) {

        PairDeletion test = new PairDeletion();

        System.out.println(test.solution("baabaa"));
        System.out.println(test.solution("cdcd"));

    }

    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (!stack.empty() && stack.peek().equals(c))
                stack.pop();
            else
                stack.push(c);
        }

        return stack.empty() ? 1 : 0;
    }

}
