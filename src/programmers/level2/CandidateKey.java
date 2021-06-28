// 후보키
// https://programmers.co.kr/learn/courses/30/lessons/42890

package programmers.level2;

import java.util.*;

public class CandidateKey {

    public static void main(String[] args) {
        CandidateKey test = new CandidateKey();

        String[][] relation = {
                {"100", "ryan", "music", "2"},
                {"200", "apeach", "math", "2"},
                {"300", "tube", "computer", "3"},
                {"400", "con", "computer", "4"},
                {"500", "muzi", "music", "3"},
                {"600", "apeach", "music", "2"}};

        System.out.println(test.solution(relation));

    }

    List<int[]> combs = new ArrayList<>();

    public int solution(String[][] relation) {

        int col = relation[0].length;

        for (int total = 1; total <= col; total++) {
            int[] indexes = new int[col];
            combination(0, 0, total, col, indexes);
        }

        List<int[]> keys = new ArrayList<>();

        for (int[] comb : combs) {
            checkUniqueness(comb, keys, relation);
        }

        return keys.size();
    }

    private void checkUniqueness(int[] comb, List<int[]> keys, String[][] relation) {

        if (notMinimal(comb, keys))
            return;

        Map<String, Integer> map = new HashMap<>();

        int combLen = comb.length;

        for (String[] strings : relation) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < combLen; i++) {
                if (comb[i] == 1)
                    sb.append(strings[i]);
            }

            String str = sb.toString();

            if (map.containsKey(str))
                return;

            map.put(str, 1);
        }

        keys.add(comb);
    }

    private boolean notMinimal(int[] comb, List<int[]> keys) {

        for (int[] key : keys) {
            int len = key.length;

            for (int i = 0; i < len; i++) {
                if (key[i] == 1 && comb[i] == 0)
                    break;

                if (i == len - 1)
                    return true;
            }

        }

        return false;
    }

    private void combination(int i, int cnt, int total, int col, int[] indexes) {

        if (cnt == total) {
            combs.add(indexes.clone());
            return;
        }

        if (i >= col) {
            return;
        }

        indexes[i] = 1;
        combination(i + 1, cnt + 1, total, col, indexes);

        indexes[i] = 0;
        combination(i + 1, cnt, total, col, indexes);
    }

}
