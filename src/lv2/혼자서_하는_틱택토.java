package lv2;

public class 혼자서_하는_틱택토 {

    public int solution(String[] board) {
        int numO = count(board, 'O');
        int numX = count(board, 'X');

        if (numO < numX) {
            return 0;
        }

        if (numO == numX) {
            if (checkRowCol(board, 'O') + checkDiag(board, 'O') < 2) {
                return 0;
            }
        } else {
            if (numO - numX >= 2 || checkRowCol(board, 'X') + checkDiag(board, 'X') < 2) {
                return 0;
            }
        }

        return 1;
    }

    private int checkDiag(String[] board, char target) {
        int diag1Count = 0;
        int diag2Count = 0;

        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(i) == target) {
                diag1Count++;
            }

            if (board[i].charAt(2 - i) == target) {
                diag2Count++;
            }
        }

        if (diag1Count == 3 || diag2Count == 3) {
            return 0;
        }

        return 1;
    }

    private int checkRowCol(String[] board, char target) {
        for (int r = 0; r < 3; r++) {
            int rowCount = 0;
            int colCount = 0;

            for (int c = 0; c < 3; c++) {
                if (board[r].charAt(c) == target) {
                    rowCount++;
                }

                if (board[c].charAt(r) == target) {
                    colCount++;
                }
            }

            if (rowCount == 3 || colCount == 3) {
                return 0;
            }
        }

        return 1;
    }

    private int count(String[] board, char target) {
        int count = 0;

        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                if (board[r].charAt(c) == target) {
                    count++;
                }
            }
        }

        return count;
    }
}
