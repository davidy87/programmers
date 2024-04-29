package lv2;

import java.util.*;

public class 모음사전 {

    private static final String[] vowels = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        List<String> words = new ArrayList<>();
        dfs("", words);

        return words.indexOf(word) + 1;
    }

    private void dfs(String cur, List<String> words) {
        if (cur.length() == 5) {
            return;
        }

        for (String v : vowels) {
            String newWord = cur + v;
            words.add(newWord);
            dfs(newWord, words);
        }
    }
}
