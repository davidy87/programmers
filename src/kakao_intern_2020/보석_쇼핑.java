package kakao_intern_2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 보석_쇼핑 {

    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        int numKinds = new HashSet<>(Arrays.asList(gems)).size();

        int start = 0;
        int range = gems.length;
        Map<String, Integer> counter = new HashMap<>();

        for (int end = 0; end < gems.length; end++) {
            counter.put(gems[end], counter.getOrDefault(gems[end], 0) + 1);

            while (counter.get(gems[start]) > 1) {
                counter.put(gems[start], counter.get(gems[start]) - 1);
                start++;
            }

            if (counter.size() == numKinds && end - start < range) {
                range = end - start;
                answer = new int[] {start + 1, end + 1};
            }
        }

        return answer;
    }
}
