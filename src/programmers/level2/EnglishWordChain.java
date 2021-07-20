// 영어 끝말잇기
// https://programmers.co.kr/learn/courses/30/lessons/12981

package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class EnglishWordChain {

    public static void main(String[] args) {
        EnglishWordChain test = new EnglishWordChain();

        String[] words1 = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        String[] words2 = {"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"};
        String[] words3 = {"hello", "one", "even", "never", "now", "world", "draw"};

        System.out.println(Arrays.toString(test.solution(3, words1)));
        System.out.println(Arrays.toString(test.solution(5, words2)));
        System.out.println(Arrays.toString(test.solution(2, words3)));
    }

    public int[] solution(int n, String[] words) {

        int len = words.length;

        Map<String, Integer> wordMap = new HashMap<>();

        char preChar = words[0].charAt(0);

        for (int i = 0; i < len; i++) {
            int wordLen = words[i].length();

            if (wordLen == 1 || preChar != words[i].charAt(0) || wordMap.containsKey(words[i])) {
                return new int[]{i % n + 1, i / n + 1};
            }

            wordMap.put(words[i], 1);
            preChar = words[i].charAt(wordLen - 1);
        }

        return new int[]{0, 0};
    }

}
