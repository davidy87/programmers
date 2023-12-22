package lv2;

public class 가장_큰_정사각형_찾기 {

    public int solution(int[][] board) {
        int answer = 0;

        if (board.length < 2 && board[0].length < 2) {
            return board[0][0];
        }

        for (int r = 1; r < board.length; r++) {
            for (int c = 1; c < board[0].length; c++) {
                if (board[r][c] == 1) {
                    board[r][c] = Math.min(board[r - 1][c], Math.min(board[r][c - 1], board[r - 1][c - 1])) + 1;
                }

                answer = Math.max(answer, board[r][c]);
            }
        }

        return (int) Math.pow(answer, 2);
    }
}
