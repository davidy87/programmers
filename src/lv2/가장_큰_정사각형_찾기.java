package lv2;

public class 가장_큰_정사각형_찾기 {

    public int solution(int[][] board) {
        int answer = (int) Math.pow(board[0][0], 2);

        for (int r = 1; r < board.length; r++) {
            for (int c = 1; c < board[r].length; c++) {
                if (board[r][c] == 1) {
                    int n1 = board[r - 1][c];
                    int n2 = board[r][c - 1];
                    int n3 = board[r - 1][c - 1];
                    board[r][c] = Math.min(n1, Math.min(n2, n3)) + 1;
                    answer = Math.max((int) Math.pow(board[r][c], 2), answer);
                }
            }
        }

        return answer;
    }
}
