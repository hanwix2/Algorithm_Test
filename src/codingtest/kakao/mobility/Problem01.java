/*
 <주어진 전화번호를 올바른 포맷으로 변환>
 입력은 숫자, 공백, '-'만 가능
 포맷 - 앞에서부터 3개씩 묶어서 '-'로 구분 / 마지막 하나 또는 두개의 묶음은 2개 또는 3개만 가능
 */

package codingtest.kakao.mobility;

public class Problem01 {

    public static void main(String[] args) {
        Problem01 test = new Problem01();

        System.out.println(test.solution("00-44  48 5555 8361"));
    }

    public String solution(String S) {
        String onlyNum = S.replaceAll(" ", "")
                .replaceAll("-", "");

        int len = onlyNum.length();
        int blocks = len / 3;
        int left = len % 3;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < blocks; i++) {
            sb.append(onlyNum, 3 * i, 3 * (i + 1));
            sb.append("-");
        }

        int sbLen = sb.length();

        if (left == 0) {
            sb.deleteCharAt(sbLen - 1);
        } else {

            if (left != 2) {
                sb.delete(sbLen - 4, sbLen);
                sb.append(onlyNum, len - 4, len - 2);
                sb.append("-");
            }

            sb.append(onlyNum, len - 2, len);
        }

        return sb.toString();
    }

}
