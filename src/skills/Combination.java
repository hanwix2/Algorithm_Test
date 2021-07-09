package skills;

import java.util.ArrayList;
import java.util.List;

public class Combination {

    public static void main(String[] args) {
        Combination comb = new Combination();

        int[] arr = {1, 2, 3, 4, 5};

        int len = arr.length;
        boolean[] visit = new boolean[len];

        // Combination01 - 백트래킹
        comb.combination01(arr, visit, 0, 0, len, 3);

        // Combination02 - 재귀
        List<Integer> result = new ArrayList<>();
        comb.combination02(arr, result, 0, 0, len, 2);
    }

    // <백트래킹을 이용한 조합>
    public void combination01(int[] arr, boolean[] visit, int idx, int cnt, int n, int r) {
        if (cnt == r) {
            print(arr, visit, n);
            return;
        }

        for (int i = idx; i < n; i++) {
            visit[i] = true;
            combination01(arr, visit, i + 1, cnt + 1, n, r);
            visit[i] = false;
        }
    }

    // <재귀를 이용한 조합>
    public void combination02(int[] arr, List<Integer> result, int idx, int cnt, int n, int r) {
        if (cnt == r) {
            print(result);
            return;
        }

        if (idx == n)
            return;

        result.add(arr[idx]);
        combination02(arr, result, idx + 1, cnt + 1, n, r);
        result.remove(result.size() - 1);
        combination02(arr, result, idx + 1, cnt, n, r);
    }

    private void print(List<Integer> result) {
        for (Integer num : result)
            System.out.print(num + " ");

        System.out.println();
    }


    private void print(int[] arr, boolean[] visit, int n) {
        for (int i = 0; i < n; i++) {
            if (visit[i])
                System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
