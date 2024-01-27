package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class 가장_먼_노드 {

    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[] dists = new int[n + 1];
        List<Integer>[] graph = new LinkedList[n + 1];

        for (int[] e : edge) {
            if (graph[e[0]] == null) {
                graph[e[0]] = new LinkedList<>();
            }

            if (graph[e[1]] == null) {
                graph[e[1]] = new LinkedList<>();
            }

            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        int maxDist = bfs(graph, dists);

        for (int dist : dists) {
            if (dist == maxDist) {
                answer++;
            }
        }

        return answer;
    }

    private int bfs(List<Integer>[] graph, int[] dists) {
        int maxDist = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int neighbor : graph[cur]) {
                if (neighbor != 1 && dists[neighbor] == 0) {
                    queue.offer(neighbor);
                    dists[neighbor] = dists[cur] + 1;
                    maxDist = Math.max(maxDist, dists[neighbor]);
                }
            }
        }

        return maxDist;
    }
}
