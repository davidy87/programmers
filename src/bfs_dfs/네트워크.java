package bfs_dfs;

public class 네트워크 {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int c1 = 0; c1 < n; c1++) {
            if (!visited[c1]) {
                checkConn(computers, visited, n, c1);
                answer++;
            }
        }

        return answer;
    }

    private void checkConn(int[][] computers, boolean[] visited, int n, int c1) {
        visited[c1] = true;

        for (int c2 = 0; c2 < n; c2++) {
            if (!visited[c2] && computers[c1][c2] == 1) {
                checkConn(computers, visited, n, c2);
            }
        }
    }
}
