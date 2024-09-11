package kakao.blind._2022;

import java.util.*;

public class 양과_늑대 {

    private static final int SHEEP = 0;

    private static final int WOLF = 1;

    private int maxNumSheep = 1;

    public int solution(int[] info, int[][] edges) {
        boolean[] visited = new boolean[info.length];
        dfs(info, edges, visited, 0, 0, 0);

        return maxNumSheep;
    }

    private void dfs(int[] info, int[][] edges, boolean[] visited, int cur, int numSheep, int numWolf) {
        visited[cur] = true;

        switch (info[cur]) {
            case SHEEP -> maxNumSheep = Math.max(++numSheep, maxNumSheep);
            case WOLF -> numWolf++;
        }

        if (numSheep == numWolf) {
            return;
        }

        for (int[] e : edges) {
            if (visited[e[0]] && !visited[e[1]]) {
                dfs(info, edges, Arrays.copyOf(visited, visited.length), e[1], numSheep, numWolf);
            }
        }
    }
}
