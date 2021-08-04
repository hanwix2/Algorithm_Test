// 압축
// https://programmers.co.kr/learn/courses/30/lessons/17684

package programmers.level2;

import java.util.*;

public class Compression {

    public static void main(String[] args) {

        Compression test = new Compression();

        System.out.println(Arrays.toString(test.solution("KAKAO")));
        System.out.println(Arrays.toString(test.solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(test.solution("ABABABABABABABAB")));

    }

    public int[] solution(String msg) {

        List<Integer> answerList = new ArrayList<>();

        Map<String, Integer> dictionary = new HashMap<>();

        int dictIdx = 1;

        for (char alph = 'A'; alph <= 'Z'; alph++) {
            dictionary.put(String.valueOf(alph), dictIdx++);
        }

        int len = msg.length();

        loop:
        for (int i = 0; i < len; i++) {
            int dictNum = 0;
            StringBuilder sb = new StringBuilder();
            sb.append(msg.charAt(i));

            while (dictionary.containsKey(sb.toString())) {

                dictNum = dictionary.get(sb.toString());

                if (i == len - 1) {
                    answerList.add(dictNum);
                    break loop;
                }

                sb.append(msg.charAt(++i));
            }

            answerList.add(dictNum);
            dictionary.put(sb.toString(), dictIdx++);
            i--;
        }


        return answerList.stream().mapToInt(i -> i).toArray();
    }

}
