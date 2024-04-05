package lv2;

import java.util.*;

public class 영어_끝말잇기 {

    public int[] solution(int n, String[] words) {
        Set<String> usedWords = new HashSet<>();
        usedWords.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String prev = words[i - 1];
            String cur = words[i];

            if (prev.charAt(prev.length() - 1) != cur.charAt(0) || usedWords.contains(cur)) {
                return new int[] {i % n + 1, i / n + 1};
            }

            usedWords.add(cur);
        }

        return new int[] {0, 0};
    }
}
