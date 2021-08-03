// 방금 그 곡
// https://programmers.co.kr/learn/courses/30/lessons/17683

package programmers.level2;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class TheSongIHeard {

    public static void main(String[] args) {
        TheSongIHeard test = new TheSongIHeard();

        String m1 = "ABCDEFG";
        String m2 = "CC#BCC#BCC#BCC#B";
        String m3 = "ABC";

        String[] musicinfos1 = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
        String[] musicinfos2 = {"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String[] musicinfos3 = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};

        System.out.println(test.solution(m1, musicinfos1));
        System.out.println(test.solution(m2, musicinfos2));
        System.out.println(test.solution(m3, musicinfos3));

    }

    public String solution(String m, String[] musicinfos) {

        String answer = "(None)";
        int answerLen = 0;

        List<String> mList = getMelody(m);

        for (String info : musicinfos) {

            StringTokenizer st = new StringTokenizer(info, ",");

            String start = st.nextToken();
            String end = st.nextToken();
            String title = st.nextToken();
            String sheet = st.nextToken();

            List<String> melody = getMelody(sheet);

            int melodyLen = melody.size();

            int startTime = Integer.parseInt(start.substring(0, 2)) * 60 + Integer.parseInt(start.substring(3, 5));
            int endTime = Integer.parseInt(end.substring(0, 2)) * 60 + Integer.parseInt(end.substring(3, 5));
            int playTime = endTime - startTime;

            List<String> finalMusic = new ArrayList<>();

            int replay = playTime / melodyLen;

            for (int i = 0; i < replay; i++) {
                finalMusic.addAll(melody);
            }

            finalMusic.addAll(melody.subList(0, playTime % melodyLen + 1));

            if (compare(finalMusic, mList) && answerLen < playTime) {
                answer = title;
                answerLen = playTime;
            }
        }

        return answer;
    }

    private boolean compare(List<String> finalMusic, List<String> mList) {

        int fmSize = finalMusic.size();
        int mlSize = mList.size();

        for (int i = 0; i < fmSize - mlSize; i++) {
            loop:
            {
                for (int j = 0; j < mlSize; j++) {
                    if (!finalMusic.get(i + j).equals(mList.get(j))) {
                        break loop;
                    }
                }
                return true;
            }
        }

        return false;
    }

    private List<String> getMelody(String sheet) {

        List<String> melody = new ArrayList<>();

        int sheetLen = sheet.length();

        for (int i = 0; i < sheetLen - 1; i++) {

            char back = sheet.charAt(i + 1);

            if (back == '#') {
                melody.add(sheet.substring(i, i + 2));
                i++;
            } else {
                melody.add(sheet.substring(i, i + 1));
            }
        }

        if (sheet.charAt(sheetLen - 1) != '#') {
            melody.add(sheet.substring(sheetLen - 1, sheetLen));
        }

        return melody;
    }

}
