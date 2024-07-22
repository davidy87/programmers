package lv2;

import java.util.*;

public class 석유_시추 {

    private static final int[] dr = {0, 1, 0, -1};
    private static final int[] dc = {1, 0, -1, 0};

    public int solution(int[][] land) {
        int answer = 0;
        int[][] map = land;
        int mark = 2;
        Map<Integer, Integer> extracted = new HashMap<>();

        for (int r = 0; r < land.length; r++) {
            for (int c = 0; c < land[0].length; c++) {
                if (land[r][c] == 1) {
                    int count = extract(map, r, c, mark);
                    extracted.put(mark++, count);
                }
            }
        }

        for (int c = 0; c < land[0].length; c++) {
            Set<Integer> markSet = new HashSet<>();
            int totalCount = 0;

            for (int r = 0; r < land.length; r++) {
                if (map[r][c] == 0) {
                    continue;
                }

                markSet.add(map[r][c]);
            }

            for (int m : markSet) {
                totalCount += extracted.get(m);
            }

            answer = Math.max(totalCount, answer);
        }

        return answer;
    }

    private int extract(int[][] map, int r, int c, int mark) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {r, c});
        map[r][c] = mark;
        int count = 1;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newR = cur[0] + dr[i];
                int newC = cur[1] + dc[i];

                if (inBound(map, newR, newC) && map[newR][newC] == 1) {
                    queue.offer(new int[] {newR, newC});
                    map[newR][newC] = mark;
                    count++;
                }
            }
        }

        return count;
    }

    private boolean inBound(int[][] map, int r, int c) {
        return r >= 0 && r < map.length && c >= 0 && c < map[0].length;
    }
}
