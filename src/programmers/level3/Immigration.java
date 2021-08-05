// 입국심사
// https://programmers.co.kr/learn/courses/30/lessons/43238

package programmers.level3;

import java.util.Arrays;

public class Immigration {

    public static void main(String[] args) {

        Immigration test = new Immigration();

        System.out.println(test.solution(6, new int[]{7, 10}));

    }

    public long solution(int n, int[] times) {

        Arrays.sort(times);

        int len = times.length;

        long min = 1;
        long max = (long) times[len - 1] * (long) n;

        long answer = max;

        while (min <= max) {

            long mid = (max + min) / 2;

            long throughput = 0;

            for (int time : times) {
                throughput += mid / time;
            }

            if (throughput >= n) {
                max = mid - 1;

                if (mid < answer) {
                    answer = mid;
                }
            } else {
                min = mid + 1;
            }
        }

        return answer;
    }

}
