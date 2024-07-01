package lv2;

public class 혼자서_하는_틱택토 {

    public int solution(String[] board) {
        int numO = count(board, 'O');
        int numX = count(board, 'X');

        if (numO - numX < 0 || numO - numX > 1) {
            return 0;
        }

        if (numO == numX) {
            if (checkRowCol(board, 'O') || checkDiag(board, 'O')) {
                return 0;
            }
        } else if (checkRowCol(board, 'X') || checkDiag(board, 'X'))  {
            return 0;
        }

        return 1;
    }

    private boolean checkDiag(String[] board, char target) {
        int numDiag1 = 0;
        int numDiag2 = 0;

        for (int i = 0; i < board.length; i++) {
            if (board[i].charAt(i) == target) {
                numDiag1++;
            }

            if (board[i].charAt(2 - i) == target) {
                numDiag2++;
            }
        }

        return numDiag1 == 3 || numDiag2 == 3;
    }

    private boolean checkRowCol(String[] board, char target) {
        for (int i = 0; i < board.length; i++) {
            int numRow = 0;
            int numCol = 0;

            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == target) {
                    numRow++;
                }

                if (board[j].charAt(i) == target) {
                    numCol++;
                }
            }

            if (numRow == 3 || numCol == 3) {
                return true;
            }
        }

        return false;
    }

    private int count(String[] board, char target) {
        int count = 0;

        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == target) {
                    count++;
                }
            }
        }

        return count;
    }
}
