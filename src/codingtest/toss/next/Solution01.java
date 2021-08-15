package codingtest.toss.next;

public class Solution01 {

    public static void main(String[] args) {
        Solution01 test = new Solution01();

        System.out.println(test.solution(9809790, 123, 245));
    }

    public long solution(long orderAmount, long taxFreeAmount, long serviceFee) {
        // orderAmount : 주문금액
        // taxFreeAmount : 비과세금액
        // serviceFee : 봉사료

        long tax = orderAmount - serviceFee - taxFreeAmount;

        if (tax == 1) {
            return 0;
        }

        if (tax % 10 == 0) {
            return tax / 10L;
        } else {
            return tax / 10L + 1;
        }
    }

}
