package kakao.intern._2020;

import java.util.*;

public class 보석_쇼핑 {

    public int[] solution(String[] gems) {
        int[] answer = {};
        Map<String, Integer> counter = new HashMap<>();
        int numKinds = new HashSet<>(List.of(gems)).size();
        int s = 0;
        int range = gems.length;

        for (int e = 0; e < gems.length; e++) {
            counter.put(gems[e], counter.getOrDefault(gems[e], 0) + 1);

            while (counter.get(gems[s]) > 1) {
                counter.put(gems[s], counter.get(gems[s]) - 1);
                s++;
            }

            if (counter.size() == numKinds && e - s < range) {
                range = e - s;
                answer = new int[] {s + 1, e + 1};
            }
        }

        return answer;
    }
}
