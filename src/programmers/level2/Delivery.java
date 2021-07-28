// 배달
// https://programmers.co.kr/learn/courses/30/lessons/12978

package programmers.level2;

import java.util.*;

public class Delivery {

    public static void main(String[] args) {
        Delivery test = new Delivery();

        int[][] road1 = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int[][] road2 = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};

        System.out.println(test.solution(5, road1, 3));
        System.out.println(test.solution(6, road2, 4));
    }

    public int solution(int N, int[][] road, int K) {

        List<Node>[] map = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int[] r : road) {
            map[r[0]].add(new Node(r[1], r[2]));
            map[r[1]].add(new Node(r[0], r[2]));
        }

        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dijkstra(map, dist);

        int answer = 0;

        for (int d : dist) {
            if (d <= K) {
                answer++;
            }
        }

        return answer;
    }

    private void dijkstra(List<Node>[] map, int[] dist) {

        Queue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));

        pq.offer(new Node(1, 0));
        dist[1] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();

            int villageNum = node.villageNum;
            int distance = node.distance;

            if (dist[villageNum] < distance) {
                continue;
            }

            for (Node next : map[villageNum]) {
                int nVillageNum = next.villageNum;
                int nDistance = distance + next.distance;

                if (dist[nVillageNum] > nDistance) {
                    dist[nVillageNum] = nDistance;
                    pq.offer(new Node(nVillageNum, nDistance));
                }
            }

        }

    }

    public static class Node {
        private final int villageNum, distance;

        public Node(int villageNum, int distance) {
            this.villageNum = villageNum;
            this.distance = distance;
        }

    }

}
