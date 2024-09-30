package kakao.blind._2020;

public class 외벽_점검 {

    private int[][] allWeak;

    private boolean allFixed;

    public int solution(int n, int[] weak, int[] dist) {
        allWeak = findAllWeakOrder(weak, n);

        for (int numFriends = 1; numFriends <= dist.length; numFriends++) {
            permutations(dist, new int[numFriends], new boolean[dist.length], 0);

            if (allFixed) {
                return numFriends;
            }
        }

        return -1;
    }

    private int[][] findAllWeakOrder(int[] weak, int wallLength) {
        int n = weak.length;
        int[][] result = new int[n][n];

        for (int i = 0; i < n; i++) {
            int idx = i;
            int extend = 0;

            for (int j = 0; j < n; j++) {
                result[i][j] = weak[idx++] + extend;

                if (idx == weak.length) {
                    idx = 0;
                    extend += wallLength;
                }
            }
        }

        return result;
    }

    private void permutations(int[] dist, int[] result, boolean[] visited, int depth) {
        if (allFixed) {
            return;
        } else if (depth == result.length) {
            check(result);
            return;
        }

        for (int i = 0; i < dist.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            result[depth] = dist[i];
            permutations(dist, result, visited, depth + 1);
            visited[i] = false;
        }
    }

    private void check(int[] dist) {
        for (int[] weak : allWeak) {
            int distIdx = 0;
            int start = 0;
            boolean[] fixed = new boolean[weak.length];

            while (distIdx < dist.length) {
                int i = start;
                int d = dist[distIdx++];

                for (int j = start; j < weak.length; j++) {
                    if (weak[i] + d < weak[j]) {
                        break;
                    }

                    fixed[j] = true;
                    start++;
                }
            }

            if (isAllFixed(fixed)) {
                allFixed = true;
                return;
            }
        }
    }

    private boolean isAllFixed(boolean[] fixed) {
        for (boolean f : fixed) {
            if (!f) {
                return false;
            }
        }

        return true;
    }
}
