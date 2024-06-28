package lv2;

// Backtracking
public class N_Queen {

    private int[] board;
    private int answer;

    public int solution(int n) {
        board = new int[n];
        answer = 0;
        search(n, 0);

        return answer;
    }

    private void search(int n, int row) {
        if (row == n) {
            answer++;
            return;
        }

        for (int col = 0; col < n; col++) {
            board[row] = col;

            if (isValid(row)) {
                search(n, row + 1);
            }
        }
    }

    private boolean isValid(int row) {
        for (int i = 0; i < row; i++) {
            if (board[row] == board[i] || row - i == Math.abs(board[row] - board[i])) {
                return false;
            }
        }

        return true;
    }
}
