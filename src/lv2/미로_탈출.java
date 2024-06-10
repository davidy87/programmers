package lv2;

import java.util.*;

public class 미로_탈출 {

    private static final char START = 'S';
    private static final char END = 'E';
    private static final char LEVER = 'L';
    private static final char WALL = 'X';
    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public int solution(String[] maps) {
        Map<Character, int[]> pos = new HashMap<>();

        for (int r = 0; r < maps.length; r++) {
            for (int c = 0; c < maps[r].length(); c++) {
                char cur = maps[r].charAt(c);

                if (cur == START || cur == END || cur == LEVER) {
                    pos.put(cur, new int[] {r, c});
                }
            }
        }

        int countToLever = bfs(maps, pos.get(START), pos.get(LEVER));

        if (countToLever == -1) {
            return -1;
        }

        int countToEnd = bfs(maps, pos.get(LEVER), pos.get(END));

        return countToEnd == -1 ? -1 : countToLever + countToEnd;
    }

    private int bfs(String[] maps, int[] start, int[] end) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[maps.length][maps[0].length()];
        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int dist = visited[cur[0]][cur[1]];

            if (cur[0] == end[0] && cur[1] == end[1]) {
                return dist;
            }

            for (int i = 0; i < dx.length; i++) {
                int newX = cur[0] + dx[i];
                int newY = cur[1] + dy[i];
                int newDist = dist + 1;

                if (isValid(maps, visited, newX, newY, newDist)) {
                    visited[newX][newY] = newDist;
                    queue.offer(new int[] {newX, newY, newDist});
                }
            }
        }

        return -1;
    }

    private boolean isValid(String[] maps, int[][] visited, int x, int y, int newDist) {
        boolean inBound = x >= 0 && x < maps.length && y >= 0 && y < maps[0].length();
        return inBound && maps[x].charAt(y) != WALL && visited[x][y] == 0;
    }
}
