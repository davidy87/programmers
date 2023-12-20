package kakao_intern_2021;

import java.util.*;

public class 거리두기_확인하기 {

    private static final int[] dr = {0, 1, 0, -1};
    private static final int[] dc = {1, 0, -1, 0};
    private static final int N = 5;

    public int[] solution(String[][] places) {
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            String[] room = places[i];
            boolean isSafe = true;

            for (int r = 0; r < N && isSafe; r++) {
                for (int c = 0; c < N && isSafe; c++) {
                    if (room[r].charAt(c) == 'P') {
                        isSafe = bfs(room, new int[] {r, c});
                    }
                }
            }

            if (isSafe) {
                answer[i] = 1;
            }
        }

        return answer;
    }

    private boolean bfs(String[] room, int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newR = cur[0] + dr[i];
                int newC = cur[1] + dc[i];
                boolean inBound = newR >= 0 && newR < N && newC >= 0 && newC < N;
                int manhDist = Math.abs(start[0] - newR) + Math.abs(start[1] - newC);

                if (!inBound || (newR == start[0] && newC == start[1])) {
                    continue;
                }

                char next = room[newR].charAt(newC);

                if (next == 'O' && manhDist < 2) {
                    queue.offer(new int[] {newR, newC});
                } else if (next == 'P' && manhDist <= 2) {
                    return false;
                }
            }
        }

        return true;
    }
}
