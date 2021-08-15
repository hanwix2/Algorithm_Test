package codingtest.kakao.mobility;

public class Problem02 {

    public static void main(String[] args) {
        Problem02 test = new Problem02();

        // 스킬트리

    }

    private int[] dp;
    private int answer;

    public int solution(int[] T, int[] A) {

        int total = T.length;

        dp = new int[total];
        dp[0] = 1;

        answer = 1;

        for (int skill : A) {

            if (dp[skill] == 0) {
                dp[skill] = trainNum(T, T[skill], 1);
            }

        }

        return answer;
    }

    private int trainNum(int[] T, int skill, int cnt) {
        if (dp[skill] != 0) {
            answer += cnt;
            return dp[skill];
        }

        dp[skill] = trainNum(T, T[skill], cnt + 1);
        return dp[skill];
    }

}
