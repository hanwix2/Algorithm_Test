package codingtest.scatterlab;

public class Solution02 {

    public static void main(String[] args) {

        Solution02 test = new Solution02();

        System.out.println(test.solution(30.0, 1.0, 2.0));  //1.0
        System.out.println(test.solution(30.0, 2.0, 100.0));  // 39.166667
        System.out.println(test.solution(30.5, 3.14159, 1999.1999));  // 63.968001
        System.out.println(test.solution(500.0, 4.0, 2000.0));  // 526.190476
    }

    public double solution(double C, double F, double X) {

        double answer = Double.MAX_VALUE;

        double employeeNum = 0.0;

        while (true) {
            double worker = 0.0;

            double time1 = 0.0;

            while (worker < employeeNum) {
                time1 += C / (2.0 + F * worker);
                worker++;
            }

            double time = time1 + (X / (2.0 + F * employeeNum));

            if (answer > time) {
                answer = time;
            } else {
                break;
            }

            employeeNum++;
        }

        return Math.round(answer * 1000000) / 1000000.0;
    }
}
