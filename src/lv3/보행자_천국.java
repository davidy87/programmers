package lv3;

public class 보행자_천국 {

    private static final int MOD = 20170805;

    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp = new int[m + 1][n + 1][2];
        dp[1][1][0] = 1;
        dp[1][1][1] = 1;

        for (int r = 1; r <= m; r++) {
            for (int c = 1; c <= n; c++) {
                int status = cityMap[r - 1][c - 1];

                if (status == 0) {
                    dp[r][c][0] += (dp[r - 1][c][0] + dp[r][c - 1][1]) % MOD;
                    dp[r][c][1] += (dp[r - 1][c][0] + dp[r][c - 1][1]) % MOD;
                } else if (status == 2) {
                    dp[r][c][0] += dp[r - 1][c][0];
                    dp[r][c][1] += dp[r][c - 1][1];
                }
            }
        }

        return dp[m][n][0];
    }
}
