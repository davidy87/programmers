package lv2;

import java.util.Arrays;

public class 땅따먹기 {

    public int solution(int[][] land) {
        int n = land.length;

        for (int r = 1; r < n; r++) {
            land[r][0] += Math.max(land[r - 1][1], Math.max(land[r - 1][2], land[r - 1][3]));
            land[r][1] += Math.max(land[r - 1][0], Math.max(land[r - 1][2], land[r - 1][3]));
            land[r][2] += Math.max(land[r - 1][0], Math.max(land[r - 1][1], land[r - 1][3]));
            land[r][3] += Math.max(land[r - 1][0], Math.max(land[r - 1][1], land[r - 1][2]));
        }

        Arrays.sort(land[n - 1]);

        return land[n - 1][3];
    }
}
