package lv3;

public class 미로_탈출_명령어 {

    private static final String[] DIRS = {"d", "l", "r", "u"};
    private static final int[] DX = {1, 0, 0, -1};
    private static final int[] DY = {0, -1, 1, 0};
    private static final String IMPOSSIBLE = "impossible";

    private String answer = IMPOSSIBLE;
    private StringBuilder route;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        route = new StringBuilder(k);
        dfs(n, m, new int[] {x, y}, new int[] {r, c}, k);
        return answer;
    }

    private void dfs(int n, int m, int[] cur, int[] end, int k) {
        if (!answer.equals(IMPOSSIBLE) || !isPossible(cur, end, k)) {
            return;
        }

        if (k == 0 && getDist(cur, end) == 0) {
            answer = route.toString();
            return;
        }

        for (int i = 0; i < DIRS.length; i++) {
            int newX = cur[0] + DX[i];
            int newY = cur[1] + DY[i];
            int[] next = {newX, newY};

            if (inBound(n, m, newX, newY)) {
                route.append(DIRS[i]);
                dfs(n, m, next, end, k - 1);
                route.delete(route.length() - 1, route.length());
            }
        }
    }

    private boolean isPossible(int[] cur, int[] end, int k) {
        int curDist = getDist(cur, end);

        if (curDist > k || (k - curDist) % 2 == 1) {
            return false;
        }

        return true;
    }

    private int getDist(int[] cur, int[] end) {
        return Math.abs(end[0] - cur[0]) + Math.abs(end[1] - cur[1]);
    }

    private boolean inBound(int n, int m, int x, int y) {
        return x >= 1 && x <= n && y >= 1 && y <= m;
    }
}
