package lv2;

import java.util.*;

public class 뉴스_클러스터링 {

    private static final int N = 65536;

    public int solution(String str1, String str2) {
        if (str1.equalsIgnoreCase(str2)) {
            return N;
        }

        Map<String, Integer> set1 = getSet(str1.toLowerCase());
        Map<String, Integer> set2 = getSet(str2.toLowerCase());

        int n = getIntersectionSize(set1, set2);
        int d = getUnionSize(set1, set2);

        if (d == 0) {
            return N;
        }

        return (int) Math.floor(((double) n / d) * N);
    }

    private int getUnionSize(Map<String, Integer> set1, Map<String, Integer> set2) {
        for (String elem : set1.keySet()) {
            set2.put(elem, Math.max(set1.get(elem), set2.getOrDefault(elem, 0)));
        }

        return set2.values().stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    private int getIntersectionSize(Map<String, Integer> set1, Map<String, Integer> set2) {
        return set1.keySet().stream()
                .map(elem -> Math.min(set1.get(elem), set2.getOrDefault(elem, 0)))
                .mapToInt(Integer::intValue)
                .sum();
    }

    private Map<String, Integer> getSet(String str) {
        Map<String, Integer> result = new HashMap<>();

        for (int i = 0; i < str.length() - 1; i++) {
            String chunk = str.substring(i, i + 2);

            if (chunk.chars().allMatch(Character::isLetter)) {
                result.put(chunk, result.getOrDefault(chunk, 0) + 1);
            }
        }

        return result;
    }
}
