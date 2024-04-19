package lv2;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class 튜플 {

    public int[] solution1(String s) {
        String[] split = s.replaceAll("[{ | }]", "").split(",");
        Map<Integer, Integer> counter = new HashMap<>();

        for (String numStr : split) {
            int num = Integer.valueOf(numStr);
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        int[] answer = new int[counter.size()];

        for (int num : counter.keySet()) {
            answer[answer.length - counter.get(num)] = num;
        }

        return answer;
    }

    // Stream 사용
    public int[] solution2(String s) {
        String[] split = s.replaceAll("[{ | }]", "").split(",");
        Map<Integer, Integer> counter = new HashMap<>();

        for (String numStr : split) {
            int num = Integer.valueOf(numStr);
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }

        return counter.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }
}
