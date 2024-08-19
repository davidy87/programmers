package lv3;

import java.util.LinkedList;
import java.util.Queue;

public class 경주로_건설 {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public int solution(int[][] board) {
        return bfs(board);
    }

    private int bfs(int[][] board) {
        Queue<Road> queue = new LinkedList<>();
        queue.offer(new Road(0, 0, 0, new int[] {0, 0}));
        int n = board.length;

        while (!queue.isEmpty()) {
            Road curRoad = queue.poll();

            for (int i = 0; i < 4; i++) {
                int newX = curRoad.x + dx[i];
                int newY = curRoad.y + dy[i];

                if (inBound(n, newX, newY) && board[newX][newY] != 1) {
                    int newCost = curRoad.cost;

                    if (isNewRoadStraight(curRoad, dx[i], dy[i])) {
                        newCost += 100;
                    } else {
                        newCost += 600;
                    }

                    if (board[newX][newY] == 0 || newCost <= board[newX][newY]) {
                        board[newX][newY] = newCost;
                        queue.offer(new Road(newX, newY, newCost, new int[] {dx[i], dy[i]}));
                    } else if (newCost <= board[newX][newY] + 500) {
                        queue.offer(new Road(newX, newY, newCost, new int[] {dx[i], dy[i]}));
                    }
                }
            }
        }

        return board[n - 1][n - 1];
    }

    private boolean isNewRoadStraight(Road road, int dx, int dy) {
        int x = road.dir[0];
        int y = road.dir[1];

        return (x == 0 && y == 0) || (x == dx && y == dy);
    }

    private boolean inBound(int n, int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }

    private static class Road {

        int x;

        int y;

        int cost;

        int[] dir;

        public Road(int x, int y, int cost, int[] dir) {
            this.x = x;
            this.y = y;
            this.cost = cost;
            this.dir = dir;
        }
    }
}
