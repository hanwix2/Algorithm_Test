// 디스크 컨트롤러
// https://programmers.co.kr/learn/courses/30/lessons/42627

package programmers.level3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class DiskController {

    public static void main(String[] args) {
        DiskController test = new DiskController();

        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};

        System.out.println(test.solution(jobs));
    }

    public int solution(int[][] jobs) {

        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });

        Queue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));

        int len = jobs.length;
        int idx = 1;

        int currentTime = jobs[0][0] + jobs[0][1];
        int totalProcessTime = jobs[0][1];

        while (idx < len || !pq.isEmpty()) {

            while (idx < len && jobs[idx][0] < currentTime) {
                pq.offer(jobs[idx++]);
            }

            if (!pq.isEmpty()) {
                int[] process = pq.poll();
                totalProcessTime += currentTime - process[0] + process[1];
                currentTime += process[1];
            } else {
                pq.offer(jobs[idx++]);
            }
        }

        return totalProcessTime / len;
    }

}
