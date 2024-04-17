package lv2;

import java.util.*;

public class 캐시 {
    private static final int HIT = 1;
    private static final int MISS = 5;

    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Deque<String> cache = new ArrayDeque<>();

        if (cacheSize == 0) {
            return cities.length * MISS;
        }

        for (String city : cities) {
            city = city.toLowerCase();

            if (cache.contains(city)) {
                cache.remove(city);
                cache.offer(city);
                answer += HIT;
                continue;
            }

            if (cache.size() >= cacheSize) {
                cache.poll();
            }

            cache.offer(city);
            answer += MISS;
        }

        return answer;
    }
}
