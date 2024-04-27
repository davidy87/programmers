package lv2;

import java.util.LinkedList;
import java.util.Queue;

public class 게임_맵_최단거리 {

    private static final int[][] MOVES = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public int solution(int[][] maps) {
        return bfs(maps, new int[] {0, 0});
    }

    private int bfs(int[][] maps, int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curDist = maps[cur[0]][cur[1]];
            maps[cur[0]][cur[1]] = -1;

            if (arrived(cur, maps)){
                return curDist;
            }

            for (int[] move : MOVES) {
                int[] newMove = new int[] {cur[0] + move[0], cur[1] + move[1]};

                if (isMoveValid(newMove, maps)) {
                    queue.offer(newMove);
                    maps[newMove[0]][newMove[1]] = curDist + 1;
                }
            }
        }

        return -1;
    }

    private boolean isMoveValid(int[] pos, int[][] maps) {
        int x = pos[0];
        int y = pos[1];
        return x >= 0 && x < maps.length && y >= 0 && y < maps[0].length && maps[x][y] == 1;
    }

    private boolean arrived(int[] pos, int[][] maps) {
        return pos[0] == maps.length - 1 && pos[1] == maps[0].length - 1;
    }
}
