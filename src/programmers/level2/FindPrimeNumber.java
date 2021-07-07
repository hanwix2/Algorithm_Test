// 소수 찾기
// https://programmers.co.kr/learn/courses/30/lessons/42839

package programmers.level2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FindPrimeNumber {

    public static void main(String[] args) {
        FindPrimeNumber test = new FindPrimeNumber();

        System.out.println(test.solution("17"));
        System.out.println(test.solution("011"));
    }

    public int solution(String numbers) {

        int len = numbers.length();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = Integer.parseInt(String.valueOf(numbers.charAt(i)));
        }

        Set<Integer> permSet = new HashSet<>();
        boolean[] visit = new boolean[len];
        StringBuilder permSb = new StringBuilder();

        for (int r = 1; r <= len; r++) {
            permutation(permSet, permSb, arr, visit, len, r);
        }

        int answer = 0;

        for (Iterator<Integer> it = permSet.iterator(); it.hasNext(); ) {
            Integer num = it.next();

            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(int num) {
        if (num < 2)
            return false;

        int max = (int) Math.sqrt(num);

        for (int divide = 2; divide <= max; divide++) {
            if (num % divide == 0)
                return false;
        }
        return true;
    }

    private void permutation(Set<Integer> permSet, StringBuilder permSb, int[] arr, boolean[] visit, int n, int r) {

        int sbLen = permSb.length();

        if (sbLen == r) {
            permSet.add(Integer.parseInt(permSb.toString()));
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                permSb.append(arr[i]);
                permutation(permSet, permSb, arr, visit, n, r);
                permSb.delete(sbLen, sbLen + 1);
                visit[i] = false;
            }
        }
    }

}
