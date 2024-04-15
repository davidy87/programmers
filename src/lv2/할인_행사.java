package lv2;

import java.util.*;

public class 할인_행사 {

    private static final int MEMBERSHIP = 10;

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;

        for (int i = 0; i <= discount.length - MEMBERSHIP; i++) {
            Map<String, Integer> counter = new HashMap<>();

            for (int j = i; j < i + MEMBERSHIP; j++) {
                counter.put(discount[j], counter.getOrDefault(discount[j], 0) + 1);
            }

            if (isValid(counter, want, number)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isValid(Map<String, Integer> counter, String[] want, int[] number) {
        for (int i = 0; i < want.length; i++) {
            if (counter.getOrDefault(want[i], 0) != number[i]) {
                return false;
            }
        }

        return true;
    }
}
