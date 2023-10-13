package heap;

import java.util.*;

public class 보석_쇼핑 {

    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int numKinds = new HashSet<>(Arrays.asList(gems)).size();

        Map<String, Integer> counter = new HashMap<>();
        int range = gems.length;
        int start = 0;

        for (int end = 0; end < gems.length; end++) {
            counter.put(gems[end], counter.getOrDefault(gems[end], 0) + 1);

            while (counter.get(gems[start]) > 1) {
                counter.put(gems[start], counter.get(gems[start]) - 1);
                start++;
            }

            if (counter.size() == numKinds && range > end - start) {
                range = end - start;
                answer[0] = start + 1;
                answer[1] = end + 1;
            }
        }

        return answer;
    }
}
