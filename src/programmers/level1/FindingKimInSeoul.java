// 김서방 찾기
// https://programmers.co.kr/learn/courses/30/lessons/12919

package programmers.level1;

public class FindingKimInSeoul {

    public static void main(String[] args) {
        FindingKimInSeoul test = new FindingKimInSeoul();

        String[] seoul = {"Jane", "Kim"};
        System.out.println(test.solution(seoul));

    }

    public String solution(String[] seoul) {

        int len = seoul.length;

        for (int i = 0; i < len; i++) {
            if (seoul[i].equals("Kim")) {
                return "김서방은 " + i + "에 있다";
            }
        }

        return "";
    }

}
