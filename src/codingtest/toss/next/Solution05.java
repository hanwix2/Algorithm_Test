package codingtest.toss.next;

import java.util.*;

public class Solution05 {

    public static void main(String[] args) {
        Solution05 test = new Solution05();

        int[] fruitWeights = {30, 40, 10, 20, 30};
        System.out.println(Arrays.toString(test.solution(fruitWeights, 3)));

    }

    public int[] solution(int[] fruitWeights, int k) {

        Set<Integer> answerSet = new HashSet<>();

        TreeMap<Integer, Integer> inRange = new TreeMap<>();

        int n = fruitWeights.length;

        for (int i = 0; i < k; i++) {
            inRange.put(fruitWeights[i], inRange.getOrDefault(fruitWeights[i], 0) + 1);
        }

        answerSet.add(inRange.lastKey());

        for (int i = k; i < n; i++) {
            int left = i - k;

            if (inRange.get(fruitWeights[left]) == 1) {
                inRange.remove(fruitWeights[left]);
            } else {
                inRange.put(fruitWeights[left], inRange.get(fruitWeights[left]) - 1);
            }

            inRange.put(fruitWeights[i], inRange.getOrDefault(fruitWeights[i], 0) + 1);

            answerSet.add(inRange.lastKey());
        }

        List<Integer> answerList = new ArrayList<>(answerSet);

        answerList.sort(Collections.reverseOrder());

        int len = answerList.size();
        int[] answer = new int[len];

        for (int i = 0; i < len; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }

}
