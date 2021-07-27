// 가장 큰 정사각형
// https://programmers.co.kr/learn/courses/30/lessons/12905

package programmers.level2;

public class FindTheBiggestRectangle {

    public static void main(String[] args) {
        FindTheBiggestRectangle test = new FindTheBiggestRectangle();

        int[][] board1 = {{0, 1, 1, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}, {0, 0, 1, 0}};
        int[][] board2 = {{0, 0, 1, 1}, {1, 1, 1, 1}};

        System.out.println(test.solution(board1));
        System.out.println(test.solution(board2));
    }

    public int solution(int[][] board) {

        int iLen = board.length;
        int jLen = board[0].length;

        for (int i = 1; i < iLen; i++) {
            for (int j = 1; j < jLen; j++) {
                if (board[i][j] == 1) {
                    board[i][j] = Math.min(Math.min(board[i - 1][j], board[i][j - 1]), board[i - 1][j - 1]) + 1;
                }
            }
        }

        int maxR = 0;

        for (int i = 0; i < iLen; i++) {
            for (int j = 0; j < jLen; j++) {
                maxR = Math.max(maxR, board[i][j]);
            }
        }

        return maxR * maxR;
    }

}
