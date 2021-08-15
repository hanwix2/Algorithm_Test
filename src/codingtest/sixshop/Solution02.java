package codingtest.sixshop;

import java.util.*;

public class Solution02 {

    public static void main(String[] args) {
        Solution02 test = new Solution02();

        String[] user_scores1 = {"alex111 100", "cheries2 200", "coco 150", "luna 100", "alex111 120", "coco 300", "cheries2 110"};
        String[] user_scores2 = {"alex111 100", "cheries2 200", "alex111 200", "cheries2 150", "coco 50", "coco 200"};
        String[] user_scores3 = {"cheries2 200", "alex111 100", "coco 150", "puyo 120"};

        System.out.println(test.solution(3, user_scores1));
        System.out.println(test.solution(3, user_scores2));
        System.out.println(test.solution(2, user_scores3));
    }

    public int solution(int K, String[] user_scores) {

        int cnt = 0;
        int len = user_scores.length;

        List<User> firstPageList = new ArrayList<>();
        Map<String, Integer> firstPageMap = new HashMap<>();

        int idx = 0;

        while (firstPageList.size() < K && idx < len) {
            StringTokenizer st = new StringTokenizer(user_scores[idx]);
            String nickName = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            if (firstPageMap.containsKey(nickName) && score > firstPageMap.get(nickName)) {

                if (rankingChanged(firstPageList, nickName, score, idx)) {
                    firstPageMap.put(nickName, score);
                    cnt++;
                }

            } else {
                firstPageList.add(new User(nickName, score, idx));
                firstPageMap.put(nickName, score);
                cnt++;
            }

            idx++;
        }

        Collections.sort(firstPageList);

        while (idx < len) {

            int preCnt = cnt;

            StringTokenizer st = new StringTokenizer(user_scores[idx]);
            String nickName = st.nextToken();
            int score = Integer.parseInt(st.nextToken());

            if (firstPageMap.containsKey(nickName) && score > firstPageMap.get(nickName)) {

                if (rankingChanged(firstPageList, nickName, score, idx)) {
                    firstPageMap.put(nickName, score);
                    cnt++;
                }

            } else if (!firstPageMap.containsKey(nickName)) {
                User lastUser = firstPageList.get(K - 1);

                if (score > lastUser.score) {
                    firstPageMap.remove(lastUser.nickName);
                    firstPageMap.put(nickName, score);
                    firstPageList.remove(K - 1);
                    firstPageList.add(new User(nickName, score, idx));
                    cnt++;
                }
            }

            if (preCnt != cnt) {
                Collections.sort(firstPageList);
            }

            idx++;

        }

        return cnt;
    }

    private boolean rankingChanged(List<User> firstPageList, String nickName, int score, int idx) {
        int targetIdx = getTargetIdx(firstPageList, nickName);

        User user = firstPageList.get(targetIdx);
        user.score = score;
        user.order = idx;

        return targetIdx > 0 && score > firstPageList.get(targetIdx - 1).score;
    }

    private int getTargetIdx(List<User> firstPageList, String nickName) {

        int len = firstPageList.size();

        for (int i = 0; i < len; i++) {
            if (firstPageList.get(i).nickName.equals(nickName)) {
                return i;
            }
        }

        return 0;
    }

    public static class User implements Comparable<User> {

        private String nickName;
        private int score;
        private int order;

        public User(String nickName, int score, int order) {
            this.nickName = nickName;
            this.score = score;
            this.order = order;
        }

        @Override
        public int compareTo(User o) {
            if (this.score == o.score) {
                return Integer.compare(this.order, o.order);
            }
            return Integer.compare(o.score, this.score);
        }
    }

}