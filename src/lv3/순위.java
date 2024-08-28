package lv3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class 순위 {

    /**
     * Floyd-Warshall algorithm 사용
     */
    public int solution(int n, int[][] results) {
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

    /**
     * Map 사용
     */
    public int solution2(int n, int[][] results) {
        int answer = 0;
        Map<Integer, Set<Integer>> winners = new HashMap<>();
        Map<Integer, Set<Integer>> losers = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            winners.put(i, new HashSet<>());
            losers.put(i, new HashSet<>());
        }

        for (int[] r : results) {
            winners.get(r[0]).add(r[1]);
            losers.get(r[1]).add(r[0]);
        }

        for (int i = 1; i <= n; i++) {
            for (int l : winners.get(i)) {
                losers.get(l).addAll(losers.get(i));
            }

            for (int w : losers.get(i)) {
                winners.get(w).addAll(winners.get(i));
            }
        }

        for (int i = 1; i <= n; i++) {
            if (winners.get(i).size() + losers.get(i).size() == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}
