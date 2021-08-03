// 캐시
// https://programmers.co.kr/learn/courses/30/lessons/17680

package programmers.level2;

import java.util.LinkedList;
import java.util.List;

public class Cache {

    public static void main(String[] args) {
        Cache test = new Cache();

        String[] cities1 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        String[] cities2 = {"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        String[] cities3 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String[] cities4 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        String[] cities5 = {"Jeju", "Pangyo", "NewYork", "newyork"};
        String[] cities6 = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};

        System.out.println(test.solution(3, cities1));
        System.out.println(test.solution(3, cities2));
        System.out.println(test.solution(2, cities3));
        System.out.println(test.solution(5, cities4));
        System.out.println(test.solution(2, cities5));
        System.out.println(test.solution(0, cities6));
    }

    public int solution(int cacheSize, String[] cities) {

        List<String> cache = new LinkedList<>();

        int answer = 0;

        for (String city : cities) {
            if (cacheSize != 0 && cacheHit(cache, cacheSize, city.toLowerCase())) {
                answer += 1;
            } else {
                answer += 5;
            }
        }

        return answer;
    }

    private boolean cacheHit(List<String> cache, int cacheSize, String city) {

        int len = cache.size();

        for (int i = 0; i < len; i++) {
            if (cache.get(i).equals(city)) {
                cache.remove(i);
                cache.add(city);
                return true;
            }
        }

        if (cache.size() == cacheSize) {
            cache.remove(0);
        }

        cache.add(city);
        return false;
    }

}
