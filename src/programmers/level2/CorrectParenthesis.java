// 올바른 괄호
// https://programmers.co.kr/learn/courses/30/lessons/12909

package programmers.level2;

import java.util.Stack;

public class CorrectParenthesis {

    public static void main(String[] args) {

        CorrectParenthesis test = new CorrectParenthesis();

        String s1 = "()()";
        String s2 = "(())()";
        String s3 = ")()(";
        String s4 = "(()(";

        System.out.println(test.solution(s1));
        System.out.println(test.solution(s2));
        System.out.println(test.solution(s3));
        System.out.println(test.solution(s4));
    }

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        int len = s.length();

        for (int idx = 0; idx < len; idx++) {
            char c = s.charAt(idx);

            if (c == '(')
                stack.push(c);
            else {
                if (stack.isEmpty())
                    return false;
                else
                    stack.pop();
            }

        }

        return stack.isEmpty();
    }

}
