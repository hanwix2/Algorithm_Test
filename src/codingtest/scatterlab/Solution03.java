package codingtest.scatterlab;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution03 {

    public static void main(String[] args) {
        Solution03 test = new Solution03();

        System.out.println(test.solution(20, 36));
        System.out.println(test.solution(100, 83));
        System.out.println(test.solution(12, 10));
    }

    public int solution(int N, int M) {

        List<Integer> primeNumbers = new ArrayList<>();

        for (int num = 2; num <= N; num++) {
            checkPrime(primeNumbers, num);
        }

        int listLen = primeNumbers.size();

        Queue<Integer> queue = new LinkedList<>();

        int sum = 0;
        int cnt = 0;

        int idx = 0;

        while (idx < listLen) {

            if (sum < M) {
                int add = primeNumbers.get(idx);
                queue.offer(add);
                sum += add;
                idx++;
            }

            if (sum > M) {

                while (!queue.isEmpty() && sum > M) {
                    sum -= queue.poll();
                }
            }

            if (sum == M) {
                cnt++;
                sum -= queue.poll();
            }
        }

        return cnt;
    }

    private void checkPrime(List<Integer> primeNumbers, int num) {
        if (num == 2) {
            primeNumbers.add(num);
            return;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return;
            }
        }

        primeNumbers.add(num);
    }
}
