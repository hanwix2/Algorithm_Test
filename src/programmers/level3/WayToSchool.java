// 등굣길
// https://programmers.co.kr/learn/courses/30/lessons/42898

package programmers.level3;

import java.util.LinkedList;
import java.util.Queue;

public class WayToSchool {

    public static void main(String[] args) {

        WayToSchool test = new WayToSchool();

        int[][] puddles = {{2, 2}};

        System.out.println(test.solution(4, 3, puddles));

    }

    public int solution(int m, int n, int[][] puddles) {

        int[][] map = new int[n + 1][m + 1];
        boolean[][] visit = new boolean[n + 1][m + 1];

        for (int[] puddle : puddles) {
            map[puddle[1]][puddle[0]] = -1;
        }

        map[1][1] = 1;

        Queue<int[]> queue = new LinkedList<>();

        checkNextAndAddQueue(map, visit, queue, 1, 1, m, n);

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            setShortestWayNum(map, now[1], now[0]);

            checkNextAndAddQueue(map, visit, queue, now[1], now[0], m, n);
        }

        return map[n][m] % 1_000_000_007;
    }

    private void setShortestWayNum(int[][] map, int x, int y) {

        int value = 0;

        // 왼쪽
        if (x - 1 > 0 && map[y][x - 1] != -1) {
            value += map[y][x - 1];
        }

        // 위
        if (y - 1 > 0 && map[y - 1][x] != -1) {
            value += map[y - 1][x];
        }

        map[y][x] = value;
    }

    private void checkNextAndAddQueue(int[][] map, boolean[][] visit, Queue<int[]> queue, int x, int y, int m, int n) {

        // 오른쪽
        if (x + 1 <= m && map[y][x + 1] != -1 && !visit[y][x + 1]) {
            queue.add(new int[]{y, x + 1});
            visit[y][x + 1] = true;
        }

        // 아래
        if (y + 1 <= n && map[y + 1][x] != -1 && !visit[y + 1][x]) {
            queue.add(new int[]{y + 1, x});
            visit[y + 1][x] = true;
        }

    }

}
