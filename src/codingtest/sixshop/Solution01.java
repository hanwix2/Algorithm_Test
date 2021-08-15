package codingtest.sixshop;

import java.util.LinkedList;
import java.util.Queue;

public class Solution01 {

    public static void main(String[] args) {
        Solution01 test = new Solution01();

        int[] estimate1 = {5, 1, 9, 8, 10, 5};
        int[] estimate2 = {10, 1, 10, 1, 1, 4, 3, 10};

        System.out.println(test.solution(estimate1, 3));
        System.out.println(test.solution(estimate2, 6));
    }

    public int solution(int[] estimates, int k) {

        int len = estimates.length;

        int answer = 0;
        int sum = 0;

        Queue<Integer> queue = new LinkedList<>();

        int idx = 0;

        while (idx < len) {

            if (queue.size() < k) {
                int add = estimates[idx++];
                queue.offer(add);
                sum += add;
            }

            if (!queue.isEmpty() && queue.size() == k) {
                answer = Math.max(answer, sum);
                sum -= queue.poll();
            }
        }

        return answer;
    }
}
