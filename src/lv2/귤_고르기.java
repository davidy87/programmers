package lv2;

import java.util.*;

public class 귤_고르기 {

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> counter = new HashMap<>();

        for (int t : tangerine) {
            counter.put(t, counter.getOrDefault(t, 0) + 1);
        }

        List<Integer> countList = new ArrayList<>(counter.values());
        countList.sort(Collections.reverseOrder());

        for (int count : countList) {
            if (k <= 0) {
                break;
            }

            answer++;
            k -= count;
        }

        return answer;
    }
}
