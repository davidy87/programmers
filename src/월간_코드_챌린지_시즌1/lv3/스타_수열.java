package 월간_코드_챌린지_시즌1.lv3;

import java.util.*;

public class 스타_수열 {

    public int solution(int[] a) {
        int answer = 0;
        Map<Integer, Integer> counter = getCounter(a);

        for (int n : counter.keySet()) {
            if (counter.get(n) < answer) {
                continue;
            }

            int numSubset = 0;

            for (int i = 0; i < a.length - 1; i++) {
                if ((a[i] == n || a[i + 1] == n) && a[i] != a[i + 1]) {
                    numSubset++;
                    i++;
                }
            }

            answer = Math.max(numSubset, answer);
        }

        return answer * 2;
    }

    private Map<Integer, Integer> getCounter(int[] a) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int n : a) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }

        return counter;
    }
}
