package lv3;

public class 파괴되지_않은_건물 {

    public int solution(int[][] board, int[][] skill) {
        int[][] damage = new int[board.length + 1][board[0].length + 1];

        for (int[] s : skill) {
            cumulateDamage(damage, s);
        }

        calculateDamage(damage);

        return countSurvived(board, damage);
    }

    private int countSurvived(int[][] board, int[][] damage) {
        int result = 0;

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] + damage[r][c] > 0) {
                    result++;
                }
            }
        }

        return result;
    }

    private void calculateDamage(int[][] damage) {
        for (int c = 0; c < damage[0].length; c++) {
            for (int r = 1; r < damage.length; r++) {
                damage[r][c] += damage[r - 1][c];
            }
        }

        for (int r = 0; r < damage.length; r++) {
            for (int c = 1; c < damage[0].length; c++) {
                damage[r][c] += damage[r][c - 1];
            }
        }
    }

    private void cumulateDamage(int[][] damage, int[] s) {
        int type = s[0];
        int r1 = s[1];
        int c1 = s[2];
        int r2 = s[3];
        int c2 = s[4];
        int degree = type == 1 ? -s[5] : s[5];

        damage[r1][c1] += degree;
        damage[r1][c2 + 1] -= degree;
        damage[r2 + 1][c1] -= degree;
        damage[r2 + 1][c2 + 1] += degree;
    }
}
