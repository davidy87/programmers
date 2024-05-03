package lv2;

import java.util.*;

public class 스킬트리 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        Set<Character> skillSet = new HashSet<>();

        for (char s : skill.toCharArray()) {
            skillSet.add(s);
        }

        for (String st : skill_trees) {
            int i = 0;
            boolean isValid = true;

            for (char s : st.toCharArray()) {
                if (!skillSet.contains(s)) {
                    continue;
                }

                if (skill.charAt(i++) != s) {
                    isValid = false;
                    break;
                }
            }

            answer += isValid ? 1 : 0;
        }

        return answer;
    }
}
