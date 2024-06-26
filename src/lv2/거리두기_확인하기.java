package lv2;

import java.util.LinkedList;
import java.util.Queue;

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

    /**
     * Faster solution
     * @param places
     * @return
     */
    public int[] solution2(String[][] places) {
        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            String[] place = places[i];
            boolean isSafe = true;

            for (int r = 0; r < N && isSafe; r++) {
                for (int c = 0; c < N && isSafe; c++) {
                    char seat = place[r].charAt(c);

                    if (seat == 'P' || seat == 'O') {
                        isSafe = isPlaceSafe(place, new int[] {r, c}, seat);
                    }
                }
            }

            if (isSafe) {
                answer[i] = 1;
            }
        }

        return answer;
    }

    private boolean isPlaceSafe(String[] place, int[] pos, char curSeat) {
        int count = curSeat == 'P' ? 1 : 0;

        for (int i = 0; i < 4; i++) {
            int newR = pos[0] + dr[i];
            int newC = pos[1] + dc[i];

            if (inBound(place, newR, newC)) {
                continue;
            }

            if (place[newR].charAt(newC) == 'P') {
                count++;
            }
        }

        return count < 2;
    }

    private boolean inBound(String[] place, int r, int c) {
        return r >= 0 && r < place.length && c >= 0 && c < place[0].length();
    }
}
