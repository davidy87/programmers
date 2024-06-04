package lv2;

import java.util.*;

public class 배달 {

    public int solution(int N, int[][] road, int K) {
        Map<Integer, Set<int[]>> map = createMap(road);
        return bfs(map, N, K);
    }

    private int bfs(Map<Integer, Set<int[]>> map, int N, int K) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[] visited = new int[N + 1];
        queue.offer(new int[] {1, 0});

        for (int i = 2; i <= N; i++) {
            visited[i] = -1;
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int u = cur[0];
            int dist = cur[1];

            for (int[] next : map.get(u)) {
                int v = next[0];
                int newDist = dist + next[1];

                if (visited[v] == -1 || newDist < visited[v]) {
                    visited[v] = newDist;
                    queue.offer(new int[] {v, newDist});
                }
            }
        }

        for (int i = 1; i < visited.length; i++) {
            if (visited[i] <= K) {
                count++;
            }
        }

        return count;
    }

    private Map<Integer, Set<int[]>> createMap(int[][] road) {
        Map<Integer, Set<int[]>> map = new HashMap<>();

        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int c = r[2];

            if (!map.containsKey(a)) {
                map.put(a, new HashSet<>());
            }

            if (!map.containsKey(b)) {
                map.put(b, new HashSet<>());
            }

            map.get(a).add(new int[] {b, c});
            map.get(b).add(new int[] {a, c});
        }

        return map;
    }
}
