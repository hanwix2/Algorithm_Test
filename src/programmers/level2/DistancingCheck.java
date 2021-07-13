// 거리두기 확인
// https://programmers.co.kr/learn/courses/30/lessons/81302

package programmers.level2;

import java.util.Stack;

public class DistancingCheck {

    private int[] di = {0, 1, 0, -1};
    private int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) {
        DistancingCheck test = new DistancingCheck();

        String[][] places = {
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        print(test.solution(places));
    }

    private static void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public int[] solution(String[][] places) {

        int[] answer = new int[5];

        for (int tc = 0; tc < 5; tc++) {

            char[][] seats = new char[5][5];

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    seats[i][j] = places[tc][i].charAt(j);
                }
            }

            int value = 1;

            loop:
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (seats[i][j] == 'P' && !distancingValid_dfs(seats, i, j)) {
                        value = 0;
                        break loop;
                    }
                }
            }

            answer[tc] = value;
        }

        return answer;
    }

    private boolean distancingValid_dfs(char[][] seats, int i, int j) {

        boolean[][] visit = new boolean[5][5];

        Stack<Location> stack = new Stack<>();

        stack.push(new Location(i, j, 0));
        visit[i][j] = true;

        while (!stack.isEmpty()) {

            Location loc = stack.pop();

            if (loc.depth >= 2)
                continue;

            for (int n = 0; n < 4; n++) {

                int ni = loc.i + di[n];
                int nj = loc.j + dj[n];

                if (0 <= ni && ni < 5 && 0 <= nj && nj < 5 && !visit[ni][nj]) {

                    if (seats[ni][nj] == 'P') {
                        return false;
                    } else if (seats[ni][nj] == 'O') {
                        stack.push(new Location(ni, nj, loc.depth + 1));
                    }

                    visit[ni][nj] = true;
                }
            }
        }

        return true;
    }

    class Location {

        private int i, j, depth;

        public Location(int i, int j, int depth) {
            this.i = i;
            this.j = j;
            this.depth = depth;
        }

    }

}
