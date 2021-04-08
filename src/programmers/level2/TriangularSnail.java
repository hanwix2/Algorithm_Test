//삼각 달팽이
// https://programmers.co.kr/learn/courses/30/lessons/68645

package programmers.level2;

import java.util.Arrays;

public class TriangularSnail {

    public static void main(String[] args) {
        TriangularSnail test = new TriangularSnail();

        int n = 6;

        int[] answer = test.solution(n);

        System.out.println(Arrays.toString(answer));
    }

    public int[] solution(int n) {
        int len = n * (n + 1) / 2;
        int[] answer = new int[len];

        // 방향 - 1: 왼쪽 대각선 아래 / 2: 오른쪽 / 3: 왼쪽 대각선 위
        int dir = 1;
        int idx = 0;
        int data = 1;
        int move = 1;

        int finishCheck = 0;

        while (true) {
            if (finishCheck == 3)
                break;

            switch (dir) {
                case 1:
                    if (idx < len && answer[idx] == 0) {
                        answer[idx] = data;
                        data++;
                        idx += move;
                        move++;

                        finishCheck = 0;
                    } else {
                        move--;
                        idx -= move;
                        idx++;
                        dir = 2;

                        finishCheck++;
                    }
                    break;
                case 2:
                    if (idx < len && answer[idx] == 0) {
                        answer[idx++] = data;
                        data++;

                        finishCheck = 0;
                    } else {
                        idx--;
                        idx -= move;
                        move--;
                        dir = 3;

                        finishCheck++;
                    }
                    break;
                case 3:
                    if (idx > 0 && answer[idx] == 0) {
                        answer[idx] = data;
                        data++;
                        idx -= move;
                        move--;

                        finishCheck = 0;
                    } else {
                        move++;
                        idx += move * 2;
                        move++;
                        dir = 1;

                        finishCheck++;
                    }
                    break;
            }
        }

        return answer;
    }

}
