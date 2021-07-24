// 콜라츠 추측
// https://programmers.co.kr/learn/courses/30/lessons/12943

package programmers.level1;

public class CollatzConjecture {

    public static void main(String[] args) {
        CollatzConjecture test = new CollatzConjecture();

        System.out.println(test.solution(6));
        System.out.println(test.solution(16));
        System.out.println(test.solution(626331));
    }

    public int solution(int num) {

        int cnt = 0;
        long number = num;

        while (number != 1) {
            if (cnt >= 500)
                return -1;

            number = number % 2 == 0 ? number / 2 : number * 3 + 1;

            cnt++;
        }

        return cnt;
    }

}
