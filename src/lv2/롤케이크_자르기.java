package lv2;

import java.util.*;

public class 롤케이크_자르기 {

    public int solution(int[] topping) {
        int answer = 0;
        Set<Integer> kinds = new HashSet<>();
        Map<Integer, Integer> counter = new HashMap<>();

        for (int t : topping) {
            counter.put(t, counter.getOrDefault(t, 0) + 1);
        }

        for (int t : topping) {
            counter.put(t, counter.get(t) - 1);
            kinds.add(t);

            if (counter.get(t) == 0) {
                counter.remove(t);
            }

            if (counter.size() == kinds.size()) {
                answer++;
            }
        }

        return answer;
    }
}
