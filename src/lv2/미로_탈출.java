package lv2;

import java.util.*;

public class 미로_탈출 {

    private static final int[] dr = {0, 1, 0, -1};
    private static final int[] dc = {1, 0, -1, 0};

    public int solution(String[] maps) {
        int answer = 0;
        int[] start = new int[2];
        int[] end = new int[2];
        int[] lever = new int[2];

        for (int r = 0; r < maps.length; r++) {
            for (int c = 0; c < maps[0].length(); c++) {
                if (maps[r].charAt(c) == 'S') {
                    start = new int[] {r, c};
                } else if (maps[r].charAt(c) == 'E') {
                    end = new int[] {r, c};
                } else if (maps[r].charAt(c) == 'L') {
                    lever = new int[] {r, c};
                }
            }
        }

        int tl = find(maps, start, lever);
        int te = find(maps, lever, end);

        if (tl == 0 || te == 0) {
            return -1;
        }

        return tl + te;
    }

    private int find(String[] maps, int[] start, int[] dest) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] record = new int[maps.length][maps[0].length()];
        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curTime = record[cur[0]][cur[1]];

            if (cur[0] == dest[0] && cur[1] == dest[1]) {
                return curTime;
            }

            for (int i = 0; i < 4; i++) {
                int newR = cur[0] + dr[i];
                int newC = cur[1] + dc[i];
                boolean inBound = newR >= 0 && newR < maps.length && newC >= 0 && newC < maps[0].length();

                if (!inBound || maps[newR].charAt(newC) == 'X' || record[newR][newC] != 0) {
                    continue;
                }

                queue.offer(new int[] {newR, newC});
                record[newR][newC] = curTime + 1;
            }
        }

        return 0;
    }
}
