// 3진법 뒤집기
// https://programmers.co.kr/learn/courses/30/lessons/68935

package programmers.level1;

import java.util.LinkedList;
import java.util.Queue;

public class TernaryScaleFlip {

    public static void main(String[] args) {
        TernaryScaleFlip test = new TernaryScaleFlip();

        System.out.println(test.solution(45));
        System.out.println(test.solution(125));

    }

    public int solution(int n) {

        Queue<Integer> queue = new LinkedList<>();

        while (n != 0) {
            int mod = n % 3;
            n /= 3;

            queue.add(mod);
        }

        int answer = 0;

        while (!queue.isEmpty()) {
            answer += queue.poll() * Math.pow(3, queue.size());
        }

        return answer;
    }

}
