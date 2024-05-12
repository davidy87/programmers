package lv2;

public class _2xn_타일링 {

    private static final int DIV = 1_000_000_007;

    public int solution(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 2] % DIV + dp[i - 1] % DIV;
        }

        return dp[n - 1] % DIV;
    }
}
