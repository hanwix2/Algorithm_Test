// 메뉴 리뉴얼
// https://programmers.co.kr/learn/courses/30/lessons/72411

package programmers.level2;

import java.util.*;

public class MenuRenewal {

    public static void main(String[] args) {
        MenuRenewal test = new MenuRenewal();

        String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        String[] orders3 = {"XYZ", "XWY", "WXA"};

        int[] course1 = {2, 3, 4};
        int[] course2 = {2, 3, 5};
        int[] course3 = {2, 3, 4};

        print(test.solution(orders1, course1));
        print(test.solution(orders2, course2));
        print(test.solution(orders3, course3));
    }

    private static void print(String[] solution) {
        for (String course : solution)
            System.out.print(course + " ");
        System.out.println();
    }

    public String[] solution(String[] orders, int[] course) {

        List<String> finalMenu = new ArrayList<>();

        for (int menuNum : course) {

            Map<String, Integer> menuMap = new HashMap<>();

            for (String order : orders) {
                int len = order.length();

                if (len < menuNum)
                    continue;

                List<Character> menu = new ArrayList<>();

                for (int i = 0; i < len; i++)
                    menu.add(order.charAt(i));

                Collections.sort(menu);

                StringBuilder sb = new StringBuilder();
                combination(menuMap, menu, sb, 0, 0, len, menuNum);
            }

            findMaxOrderedCourse(finalMenu, menuMap);
        }

        Collections.sort(finalMenu);

        return finalMenu.toArray(new String[finalMenu.size()]);
    }

    private void combination(Map<String, Integer> menuMap, List<Character> menu, StringBuilder sb, int idx, int cnt, int n, int r) {
        if (cnt == r) {
            String course = sb.toString();

            if (menuMap.containsKey(course))
                menuMap.put(course, menuMap.get(course) + 1);
            else
                menuMap.put(course, 1);

            return;
        }

        if (idx == n)
            return;

        sb.append(menu.get(idx));
        combination(menuMap, menu, sb, idx + 1, cnt + 1, n, r);
        sb.deleteCharAt(sb.length() - 1);
        combination(menuMap, menu, sb, idx + 1, cnt, n, r);
    }

    private void findMaxOrderedCourse(List<String> finalMenu, Map<String, Integer> menuMap) {
        int maxCnt = 0;

        List<String> tmpList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : menuMap.entrySet()) {
            int cnt = entry.getValue();

            if (cnt == 1 || cnt < maxCnt)
                continue;

            if (cnt > maxCnt) {
                maxCnt = cnt;
                tmpList.clear();
            }

            tmpList.add(entry.getKey());
        }

        finalMenu.addAll(tmpList);
    }

}
