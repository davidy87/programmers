package lv2;

import java.util.HashMap;
import java.util.Map;

public class 의상 {

    public int solution(String[][] clothes) {
        int answer = 1;
        Map<String, Integer> counter = new HashMap<>();

        for (String[] cloth : clothes) {
            counter.put(cloth[1], counter.getOrDefault(cloth[1], 0) + 1);
        }

        for (int count : counter.values()) {
            answer *= count + 1;
        }

        return answer - 1;
    }
}
