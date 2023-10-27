package kakao_2020_blind;

public class 파괴되지_않은_건물 {

    private static int N, M;

    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        N = board.length;
        M = board[0].length;
        int[][] sum = new int[N + 1][M + 1];

        for (int[] s : skill) {
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            int degree = s[0] == 1 ? -s[5] : s[5];

            sum[r1][c1] += degree;
            sum[r1][c2 + 1] -= degree;
            sum[r2 + 1][c1] -= degree;
            sum[r2 + 1][c2 + 1] += degree;
        }

        getResult(sum);

        return countSurvived(board, sum);
    }

    private int countSurvived(int[][] board, int[][] sum) {
        int count = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (board[r][c] + sum[r][c] >= 1) {
                    count++;
                }
            }
        }

        return count;
    }

    private void getResult(int[][] sum) {
        for (int c = 0; c < M; c++) {
            for (int r = 1; r < N; r++) {
                sum[r][c] += sum[r - 1][c];
            }
        }

        for (int r = 0; r < N; r++) {
            for (int c = 1; c < M; c++) {
                sum[r][c] += sum[r][c - 1];
            }
        }
    }
}
