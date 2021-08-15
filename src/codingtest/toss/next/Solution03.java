package codingtest.toss.next;

public class Solution03 {

    public static void main(String[] args) {
        Solution03 test = new Solution03();

        System.out.println(test.solution("1,2323,4242"));
        System.out.println(test.solution("1,233,424"));
        System.out.println(test.solution("01,2323,4242"));
    }

    public boolean solution(String amountText) {

        int len = amountText.length();

        char first = amountText.charAt(0);
        char last = amountText.charAt(len - 1);

        if ((len != 1 && first == '0') || first == ',' || last == ',') {
            return false;
        }

        if (amountText.contains(",")) {
            for (int i = len - 1; i >= 0; i--) {
                char now = amountText.charAt(i);

                if ((len - i) % 4 == 0 && now != ',') {
                    return false;
                }

                if ((len - i) % 4 != 0 && (now < '0' || '9' < now)) {
                    return false;
                }
            }

        } else {
            for (int i = 0; i < len; i++) {
                char now = amountText.charAt(i);

                if (now < '0' || '9' < now) {
                    return false;
                }
            }
        }

        return true;
    }

}
