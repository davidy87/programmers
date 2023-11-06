package PCCP_모의고사;

import java.util.*;

public class 외톨이_알파벳 {

    public String solution(String input_string) {
        StringBuilder sb = new StringBuilder();
        Set<Character> appeared = new HashSet<>();
        Set<Character> answerSet = new TreeSet<>();
        char prev = ' ';

        for (char c : input_string.toCharArray()) {
            if (c != prev) {
                if (appeared.contains(c)) {
                    answerSet.add(c);
                } else {
                    appeared.add(c);
                }

                prev = c;
            }
        }

        for (char c : answerSet) {
            sb.append(c);
        }

        return sb.length() == 0 ? "N" : sb.toString();
    }
}
