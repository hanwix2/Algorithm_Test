// 순위 검색
// https://programmers.co.kr/learn/courses/30/lessons/72412

package programmers.level2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RankingSearching {

    public static void main(String[] args) {

        String[] info = {"java backend junior pizza 150",
                "python frontend senior chicken 210",
                "python frontend senior chicken 150",
                "cpp backend senior pizza 260",
                "java backend junior chicken 80",
                "python backend senior chicken 50"};

        String[] query = {"java and backend and junior and pizza 100",
                "python and frontend and senior and chicken 200",
                "cpp and - and senior and pizza 250",
                "- and backend and senior and - 150",
                "- and - and - and chicken 100",
                "- and - and - and - 150"};

        RankingSearching test = new RankingSearching();

        int[] answer = test.solution(info, query);

        System.out.println(Arrays.toString(answer));

    }

    public int[] solution(String[] info, String[] query) {

        int infoLen = info.length;
        int queryLen = query.length;

        int[] answer = new int[queryLen];

        Map<String, List<Integer>> infoMap = new HashMap<>();




        return answer;

//        -----------------------------------------------------------------------------

//        int infoLen = info.length;
//        int queryLen = query.length;
//
//        int[] answer = new int[queryLen];
//
//        String[][] infos = new String[infoLen][4];
//        int[] scores = new int[infoLen];
//
//        StringTokenizer st;
//
//        for (int i = 0; i < infoLen; i++) {
//            st = new StringTokenizer(info[i], " ");
//
//            for (int j = 0; j < 4; j++) {
//                infos[i][j] = st.nextToken();
//            }
//
//            scores[i] = Integer.parseInt(st.nextToken());
//        }
//
//        String[] ref = new String[4];
//
//        for (int idx = 0; idx < queryLen; idx++) {
//
//            st = new StringTokenizer(query[idx].replaceAll("and ", ""), " ");
//
//            for (int refIdx = 0; refIdx < 4; refIdx++) {
//                ref[refIdx] = st.nextToken();
//            }
//
//            int scoreRef = Integer.parseInt(st.nextToken());
//
//            for (int i = 0; i < infoLen; i++) {
//
//                boolean flag = true;
//
//                for (int j = 0; j < 4; j++) {
//
//                    if (ref[j].equals("-")) {
//                        continue;
//                    } else if (ref[j].equals(infos[i][j])) {
//                        continue;
//                    } else {
//                        flag = false;
//                        break;
//                    }
//
//                }
//
//                if (flag && scores[i] >= scoreRef) {
//                    answer[idx]++;
//                }
//            }
//        }
//
//        return answer;
    }

}
