package lv2;

import java.util.*;

public class 리코쳇_로봇 {
    private static final char START = 'R';
    private static final char OBSTACLE = 'D';
    private static final char GOAL = 'G';

    private static final int[] dr = {0, 1, 0, -1};
    private static final int[] dc = {1, 0, -1, 0};

    public int solution(String[] board) {
        int[] startPos = findStartPos(board);
        return bfs(board, startPos);
    }

    private int bfs(String[] board, int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start[0], start[1], 0});
        int[][] record = new int[board.length][board[0].length()];

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            record[cur[0]][cur[1]] = cur[2];

            if (board[cur[0]].charAt(cur[1]) == GOAL) {
                return cur[2];
            }

            for (int i = 0; i < 4; i++) {
                int newR = cur[0];
                int newC = cur[1];
                int newCount = cur[2] + 1;

                while (inBound(board, newR, newC) && board[newR].charAt(newC) != OBSTACLE) {
                    newR += dr[i];
                    newC += dc[i];
                }

                newR -= dr[i];
                newC -= dc[i];

                if (record[newR][newC] == 0 || newCount < record[newR][newC]) {
                    queue.offer(new int[] {newR, newC, newCount});
                }
            }
        }

        return -1;
    }

    private boolean inBound(String[] board, int r, int c) {
        return r >= 0 && r < board.length && c >= 0 && c < board[r].length();
    }

    private int[] findStartPos(String[] board) {
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length(); c++) {
                if (board[r].charAt(c) == START) {
                    return new int[] {r, c};
                }
            }
        }

        return new int[2];
    }
}
