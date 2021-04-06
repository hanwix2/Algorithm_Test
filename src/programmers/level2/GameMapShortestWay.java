// 게임 맵 최단거리
// https://programmers.co.kr/learn/courses/30/lessons/1844

package programmers.level2;

import java.util.LinkedList;
import java.util.Queue;

public class GameMapShortestWay {

    public static void main(String[] args) {
        GameMapShortestWay test = new GameMapShortestWay();

        int[][] maps = {{1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}};

        System.out.println(test.solution(maps));
    }

    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[] di = {1, 0, -1, 0};
        int[] dj = {0, 1, 0, -1};

        Queue<Node> queue = new LinkedList<>();

        queue.add(new Node(0, 0, 1));
        maps[0][0] = 0;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (int d = 0; d < 4; d++) {

                int ni = now.i + di[d];
                int nj = now.j + dj[d];

                if (ni == n - 1 && nj == m - 1)
                    return now.cnt + 1;

                if (0 <= ni && ni < n && 0 <= nj && nj < m && maps[ni][nj] == 1) {
                    queue.add(new Node(ni, nj, now.cnt + 1));
                    maps[ni][nj] = 0;
                }
            }
        }

        return -1;
    }


}

class Node {
    int i, j, cnt;

    public Node(int i, int j, int cnt) {
        this.i = i;
        this.j = j;
        this.cnt = cnt;
    }
}
