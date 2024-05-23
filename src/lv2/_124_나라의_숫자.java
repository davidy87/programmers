package lv2;

public class _124_나라의_숫자 {

    private static final int[] DIGITS = {4, 1, 2};

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            sb.append(DIGITS[n % 3]);
            n = (n - 1) / 3;
        }

        return sb.reverse().toString();
    }
}
