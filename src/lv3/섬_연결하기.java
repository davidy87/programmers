package lv3;

import java.util.*;

public class 섬_연결하기 {

    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] parent = new int[n];
        Arrays.sort(costs, Comparator.comparingInt(c -> c[2]));

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for (int[] c : costs) {
            int u = findParent(parent, c[0]);
            int v = findParent(parent, c[1]);

            if (u != v) {
                answer += c[2];
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
