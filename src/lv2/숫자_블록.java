package lv2;

public class 숫자_블록 {

    public int[] solution(long begin, long end) {
        int[] answer = new int[(int) (end - begin) + 1];

        for (int n = (int) begin; n <= end; n++) {
            answer[n - (int) begin] = getMaxDiv(n);
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
                div = Math.max(div, i);

                if (n / i <= 10_000_000) {
                    return n / i;
                }
            }
        }

        return div;
    }
}
