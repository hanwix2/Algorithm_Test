package skills;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {

        Permutation perm = new Permutation();

        int[] arr = {1, 2, 3, 4};
        int len = arr.length;

        List<Integer> result = new ArrayList<>();

        // permutation01 - visit 배열(방문 확인)을 이용한 순열
        boolean[] visit = new boolean[len];
        perm.permutation01_visit(arr, visit, result, len, 2);   // r = 2

        // permutation02 - swap으로 배열을 직접 바꾸는 방법
        perm.permutation02_swap(arr, 0, len, 3);            // r = 3

    }

    /*
     * <visit 배열로 순열 생성>
     * - n개 중 r개를 뽑아 순서를 정하는 경우
     * - 방문 여부를 체크 & DFS
     * - 순서 보장
     */
    public void permutation01_visit(int[] arr, boolean[] visit, List<Integer> result, int n, int r) {
        if (result.size() == r) {
            print(result);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result.add(arr[i]);
                permutation01_visit(arr, visit, result, n, r);
                result.remove(result.size() - 1);
                visit[i] = false;
            }
        }
    }

    /*
     * <Swap으로 순열 생성>
     * - n개 중 r개를 뽑아 순서를 정하는 경우
     * - 기존의 배열의 위치를 바꿔가며 작업 / 앞의 r개 원소가 순열 결과
     * - 초기 idx 값은 0부터 시작
     * - 순서 보장 불가
     */
    public void permutation02_swap(int[] arr, int idx, int n, int r) {
        if (idx == r) {
            List<Integer> result = getPermResult(arr, r);
            print(result);
            return;
        }

        for (int i = idx; i < n; i++) {
            swap(arr, idx, i);
            permutation02_swap(arr, idx + 1, n, r);
            swap(arr, idx, i);
        }

    }

    private void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    private List<Integer> getPermResult(int[] arr, int r) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < r; i++)
            list.add(arr[i]);

        return list;
    }

    private void print(List<Integer> result) {
        for (Integer num : result) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

}
