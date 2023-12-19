package lv2;

import java.util.*;

public class 시소_짝궁 {

    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> map = new HashMap<>();
        Arrays.sort(weights);

        for (int w : weights) {
            double a = w;
            double[] nums = {a, a / 2, a * 2 / 3, a * 3 / 4};

            for (double n : nums) {
                if (map.containsKey(n)) {
                    answer += map.get(n);
                }
            }

            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        return answer;
    }
}
