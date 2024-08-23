package lv3;

import java.util.*;

/**
 * Dijkstra
 */
public class 부대복귀 {

    private static final int MAX = Integer.MAX_VALUE;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int[] dist = new int[n + 1];
        Map<Integer, List<Integer>> map = getMap(roads);
        Arrays.fill(dist, MAX);

        bfs(map, dist, destination);

        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]] != MAX ? dist[sources[i]] : -1;
        }

        return answer;
    }

    private void bfs(Map<Integer, List<Integer>> map, int[] dist, int dest) {
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

    private Map<Integer, List<Integer>> getMap(int[][] roads) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int[] road : roads) {
            if (!map.containsKey(road[0])) {
                map.put(road[0], new ArrayList<>());
            }

            if (!map.containsKey(road[1])) {
                map.put(road[1], new ArrayList<>());
            }

            map.get(road[0]).add(road[1]);
            map.get(road[1]).add(road[0]);
        }

        return map;
    }
}
