package lv2;

public class 피보나치_수 {

    private static final int DIV = 1234567;

    public int solution(int n) {
        int[] dp = {0, 1, 1};

        for (int i = 3; i <= n; i++) {
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = (dp[0] + dp[1]) % DIV;
        }

        return dp[2];
    }
}
