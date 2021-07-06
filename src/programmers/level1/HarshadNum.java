// 하샤드 수
// https://programmers.co.kr/learn/courses/30/lessons/12947

package programmers.level1;

public class HarshadNum {

    public static void main(String[] args) {

        HarshadNum test = new HarshadNum();

        System.out.println(test.solution(10));
        System.out.println(test.solution(12));
        System.out.println(test.solution(11));
        System.out.println(test.solution(13));
    }

    public boolean solution(int x) {
        return x % getValuesSum(x) == 0;
    }

    private int getValuesSum(int x) {
        int sum = 0;

        sum += x / 10000;
        sum += (x / 1000) % 10;
        sum += (x / 100) % 10;
        sum += (x / 10) % 10;
        sum += x % 10;

        return sum;
    }

}
