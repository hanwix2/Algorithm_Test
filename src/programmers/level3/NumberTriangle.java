// 정수 삼각형
// https://programmers.co.kr/learn/courses/30/lessons/43105

package programmers.level3;

public class NumberTriangle {

    public static void main(String[] args) {
        NumberTriangle test = new NumberTriangle();

        int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};

        System.out.println(test.solution(triangle));
    }

    public int solution(int[][] triangle) {

        int len = triangle.length;
        int[][] dp = new int[len][];

        for (int i = 0; i < len; i++) {
            dp[i] = new int[i + 1];
        }

        dp[0][0] = triangle[0][0];

        for (int h = 1; h < len; h++) {
            for (int n = 0; n <= h; n++) {

                int amount = triangle[h][n];

                if (n == 0) {
                    amount += dp[h - 1][n];
                } else if (n == h) {
                    amount += dp[h - 1][n - 1];
                } else {
                    amount += Math.max(dp[h - 1][n - 1], dp[h - 1][n]);
                }

                dp[h][n] = amount;
            }
        }

        int answer = 0;

        for (int n = 0; n < len; n++) {
            answer = Math.max(answer, dp[len - 1][n]);
        }

        return answer;
    }

}
