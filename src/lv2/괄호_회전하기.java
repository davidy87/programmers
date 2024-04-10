package lv2;

import java.util.*;

public class 괄호_회전하기 {

    private static final Set<String> brackets = Set.of("[]", "{}", "()");

    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            if (isCorrect(s)) {
                answer++;
            }

            s = s.substring(1) + s.charAt(0);
        }

        return answer;
    }

    private boolean isCorrect(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '[' || c == '{' || c == '(') {
                stack.push(c);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }

            String bracket = "" + stack.peek() + c;

            if (brackets.contains(bracket)) {
                stack.pop();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
