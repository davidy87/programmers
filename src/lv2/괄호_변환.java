package lv2;

public class 괄호_변환 {
    public String solution(String p) {
        return recurse(p);
    }

    private String recurse(String p) {
        if (p.isEmpty()) {
            return p;
        }

        String u = "";
        String v = "";

        for (int i = 2; i <= p.length(); i++) {
            u = p.substring(0, i);
            v = p.substring(i);

            if (isBalanced(u) && isBalanced(v)) {
                break;
            }
        }

        if (isCorrect(u)) {
            return u + recurse(v);
        }

        return "(" + recurse(v) + ")" + flip(u.substring(1, u.length() - 1));
    }

    private String flip(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c == ')') {
                sb.append('(');
            } else {
                sb.append(')');
            }
        }

        return sb.toString();
    }

    private boolean isCorrect(String s) {
        int numOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                numOpen++;
                continue;
            }

            if (--numOpen < 0) {
                return false;
            }
        }

        return numOpen == 0;
    }

    private boolean isBalanced(String s) {
        int numOpen = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                numOpen++;
            } else {
                numOpen--;
            }
        }

        return numOpen == 0;
    }
}
