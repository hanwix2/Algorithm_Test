// 로또의 최고 순위와 최저 순위
// https://programmers.co.kr/learn/courses/30/lessons/77484

package programmers.level1;

public class LottoHighAndLowRanking {

    public int[] solution(int[] lottos, int[] win_nums) {

        int zeroCnt = 0;
        int match = 0;

        for (int num : lottos) {
            if (num == 0) {
                zeroCnt++;
                continue;
            }

            if (matchNum(win_nums, num)) {
                match++;
            }
        }

        int low = 7 - match;
        int high = low - zeroCnt;

        low = Math.min(low, 6);
        high = Math.min(high, 6);

        return new int[]{high, low};
    }

    private boolean matchNum(int[] win_nums, int num) {
        for (int win_num : win_nums) {
            if (win_num == num)
                return true;
        }
        return false;
    }

}
