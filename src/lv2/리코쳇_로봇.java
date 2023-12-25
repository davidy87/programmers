package lv2;

import java.util.*;

public class 리코쳇_로봇 {

    private static final int[] dr = {0, 1, 0, -1};
    private static final int[] dc = {1, 0, -1, 0};

    public int solution(String[] board) {
        int answer = 0;
        int[] start = new int[2];
        boolean startFound = false;

        for (int r = 0; r < board.length && !startFound; r++) {
            for (int c = 0; c < board[0].length() && !startFound; c++) {
                if (board[r].charAt(c) == 'R') {
                    start = new int[] {r, c};
                    startFound = true;
                }
            }
        }

        return search(board, start);
    }

    private int search(String[] board, int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length()];
        queue.offer(new int[] {start[0], start[1], 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            visited[cur[0]][cur[1]] = true;

            if (board[cur[0]].charAt(cur[1]) == 'G') {
                return cur[2];
            }

            for (int i = 0; i < 4; i++) {
                int newR = cur[0] + dr[i];
                int newC = cur[1] + dc[i];
                boolean inBound = newR >= 0 && newR < board.length && newC >= 0 && newC < board[0].length();

                while (inBound && board[newR].charAt(newC) != 'D') {
                    newR += dr[i];
                    newC += dc[i];
                    inBound = newR >= 0 && newR < board.length && newC >= 0 && newC < board[0].length();
                }

                newR -= dr[i];
                newC -= dc[i];

                if (!visited[newR][newC]) {
                    queue.offer(new int[] {newR, newC, cur[2] + 1});
                }
            }
        }

        return -1;
    }
}
