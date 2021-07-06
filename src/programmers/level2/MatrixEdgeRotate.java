// 행렬 테두리 회전하기
// https://programmers.co.kr/learn/courses/30/lessons/77485

package programmers.level2;

public class MatrixEdgeRotate {

    public static void main(String[] args) {

        MatrixEdgeRotate test = new MatrixEdgeRotate();

        int[][] queries1 = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int[][] queries2 = {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2}, {2, 2, 3, 3}};
        int[][] queries3 = {{1, 1, 100, 97}};

        int[] result1 = test.solution(6, 6, queries1);
        int[] result2 = test.solution(3, 3, queries2);
        int[] result3 = test.solution(100, 97, queries3);


        for (int result : result1)
            System.out.print(result + " ");

        System.out.println();

        for (int result : result2)
            System.out.print(result + " ");

        System.out.println();

        for (int result : result3)
            System.out.print(result + " ");

    }

    public int[] solution(int rows, int columns, int[][] queries) {

        int[][] matrix = new int[rows + 1][columns + 1];

        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < columns + 1; j++) {
                matrix[i][j] = (i - 1) * columns + j;
            }
        }

        int rotateTimes = queries.length;

        int[] answer = new int[rotateTimes];

        for (int i = 0; i < rotateTimes; i++) {
            answer[i] = rotate(matrix, queries[i]);
        }

        return answer;
    }

    private int rotate(int[][] matrix, int[] query) {

        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];

        int tmp = matrix[x1][y1];

        int min = tmp;

        int x = x1;
        int y = y1;

        int preX = x1;
        int preY = y1;

        int nextValue = 10000;

        while (x != x2) {
            nextValue = matrix[++x][y];
            matrix[preX][y] = nextValue;
            min = Math.min(min, nextValue);
            preX = x;
        }

        while (y != y2) {
            nextValue = matrix[x][++y];
            matrix[x][preY] = nextValue;
            min = Math.min(min, nextValue);
            preY = y;
        }

        while (x != x1) {
            nextValue = matrix[--x][y];
            matrix[preX][y] = nextValue;
            min = Math.min(min, nextValue);
            preX = x;
        }

        while (y != y1 + 1) {
            nextValue = matrix[x][--y];
            matrix[x][preY] = nextValue;
            min = Math.min(min, nextValue);
            preY = y;
        }

        matrix[x][y] = tmp;

        return min;
    }

}
