package lv2;

public class 올바른_괄호 {

    public boolean solution(String s) {
        int numOpen = 0;

        for (char c : s.toCharArray()) {
            numOpen += c == '(' ? 1 : -1;

            if (numOpen < 0) {
                return false;
            }
        }

        return numOpen == 0;
    }
}
