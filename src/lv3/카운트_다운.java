package lv3;

public class 카운트_다운 {

    private static final int MAX = 100_000;

    public int[] solution(int target) {
        int[][] dp = new int[target + 1][2];

        for (int i = 1; i <= target; i++) {
            dp[i][0] = MAX;
            dp[i][1] = 0;
        }

        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i >= 50) {
                    shotSingleOrBull(dp, i, 50);
                }

                if (i >= j) {
                    shotSingleOrBull(dp, i, j);
                }

                if (i >= j * 2) {
                    shotDoubleOrTriple(dp, i, j * 2);
                }

                if (i >= j * 3) {
                    shotDoubleOrTriple(dp, i, j * 3);
                }
            }
        }

        return new int[] {dp[target][0], dp[target][1]};
    }

    private void shotDoubleOrTriple(int[][] dp, int i, int j) {
        if (dp[i][0] > dp[i - j][0] + 1) {
            dp[i][0] = dp[i - j][0] + 1;
            dp[i][1] = dp[i - j][1];
        }
    }

    private void shotSingleOrBull(int[][] dp, int i, int j) {
        if (dp[i][0] > dp[i - j][0] + 1) {
            dp[i][0] = dp[i - j][0] + 1;
            dp[i][1] = dp[i - j][1] + 1;
        } else if (dp[i][0] == dp[i - j][0] + 1) {
            dp[i][1] = Math.max(dp[i][1], dp[i - j][1] + 1);
        }
    }
}
