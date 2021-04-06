// 문자열 내 마음대로 정렬하기
// https://programmers.co.kr/learn/courses/30/lessons/12915

package programmers.level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortingStringInMyWay {

    public static void main(String[] args) {
        SortingStringInMyWay test = new SortingStringInMyWay();

        String[] strings = {"abce", "abcd", "cdx"};
        int n = 1;

        String[] answer = test.solution(strings, n);

        System.out.println(Arrays.toString(answer));
    }

    public String[] solution(String[] strings, int n) {

        List<String> list = Arrays.asList(strings);

        list.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char c1 = o1.charAt(n);
                char c2 = o2.charAt(n);

                if (c1 == c2)
                    return o1.compareTo(o2);

                return Integer.compare(c1, c2);
            }
        });

        return list.toArray(new String[0]);
    }

}
