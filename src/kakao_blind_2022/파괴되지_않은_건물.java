package kakao_blind_2022;

public class 파괴되지_않은_건물 {

    private int N, M;

    public int solution(int[][] board, int[][] skill) {
        N = board.length;
        M = board[0].length;
        int[][] damageSum = new int[N + 1][M + 1];

        for (int[] s : skill) {
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[0] == 1 ? -s[5] : s[5];

            damageSum[r1][c1] += degree;
            damageSum[r1][c2 + 1] -= degree;
            damageSum[r2 + 1][c1] -= degree;
            damageSum[r2 + 1][c2 + 1] += degree;
        }

        action(damageSum);

        return countSurvived(board, damageSum);
    }

    private int countSurvived(int[][] board, int[][] damageSum) {
        int count = 0;

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] + damageSum[r][c] > 0) {
                    count++;
                }
            }
        }

        return count;
    }

    private void action(int[][] damageSum) {
        for (int r = 0; r <= N; r++) {
            for (int c = 1; c <= M; c++) {
                damageSum[r][c] += damageSum[r][c - 1];
            }
        }

        for (int c = 0; c <= M; c++) {
            for (int r = 1; r <= N; r++) {
                damageSum[r][c] += damageSum[r - 1][c];
            }
        }
    }
}
