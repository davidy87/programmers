package lv2;

import java.util.*;

public class 전력망을_둘로_나누기 {
    public int solution(int n, int[][] wires) {
        int answer = n;
        boolean[][] conn = makeConnection(n, wires);

        for (int[] w : wires) {
            conn[w[0]][w[1]] = false;
            conn[w[1]][w[0]] = false;
            answer = Math.min(answer, getDiff(n, conn));
            conn[w[0]][w[1]] = true;
            conn[w[1]][w[0]] = true;
        }

        return answer;
    }

    private int getDiff(int n, boolean[][] conn) {
        int count = 0;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n + 1];
        queue.offer(1);

        while (!queue.isEmpty()) {
            int v1 = queue.poll();
            visited[v1] = true;
            count++;

            for (int v2 = 1; v2 <= n; v2++) {
                if (!visited[v2] && conn[v1][v2]) {
                    queue.offer(v2);
                }
            }
        }

        return Math.abs(n - count * 2);
    }

    private boolean[][] makeConnection(int n, int[][] wires) {
        boolean[][] conn = new boolean[n + 1][n + 1];

        for (int[] w : wires) {
            conn[w[0]][w[1]] = true;
            conn[w[1]][w[0]] = true;
        }

        return conn;
    }
}
