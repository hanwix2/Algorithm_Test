// 점프와 순간 이동
// https://programmers.co.kr/learn/courses/30/lessons/12980

package programmers.level2;

public class JumpAndTeleport {

    public int solution(int n) {
        int ans = 0;

        while (n != 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n--;
                ans++;
            }
        }

        return ans;
    }

}
