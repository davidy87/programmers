package lv2;

public class 멀리_뛰기 {

    private static final int DIV = 1234567;

    public long solution(int n) {
        int[] dp = new int[n + 2];

        for(int i = 0; i <= 2; i++) {
            dp[i] = i;
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 2] + dp[i - 1]) % DIV;
        }

        return dp[n];
    }
}
