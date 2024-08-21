package lv3;

public class 연속_펄스_부분_수열의_합 {

    public long solution(int[] sequence) {
        long[][] dp = new long[sequence.length][2];
        dp[0][0] = sequence[0];
        dp[0][1] = -sequence[0];

        long answer = Math.max(dp[0][0], dp[0][1]);

        for (int i = 1; i < sequence.length; i++) {
            int num = sequence[i];
            dp[i][0] = Math.max(num, dp[i - 1][1] + num);
            dp[i][1] = Math.max(-num, dp[i - 1][0] - num);
            answer = Math.max(Math.max(dp[i][0], dp[i][1]), answer);
        }

        return answer;
    }
}
