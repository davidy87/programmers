package greedy;

import java.util.*;

/**
 * Kruskal's Algorithm 사용
 */
public class 섬_연결하기 {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] cost : costs) {
            int u = findParent(parent, cost[0]);
            int v = findParent(parent, cost[1]);
            int c = cost[2];

            if (u != v) {
                answer += c;
                parent[v] = u;
            }
        }

        return answer;
    }

    private int findParent(int[] parent, int node) {
        if (parent[node] == node) {
            return node;
        }

        return parent[node] = findParent(parent, parent[node]);
    }
}
