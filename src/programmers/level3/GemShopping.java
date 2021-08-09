// 보석 쇼핑
// https://programmers.co.kr/learn/courses/30/lessons/67258

package programmers.level3;

import java.util.*;

public class GemShopping {

    public static void main(String[] args) {

        GemShopping test = new GemShopping();

        String[] gems1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] gems2 = {"AA", "AB", "AC", "AA", "AC"};
        String[] gems3 = {"XYZ", "XYZ", "XYZ"};
        String[] gems4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};

        System.out.println(Arrays.toString(test.solution(gems1)));
        System.out.println(Arrays.toString(test.solution(gems2)));
        System.out.println(Arrays.toString(test.solution(gems3)));
        System.out.println(Arrays.toString(test.solution(gems4)));

    }

    public int[] solution(String[] gems) {

        Set<String> gemType = new HashSet<>(Arrays.asList(gems));

        Map<String, Integer> gemContainer = new HashMap<>();

        int len = gems.length;

        int shortest = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        int left = 0, right = 0;

        while (true) {

            if (gemContainer.size() == gemType.size()) {
                gemContainer.put(gems[left], gemContainer.get(gems[left]) - 1);

                if (gemContainer.get(gems[left]) == 0) {
                    gemContainer.remove(gems[left]);
                }

                left++;
            } else if (right == len) {
                break;
            } else {
                gemContainer.put(gems[right], gemContainer.getOrDefault(gems[right], 0) + 1);
                right++;
            }

            if (gemContainer.size() == gemType.size() && right - left < shortest) {
                start = left + 1;
                end = right;
                shortest = right - left;
            }
        }

        return new int[]{start, end};
    }

}
