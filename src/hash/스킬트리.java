package hash;

import java.util.*;

public class 스킬트리 {

    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            int i = 0;
            boolean valid = true;

            for (String s : skillTree.split("")) {
                if (!skill.contains(s)) {
                    continue;
                }

                if (!s.equals(String.valueOf(skill.charAt(i)))) {
                    valid = false;
                    break;
                }

                i++;
            }

            if (valid) {
                answer++;
            }
        }

        return answer;
    }
}
