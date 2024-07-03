package lv2;

public class 숫자_블록 {

    public int[] solution(long begin, long end) {
        int b = (int) begin;
        int e = (int) end;
        int[] answer = new int[e - b + 1];

        for (int i = b; i <= e; i++) {
            answer[i - b] = getMaxDiv(i);
        }

        return answer;
    }

    private int getMaxDiv(int n) {
        if (n == 1) {
            return 0;
        }

        int div = 1;

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                div = i;

                if (n / i <= 10_000_000) {
                    return n / i;
                }
            }
        }

        return div;
    }
}
