// 네트워크
// https://programmers.co.kr/learn/courses/30/lessons/43162

package programmers.level3;

public class Network {

    public static void main(String[] args) {
        Network test = new Network();

        int n1 = 3;
        int n2 = 3;
        int[][] coms1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] coms2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        System.out.println(test.solution(n1, coms1));
        System.out.println(test.solution(n2, coms2));
    }

    public int solution(int n, int[][] computers) {

        int[] node = new int[n];

        int networkNum = 1;

        for (int i = 0; i < n; i++) {
            if (node[i] == 0) {
                dfs(i, n, networkNum, node, computers);
                networkNum++;
            }
        }

        return networkNum - 1;
    }

    private void dfs(int i, int n, int networkNum, int[] node, int[][] computers) {

        node[i] = networkNum;

        for (int link = 0; link < n; link++) {
            if (link != i && computers[i][link] == 1 && node[link] == 0)
                dfs(link, n, networkNum, node, computers);
        }

    }


}
