package codingtest.toss.next;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution02 {

    public static void main(String[] args) {
        Solution02 test = new Solution02();

        int[] request1 = {1, 2, 3, 4};
        int[] request2 = {1, 1, 2, 2};
        int[] request3 = {1, 2, 2, 3, 4, 1};

        print(test.solution(2, false, request1));
        print(test.solution(2, true, request2));
        print(test.solution(2, true, request3));

    }

    private static void print(int[][] solution) {
        for (int[] s : solution) {
            for (int num : s) {
                System.out.print(num);
            }
            System.out.println();
        }
        System.out.println("---------------------------------------");
    }

    public int[][] solution(int servers, boolean sticky, int[] requests) {

        int total = requests.length;

        List<List<Integer>> links = new ArrayList<>();
        for (int i = 0; i < servers; i++) {
            links.add(new ArrayList<>());
        }

        Map<Integer, Integer> serverMap = new HashMap<>();

        int order = 0;
        int match = 0;

        while (order < total) {

            int server = match % servers;

            if (sticky) {
                if (serverMap.containsKey(requests[order])) {
                    int preMatch = serverMap.get(requests[order]);
                    links.get(preMatch).add(requests[order]);
                } else {
                    serverMap.put(requests[order], server);
                    links.get(server).add(requests[order]);
                    match++;
                }
            } else {
                links.get(server).add(requests[order]);
                match++;
            }
            order++;
        }


        int[][] answer = new int[servers][];

        for (int i = 0; i < servers; i++) {
            int tmpSize = links.get(i).size();
            answer[i] = new int[tmpSize];

            for (int j = 0; j < tmpSize; j++) {
                answer[i][j] = links.get(i).get(j);
            }
        }

        return answer;
    }
}
