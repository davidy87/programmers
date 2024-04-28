package lv2;

public class n진수_게임 {

    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder(t);
        int turn = 0;
        int curNum = 0;

        while (sb.length() < t) {
            String numStr = Integer.toString(curNum++, n);

            for (char c : numStr.toCharArray()) {
                if (turn++ % m == p - 1) {
                    sb.append(Character.toUpperCase(c));
                }

                if (sb.length() == t) {
                    break;
                }
            }
        }

        return sb.toString();
    }
}
