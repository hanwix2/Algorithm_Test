// 방문 길이
// https://programmers.co.kr/learn/courses/30/lessons/49994

package programmers.level2;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class VisitLength {

    public static void main(String[] args) {
        VisitLength test = new VisitLength();

        String dirs1 = "ULURRDLLU";
        String dirs2 = "LULLLLLLU";

        System.out.println(test.solution(dirs1));
        System.out.println(test.solution(dirs2));
    }

    public int solution(String dirs) {

        Map<Road, Integer> visits = new HashMap<>();

        int dirsLen = dirs.length();

        int sX = 0, sY = 0;
        int eX = 0, eY = 0;

        for (int move = 0; move < dirsLen; move++) {

            char dir = dirs.charAt(move);

            switch (dir) {
                case 'U':
                    eX = sX;
                    eY = sY + 1;
                    break;
                case 'D':
                    eX = sX;
                    eY = sY - 1;
                    break;
                case 'R':
                    eX = sX + 1;
                    eY = sY;
                    break;
                case 'L':
                    eX = sX - 1;
                    eY = sY;
                    break;
            }

            if (eX < -5 || 5 < eX || eY < -5 || 5 < eY)
                continue;

            Road r1 = new Road(sX, sY, eX, eY);
            Road r2 = new Road(eX, eY, sX, sY);
            visits.put(r1, 1);
            visits.put(r2, 1);

            sX = eX;
            sY = eY;
        }

        return visits.size() / 2;
    }

    static class Road {

        int sX, sY, eX, eY;
        String start, end;

        public Road(int sX, int sY, int eX, int eY) {
            this.sX = sX;
            this.sY = sY;
            this.eX = eX;
            this.eY = eY;

            start = new StringBuilder()
                    .append(sX)
                    .append(sY)
                    .toString();

            end = new StringBuilder()
                    .append(eX)
                    .append(eY)
                    .toString();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;

            if (o == null || getClass() != o.getClass())
                return false;

            Road road = (Road) o;

            return (Objects.equals(start, road.start) && Objects.equals(end, road.end));
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

}
