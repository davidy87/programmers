package algo.greedy;

import java.util.*;

/**
 * Kruskal's Algorithm 사용
 */
public class 섬_연결하기 {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        int[] conn = new int[n];
        Arrays.sort(costs, Comparator.comparingInt(c -> c[2]));

        for (int i = 0; i < n; i++) {
            conn[i] = i;
        }

        for (int[] c : costs) {
            int u = findConnEnd(conn, c[0]);
            int v = findConnEnd(conn, c[1]);

            if (u != v) {
                answer += c[2];
                conn[v] = u;
            }
        }

        return answer;
    }

    private int findConnEnd(int[] conn, int start) {
        if (conn[start] == start) {
            return start;
        }

        return conn[start] = findConnEnd(conn, conn[start]);
    }
}
