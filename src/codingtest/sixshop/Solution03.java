package codingtest.sixshop;

import java.util.*;

public class Solution03 {

    public static void main(String[] args) {
        Solution03 test = new Solution03();

        int[] coffee_times1 = {4, 2, 2, 5, 3};
        int[] coffee_times2 = {100, 1, 50, 1, 1};

        System.out.println(Arrays.toString(test.solution(3, coffee_times1)));
        System.out.println(Arrays.toString(test.solution(1, coffee_times2)));
    }

    public int[] solution(int N, int[] coffee_times) {

        List<Integer> answerList = new ArrayList<>();

        int len = coffee_times.length;
        int time = 0;
        int idx = 0;

        Queue<CoffeeOrder> pq = new PriorityQueue<>();

        while (idx < len) {

            if (pq.size() < N) {
                pq.offer(new CoffeeOrder(idx + 1, coffee_times[idx] + time));
                idx++;
            }

            if (pq.size() == N) {
                CoffeeOrder co = pq.poll();
                answerList.add(co.orderNum);
                time = co.makingTime;
            }

        }

        while (!pq.isEmpty()) {
            answerList.add(pq.poll().orderNum);
        }

        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

    public static class CoffeeOrder implements Comparable<CoffeeOrder> {

        private final int orderNum;
        private final int makingTime;

        public CoffeeOrder(int orderNum, int makingTime) {
            this.orderNum = orderNum;
            this.makingTime = makingTime;
        }

        @Override
        public int compareTo(CoffeeOrder o) {
            if (this.makingTime == o.makingTime) {
                return Integer.compare(this.orderNum, o.orderNum);
            }
            return Integer.compare(this.makingTime, o.makingTime);
        }
    }


}
