package lv3;

public class 최적의_행렬_곱셈 {

    public int solution(int[][] matrix_sizes) {
        int n = matrix_sizes.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    dp[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 1; i < n; i++) {
            for (int s = 0; s < n - i; s++) {
                int e = s + i;

                for (int m = s; m < e; m++) {
                    int count = matrix_sizes[s][0] * matrix_sizes[m][1] * matrix_sizes[e][1];
                    dp[s][e] = Math.min(dp[s][e], dp[s][m] + dp[m + 1][e] + count);
                }
            }
        }

        return dp[0][n - 1];
    }
}
