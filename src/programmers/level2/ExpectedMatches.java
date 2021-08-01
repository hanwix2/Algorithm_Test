// 예상 대진표
// https://programmers.co.kr/learn/courses/30/lessons/12985

package programmers.level2;

public class ExpectedMatches {

    public static void main(String[] args) {
        ExpectedMatches test = new ExpectedMatches();

        System.out.println(test.solution(8, 4, 7));
    }

    public int solution(int n, int a, int b) {

        int round = 1;
        int groupA = nextMatchGroup(a);
        int groupB = nextMatchGroup(b);

        while (groupA != groupB) {
            groupA = nextMatchGroup(groupA);
            groupB = nextMatchGroup(groupB);
            round++;
        }

        return round;
    }

    private int nextMatchGroup(int teamNum) {
        return teamNum % 2 == 0 ? teamNum / 2 : (teamNum + 1) / 2;
    }

}
