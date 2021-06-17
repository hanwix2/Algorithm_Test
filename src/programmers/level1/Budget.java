// 예산
// https://programmers.co.kr/learn/courses/30/lessons/12982

package programmers.level1;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Budget {

    public static void main(String[] args) {
        Budget test = new Budget();

        System.out.println(test.solution(new int[]{1, 3, 2, 5, 4}, 9));
        System.out.println(test.solution(new int[]{2, 2, 3, 3}, 10));
    }

    public int solution(int[] d, int budget) {

        int answer = 0;

        List<Integer> teams = new ArrayList<>();
        Arrays.stream(d).forEach(teams::add);
        Collections.sort(teams);

        for (int team : teams) {
            budget -= team;

            if (budget < 0)
                return answer;

            answer++;
        }


        return answer;
    }

}
