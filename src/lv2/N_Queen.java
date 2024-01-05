package lv2;

// Backtracking
public class N_Queen {

    private static int[] board;
    private static int answer;

    public int solution(int n) {
        board = new int[n];
        search(0, n);

        return answer;
    }

    private void search(int r, int n) {
        if (r == n) {
            answer++;
            return;
        }

        for (int c = 0; c < n; c++) {
            board[r] = c;

            if (isValid(r)) {
                search(r + 1, n);
            }
        }
    }

    private boolean isValid(int r) {
        for (int i = 0; i < r; i++) {
            if (board[r] == board[i] || r - i == Math.abs(board[r] - board[i])) {
                return false;
            }
        }

        return true;
    }
}
