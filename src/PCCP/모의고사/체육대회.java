package PCCP.모의고사;

public class 체육대회 {

    private static int maxScore = 0;

    public int solution(int[][] ability) {
        dfs(ability, new boolean[ability.length], 0, 0);

        return maxScore;
    }

    private void dfs(int[][] ability, boolean[] selected, int idx, int score) {
        if (idx == ability[0].length) {
            maxScore = Math.max(score, maxScore);
            return;
        }

        for (int i = 0; i < ability.length; i++) {
            if (!selected[i]) {
                selected[i] = true;
                dfs(ability, selected, idx + 1, score + ability[i][idx]);
                selected[i] = false;
            }
        }
    }
}
