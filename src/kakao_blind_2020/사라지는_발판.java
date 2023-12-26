package kakao_blind_2020;

public class 사라지는_발판 {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        return dfs(board, aloc, bloc);
    }

    private int dfs(int[][] board, int[] p1, int[] p2) {
        if (board[p1[0]][p1[1]] == 0) {
            return 0;
        }

        int ret = 0;

        for (int i = 0; i < dx.length; i++) {
            int newX = p1[0] + dx[i];
            int newY = p1[1] + dy[i];

            if (isValid(board, newX, newY)) {
                board[p1[0]][p1[1]] = 0;
                int val = dfs(board, p2, new int[] {newX, newY}) + 1;
                board[p1[0]][p1[1]] = 1;

                if (ret % 2 == 0 && val % 2 == 1) {
                    ret = val;
                } else if (ret % 2 == 0 && val % 2 == 0) {
                    ret = Math.max(ret, val);
                } else if (ret % 2 == 1 && val % 2 == 1) {
                    ret = Math.min(ret, val);
                }
            }
        }

        return ret;
    }

    private boolean isValid(int[][] board, int x, int y) {
        boolean inBound = x >= 0 && x < board.length && y >= 0 && y < board[0].length;

        return inBound && board[x][y] == 1;
    }
}
