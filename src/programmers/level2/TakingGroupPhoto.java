// 단체사진 찍기
// https://programmers.co.kr/learn/courses/30/lessons/1835

package programmers.level2;

public class TakingGroupPhoto {

    public static void main(String[] args) {
        TakingGroupPhoto test = new TakingGroupPhoto();

        String[] data1 = {"N~F=0", "R~T>2"};
        String[] data2 = {"M~C<2", "C~M>1"};

        System.out.println(test.solution(2, data1));
        System.out.println(test.solution(2, data2));
    }

    private static final int TOTAL = 8;

    private int cnt;

    public int solution(int n, String[] data) {

        cnt = 0;

        int[] sequence = new int[8]; // A, C, F, J, M, N, R, T 의 순서
        boolean[] visit = new boolean[8];

        permutation(sequence, visit, 0, data);

        return cnt;
    }

    private void permutation(int[] sequence, boolean[] visit, int num, String[] data) {
        if (num == TOTAL) {
            checkConditions(sequence, data);
            return;
        }

        for (int i = 0; i < TOTAL; i++) {
            if (!visit[i]) {
                visit[i] = true;
                sequence[i] = num;
                permutation(sequence, visit, num + 1, data);
                visit[i] = false;
            }
        }

    }

    private void checkConditions(int[] sequence, String[] data) {

        for (String condition : data) {

            int p1 = sequence[getIdxOfChar(condition.charAt(0))];
            int p2 = sequence[getIdxOfChar(condition.charAt(2))];

            char state = condition.charAt(3);
            int amount = Integer.parseInt(String.valueOf(condition.charAt(4)));

            int diff = Math.abs(p1 - p2) - 1;

            if ((state == '<' && diff >= amount) || (state == '>' && diff <= amount) || (state == '=' && diff != amount)) {
                return;
            }
        }

        cnt++;
    }

    private int getIdxOfChar(char c) {
        return switch (c) {
            case 'A' -> 0;
            case 'C' -> 1;
            case 'F' -> 2;
            case 'J' -> 3;
            case 'M' -> 4;
            case 'N' -> 5;
            case 'R' -> 6;
            default -> 7; // 'T'
        };
    }

}
