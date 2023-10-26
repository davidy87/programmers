package kakao_2020_blind;

public class 양과_늑대 {
    private static int maxSheep = 0;

    public int solution(int[] info, int[][] edges) {
        boolean[] visited = new boolean[info.length];
        dfs(0, 0, 0, visited, info, edges);

        return maxSheep;
    }

    private void dfs(int node, int numSheep, int numWolf, boolean[] visited, int[] info, int[][] edges) {
        visited[node] = true;

        if (info[node] == 0) {
            numSheep++;
            maxSheep = Math.max(numSheep, maxSheep);
        } else {
            numWolf++;
        }

        if (numSheep == numWolf) {
            return;
        }

        for (int[] edge : edges) {
            if (visited[edge[0]] && !visited[edge[1]]) {
                dfs(edge[1], numSheep, numWolf, visited.clone(), info, edges);
            }
        }
    }
}
