package codingtest.kakao.mobility;

public class Problem03 {

    public static void main(String[] args) {
        Problem03 test = new Problem03();

        int[] A1 = {3, 2, 3, 2, 3};
        int[] A2 = {7, 4, -2, 4, -2, -9};
        int[] A3 = {7, -5, -5, -5, 7, -1, 7};
        int[] A4 = {4};

        System.out.println(test.solution(A1)); // 5
        System.out.println(test.solution(A2)); // 4
        System.out.println(test.solution(A3)); // 3
        System.out.println(test.solution(A4)); // 1

    }

    public int solution(int[] A) {

        int len = A.length;

        if (len <= 2) {
            return len;
        }

        int longest = 2;

        int left = 0;
        int right = 1;

        int evenValue = A[left];
        int oddValue = A[right];

        while (true) {

            right++;

            if (right == len) {
                break;
            }

            int tmp = A[right];

            if ((right % 2 == 0 && tmp != evenValue) || (right % 2 != 0 && tmp != oddValue)) {
                longest = Math.max(longest, right - left);
                left = right - 1;

                if (left % 2 == 0) {
                    evenValue = A[left];
                    oddValue = A[right];
                } else {
                    evenValue = A[right];
                    oddValue = A[left];
                }

            }

            longest = Math.max(longest, right - left + 1);
        }

        return longest;
    }

}
