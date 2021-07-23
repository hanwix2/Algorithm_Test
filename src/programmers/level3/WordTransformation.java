// 단어 변환
// https://programmers.co.kr/learn/courses/30/lessons/43163

package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class WordTransformation {

    public static void main(String[] args) {
        WordTransformation test = new WordTransformation();

        String begin = "hit", target = "cog";
        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(test.solution(begin, target, words1));
        System.out.println(test.solution(begin, target, words2));
    }

    public int solution(String begin, String target, String[] words) {

        int len = words.length;

        boolean[] use = new boolean[len];

        Queue<Point> queue = new LinkedList<>();

        queue.add(new Point(begin, 0));

        while (!queue.isEmpty()) {

            Point point = queue.poll();

            if (point.word.equals(target))
                return point.cnt;

            for (int i = 0; i < len; i++) {
                if (!use[i] && transformable(point.word, words[i])) {
                    queue.add(new Point(words[i], point.cnt + 1));
                    use[i] = true;
                }
            }

        }

        return 0;
    }

    private boolean transformable(String begin, String target) {
        int len = begin.length();
        int diffCharNum = 0;

        for (int i = 0; i < len; i++) {
            if (begin.charAt(i) != target.charAt(i))
                diffCharNum++;
        }

        return diffCharNum == 1;
    }

    static class Point {
        String word;
        int cnt;

        public Point(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }
}
