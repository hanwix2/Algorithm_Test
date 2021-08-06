// 숫자의 표현
// https://programmers.co.kr/learn/courses/30/lessons/12924

package programmers.level2;

public class ExpressionOfNumber {

    public static void main(String[] args) {
        ExpressionOfNumber test = new ExpressionOfNumber();

        System.out.println(test.solution(15));
    }

    public int solution(int n) {
        int answer = 1;

        int divide = 2;

        while ((n / divide) - (divide - 1) / 2 > 0) {
            int m = n % divide;

            if ((divide % 2 == 1 && m == 0) || (divide % 2 == 0 && m == divide / 2)) {
                answer++;
            }

            divide++;
        }

        return answer;
    }

}
