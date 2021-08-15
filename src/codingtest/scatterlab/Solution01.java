package codingtest.scatterlab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution01 {

    public static void main(String[] args) {

        Solution01 test = new Solution01();

        int[][] data1 = {{1, 0, 11}, {3, 1, 15}, {2, 0, 16}, {4, 0, 17}, {2, 0, 15}, {2, 1, 14}, {2, 0, 12}};
        int[][] data2 = {{4, 0, 12}, {1, 0, 16}, {3, 0, 18}, {3, 0, 17}, {2, 0, 15}, {3, 2, 22}, {2, 1, 17}};

        System.out.println(Arrays.toString(test.solution(data1)));
        System.out.println(Arrays.toString(test.solution(data2)));
    }

    public int[] solution(int[][] data) {

        List<DateDay> dateList = new ArrayList<>();

        for (int day = 0; day < 7; day++) {
            dateList.add(new DateDay(day, data[day][0], data[day][1], data[day][2]));
        }

        Collections.sort(dateList);

        int bestDay = dateList.get(0).getDay();

        DateDay worstDateDay = dateList.get(6);
        int worstDay = worstDateDay.getDay();

        if (worstDateDay.getSkyState() != 4 && worstDateDay.getRainFallState() != 1
                && worstDateDay.getTemperature() > 0 && worstDateDay.getTemperature() < 30) {
            worstDay = -1;
        }

        return new int[]{bestDay, worstDay};
    }

    public static class DateDay implements Comparable<DateDay> {

        private final int day;
        private final int skyState;
        private final int rainFallState;
        private final int temperature;

        private int dayPriority;
        private int tempScore;
        private int weatherScore;
        private int totalScore;

        public DateDay(int day, int skyState, int rainFallState, int temperature) {
            this.day = day;
            this.skyState = skyState;
            this.rainFallState = rainFallState;
            this.temperature = temperature;

            computeScores();
            setDayPriority();
        }

        private void computeScores() {
            computeTempScore();
            computeWeatherScore();
            totalScore = tempScore + weatherScore;
        }

        private void computeTempScore() {
            tempScore = 20 - Math.abs(22 - temperature);
        }

        private void computeWeatherScore() {
            // 강수 상태
            if (rainFallState == 1) { // 비
                weatherScore = 5;
            } else if (rainFallState == 2) { // 눈
                weatherScore = 14;
            } else {
                // 하늘 상태 (강수상태 == 0)
                if (skyState == 1 || skyState == 2) { // 맑음 또는 구름 조금
                    weatherScore = 20;
                } else if (skyState == 3) { // 구름 많음
                    weatherScore = 17;
                } else { // 흐림
                    weatherScore = 10;
                }
            }
        }

        private void setDayPriority() {
            // 요일 우선권 순서: 토(1), 금(2), 일(3), 수(4), 목(5), 화(6), 월(7)
            switch (day) {
                case 0 -> dayPriority = 7;  // 월
                case 1 -> dayPriority = 6;  // 화
                case 2 -> dayPriority = 4;  // 수
                case 3 -> dayPriority = 5;  // 목
                case 4 -> dayPriority = 2;  // 금
                case 5 -> dayPriority = 1;  // 토
                default -> dayPriority = 3; // 일
            }
        }

        @Override
        public int compareTo(DateDay o) {
            if (o.totalScore == this.totalScore) {
                return Integer.compare(this.dayPriority, o.dayPriority);
            }
            return Integer.compare(o.totalScore, this.totalScore);
        }

        public int getDay() {
            return day;
        }

        public int getSkyState() {
            return skyState;
        }

        public int getRainFallState() {
            return rainFallState;
        }

        public int getTemperature() {
            return temperature;
        }
    }

}
