package lv3;

public class 정수_삼각형 {

    public int solution(int[][] triangle) {
        int answer = 0;

        for (int i = 0; i < triangle.length - 1; i++) {
            int[] dp = new int[triangle[i + 1].length];

            for (int j = 0; j < triangle[i].length; j++) {
                dp[j] = Math.max(triangle[i][j] + triangle[i + 1][j], dp[j]);
                dp[j + 1] = Math.max(triangle[i][j] + triangle[i + 1][j + 1], dp[j + 1]);
                answer = Math.max(dp[j], answer);
            }

            triangle[i + 1] = dp;
        }

        return answer;
    }
}
