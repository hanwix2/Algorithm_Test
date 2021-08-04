// 파일명 정렬
// https://programmers.co.kr/learn/courses/30/lessons/17686

package programmers.level2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileNameSorting {

    public static void main(String[] args) {

        FileNameSorting test = new FileNameSorting();

        String[] files1 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] files2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};

//        System.out.println(Arrays.toString(test.solution(files1)));
//        System.out.println(Arrays.toString(test.solution(files2)));

        System.out.println((int) ' ');
        System.out.println((int) '0');
        System.out.println((int) '9');

    }

    public String[] solution(String[] files) {

        List<FileName> answerList = new ArrayList<>();

        int len = files.length;

        for (int i = 0; i < len; i++) {
            answerList.add(new FileName(files[i], i));
        }

        Collections.sort(answerList);

        String[] answer = new String[len];

        for (int i = 0; i < len; i++) {
            answer[i] = answerList.get(i).name;
        }

        return answer;
    }

    static class FileName implements Comparable<FileName> {

        private final String name;
        private final int order;

        private String headPart;
        private String numberPart;
        private int number;

        public FileName(String name, int order) {
            this.name = name;
            this.order = order;
            getPart();
        }

        private void getPart() {
            boolean partChange = false;
            int len = name.length();
            int numberStart = 0;

            for (int i = 0; i < len; i++) {
                char tmp = name.charAt(i);

                // HEAD part
                if (!partChange && '0' <= tmp && tmp <= '9') {
                    partChange = true;
                    headPart = name.substring(0, i).toLowerCase();
                    numberStart = i;
                }

                // NUMBER part
                if (partChange && !('0' <= tmp && tmp <= '9')) {
                    numberPart = name.substring(numberStart, i);
                    number = Integer.parseInt(numberPart);
                    return;
                }
            }

            // TAIL이 없는 경우
            numberPart = name.substring(numberStart, len);
            number = Integer.parseInt(numberPart);

        }

        @Override
        public int compareTo(FileName o) {
            if (headPart.equals(o.headPart)) {

                if (number == o.number) {
                    return Integer.compare(order, o.order);
                }

                return Integer.compare(number, o.number);
            }

            return headPart.compareTo(o.headPart);
        }
    }

}
