package algo.dp;

public class 등굣길 {

    private static final int DIV = 1_000_000_007;

    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[n + 1][m + 1];
        boolean[][] flags = new boolean[n + 1][m + 1];

        map[1][1] = 1;

        for (int[] p : puddles) {
            flags[p[1]][p[0]] = true;
        }

        for (int r = 1; r <= n; r++) {
            for (int c = 1; c <= m; c++) {
                if (!(r == 1 && c == 1) && !flags[r][c]) {
                    map[r][c] = (map[r - 1][c] + map[r][c - 1]) % DIV;
                }
            }
        }

        return map[n][m];
    }
}
