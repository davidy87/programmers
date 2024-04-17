package algo.bfs_dfs;

import java.util.*;

/**
 * Dijkstra
 */
public class 부대복귀 {

    private static final int MAX = Integer.MAX_VALUE;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, MAX);
        Map<Integer, Set<Integer>> map = createMap(roads);

        bfs(map, dist, destination);

        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]] < MAX ? dist[sources[i]] : -1;
        }

        return answer;
    }

    private void bfs(Map<Integer, Set<Integer>> map, int[] dist, int dest) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(dest);
        dist[dest] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : map.get(cur)) {
                if (dist[next] > dist[cur] + 1) {
                    dist[next] = dist[cur] + 1;
                    queue.offer(next);
                }
            }
        }
    }

    private Map<Integer, Set<Integer>> createMap(int[][] roads) {
        Map<Integer, Set<Integer>> map = new HashMap<>();

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];

            if (!map.containsKey(u)) {
                map.put(u, new HashSet<>());
            }

            if (!map.containsKey(v)) {
                map.put(v, new HashSet<>());
            }

            map.get(u).add(v);
            map.get(v).add(u);
        }

        return map;
    }
}
