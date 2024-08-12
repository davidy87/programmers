package algo.graph;

import java.util.*;

public class 가장_먼_노드 {

    public int solution(int n, int[][] edge) {
        Map<Integer, List<Integer>> conn = makeConn(edge);
        return search(conn);
    }

    private int search(Map<Integer, List<Integer>> conn) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[conn.size() + 1];
        Map<Integer, List<Integer>> distMap = new HashMap<>();
        int maxDist = 0;

        queue.offer(new int[] {1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int u = cur[0];
            int dist = cur[1];

            if (!distMap.containsKey(dist)) {
                distMap.put(dist, new ArrayList<>());
            }

            distMap.get(dist).add(u);
            maxDist = Math.max(dist, maxDist);

            for (int v : conn.get(u)) {
                if (!visited[v]) {
                    visited[v] = true;
                    queue.offer(new int[] {v, dist + 1});
                }
            }
        }

        return distMap.get(maxDist).size();
    }

    private Map<Integer, List<Integer>> makeConn(int[][] edge) {
        Map<Integer, List<Integer>> conn = new HashMap<>();

        for (int[] e : edge) {
            if (!conn.containsKey(e[0])) {
                conn.put(e[0], new ArrayList<>());
            }

            if (!conn.containsKey(e[1])) {
                conn.put(e[1], new ArrayList<>());
            }

            conn.get(e[0]).add(e[1]);
            conn.get(e[1]).add(e[0]);
        }

        return conn;
    }
}
