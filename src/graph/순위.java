package graph;

/**
 * Floyd-Warshall algorithm 사용
 */
public class 순위 {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] match = getMatchResult(n, results);

        return countCompleted(n, match);
    }

    private int countCompleted(int n, int[][] match) {
        int numCompleted = 0;

        for (int[] row : match) {
            int count = 0;

            for (int result : row) {
                if (result != 0) {
                    count++;
                }
            }

            if (count == n - 1) {
                numCompleted++;
            }
        }

        return numCompleted;
    }

    private int[][] getMatchResult(int n, int[][] results) {
        int[][] match = new int[n + 1][n + 1];

        for (int[] result : results) {
            match[result[0]][result[1]] = 1;
            match[result[1]][result[0]] = -1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (match[i][k] == 1 && match[k][j] == 1) {
                        match[i][j] = 1;
                        match[j][i] = -1;
                    }
                }
            }
        }

        return match;
    }
}
