// 여행경로
// https://programmers.co.kr/learn/courses/30/lessons/43164

package programmers.level3;

import java.util.*;

public class TravelRoute {

    public static void main(String[] args) {
        TravelRoute test = new TravelRoute();

        String[][] tickets1 = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] tickets2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}};

        test.print(test.solution(tickets1));
        test.print(test.solution(tickets2));
    }

    private void print(String[] route) {
        for (String city : route)
            System.out.print(city + " ");
        System.out.println();
    }

    private boolean keepSearch = true;
    private String[] answer;

    public String[] solution(String[][] tickets) {

        Arrays.sort(tickets, Comparator.comparing(o -> o[1]));

        int len = tickets.length;
        boolean[] visit = new boolean[len];
        Deque<String> cities = new LinkedList<>();

        cities.add("ICN");

        dfs(cities, visit, tickets, len);

        keepSearch = true;

        return answer;
    }

    private void dfs(Deque<String> cities, boolean[] visit, String[][] tickets, int len) {

        if (!keepSearch)
            return;

        if (cities.size() == len + 1) {
            answer = cities.toArray(new String[0]);
            keepSearch = false;
            return;
        }

        for (int i = 0; i < len; i++) {
            if (!visit[i] && cities.peekLast().equals(tickets[i][0])) {
                visit[i] = true;
                cities.add(tickets[i][1]);
                dfs(cities, visit, tickets, len);
                cities.pollLast();
                visit[i] = false;
            }
        }

    }

}
