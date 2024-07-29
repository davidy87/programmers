package algo.dp;

public class 등굣길 {

    private static final int DIV = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m + 1][n + 1];
        boolean[][] puddleMap = new boolean[m + 1][n + 1];

        map[1][1] = 1;

        for (int[] p : puddles) {
            puddleMap[p[0]][p[1]] = true;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (!(i == 1 && j == 1) && !puddleMap[i][j]) {
                    map[i][j] = (map[i - 1][j] + map[i][j - 1]) % DIV;
                }
            }
        }

        return map[m][n];
    }
}
