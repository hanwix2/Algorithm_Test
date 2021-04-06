// 2016년
// https://programmers.co.kr/learn/courses/30/lessons/12901?language=java

package programmers.level1;

public class YearOf2016 {

    public static void main(String[] args) {
        YearOf2016 test = new YearOf2016();

        System.out.println(test.solution(5, 24));
    }

    public String solution(int a, int b) {

        String[] days = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};

        int[] monthlyDates = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int totalDays = 0;

        for (int i = 0; i < a - 1; i++)
            totalDays += monthlyDates[i];

        totalDays += b;

        return days[(totalDays - 1) % 7];
    }

}
