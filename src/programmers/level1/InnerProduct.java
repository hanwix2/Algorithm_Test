// 내적
// https://programmers.co.kr/learn/courses/30/lessons/70128

package programmers.level1;

public class InnerProduct {

    public static void main(String[] args) {
        InnerProduct test = new InnerProduct();

        System.out.println(test.solution(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2}));
        System.out.println(test.solution(new int[]{-1, 0, 1}, new int[]{1, 0, -1}));
    }

    public int solution(int[] a, int[] b) {

        int len = a.length;
        int answer = 0;

        for (int i = 0; i < len; i++) {
            answer += a[i] * b[i];
        }

        return answer;
    }

}
