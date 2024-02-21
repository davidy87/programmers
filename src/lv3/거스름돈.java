package lv3;

import java.util.Arrays;

public class 거스름돈 {

    private static final int DIV = 1_000_000_007;

    public int solution(int n, int[] money) {
        Arrays.sort(money);
        int[] dp = new int[n + 1];
        dp[0] = 1;

        for (int m : money) {
            for (int i = m; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - m]) % DIV;
            }
        }

        return dp[n];
    }
}
