// 음양 더하기
// https://programmers.co.kr/learn/courses/30/lessons/76501

package programmers.level1;

public class NegativeAndPositiveAdding {

    public static void main(String[] args) {

        NegativeAndPositiveAdding test = new NegativeAndPositiveAdding();

        System.out.println(test.solution(new int[]{4, 7, 12}, new boolean[]{true, false, true}));
        System.out.println(test.solution(new int[]{1, 2, 3}, new boolean[]{false, false, true}));
    }

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        int len = absolutes.length;

        for (int i = 0; i < len; i++) {
            if(signs[i])
                answer += absolutes[i];
            else
                answer -= absolutes[i];
        }

        return answer;
    }

}
