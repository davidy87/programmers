package lv2;

import java.util.*;

public class 시소_짝궁 {

    public long solution(int[] weights) {
        long answer = 0;
        Map<Double, Integer> map = new HashMap<>();
        Arrays.sort(weights);

        for (double w : weights) {
            double[] nums = {w, w / 2, w * 2 / 3, w * 3 / 4};

            for (double n : nums) {
                if (map.containsKey(n)) {
                    answer += map.get(n);
                }
            }

            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        return answer;
    }
}
