package codingtest.toss.next;

public class Solution06 {

    public static void main(String[] args) {
        Solution06 test = new Solution06();

        System.out.println(test.solution(4));
        System.out.println(test.solution(5));
    }

    public long solution(int numOfStairs) {

        long[] dp = new long[numOfStairs + 1];

        if (numOfStairs < 3) {
            return numOfStairs;
        } else if (numOfStairs == 3) {
            return 4;
        }

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= numOfStairs; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[numOfStairs];
    }
}
