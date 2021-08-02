// https://programmers.co.kr/learn/courses/30/lessons/82612

package programmers.level1;

public class WeeklyChallenge01 {

    public static void main(String[] args) {
        WeeklyChallenge01 test = new WeeklyChallenge01();

        System.out.println(test.solution(3, 20, 4));
    }

    public long solution(int price, int money, int count) {

        long moneyNeed = 0;

        for (int times = 1; times <= count; times++) {
            moneyNeed += price * times;
        }

        long insufficient = moneyNeed - money;

        return insufficient > 0 ? insufficient : 0;
    }

}
