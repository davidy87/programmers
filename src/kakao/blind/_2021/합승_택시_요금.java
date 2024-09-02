package kakao.blind._2021;

import java.util.*;

/*
    Dijkstra Algorithm
 */
public class 합승_택시_요금 {

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;
        int[][] map = createMap(fares, n);
        int[] costsFromS = dijkstra(map, n, s);
        int[] costsFromA = dijkstra(map, n, a);
        int[] costsFromB = dijkstra(map, n, b);

        for (int i = 1; i <= n; i++) {
            int cost = costsFromS[i] + costsFromA[i] + costsFromB[i];
            answer = Math.min(cost, answer);
        }

        return answer;
    }

    private int[] dijkstra(int[][] map, int n, int s) {
        Queue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node[1]));
        int[] costs = new int[n + 1];
        boolean[] visited = new boolean[n + 1];

        Arrays.fill(costs, Integer.MAX_VALUE);
        queue.offer(new int[] {s, 0});
        costs[s] = 0;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int u = cur[0];

            if (visited[u]) {
                continue;
            }

            for (int v = 1; v <= n; v++) {
                if (map[u][v] == 0) {
                    continue;
                }

                int newCost = costs[u] + map[u][v];

                if (newCost < costs[v]) {
                    costs[v] = newCost;
                    queue.offer(new int[] {v, costs[v]});
                }
            }
        }

        return costs;
    }

    private int[][] createMap(int[][] fares, int n) {
        int[][] map = new int[n + 1][n + 1];

        for (int[] f : fares) {
            map[f[0]][f[1]] = f[2];
            map[f[1]][f[0]] = f[2];
        }

        return map;
    }
}
