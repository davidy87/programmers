package bfs_dfs;

import java.util.*;

public class 게임_맵_최단거리 {
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public int solution(int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[2]);
        int n = maps.length;
        int m = maps[0].length;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < dx.length; i++) {
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];
                boolean inBound = newX >= 0 && newX < n && newY >= 0 && newY < m;

                if (inBound && maps[newX][newY] == 1) {
                    queue.offer(new int[] {newX, newY});
                    maps[newX][newY] += maps[cur[0]][cur[1]];
                }
            }
        }

        return maps[n - 1][m - 1] == 1 ? -1 : maps[n - 1][m - 1];
    }
}
