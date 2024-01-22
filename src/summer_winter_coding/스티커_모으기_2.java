package summer_winter_coding;

import java.util.Arrays;

public class 스티커_모으기_2 {

    public int solution(int[] sticker) {
        int n = sticker.length;

        if (n <= 3) {
            return Arrays.stream(sticker).max().getAsInt();
        }

        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        dp1[0] = sticker[0];
        dp1[1] = sticker[0];
        dp2[1] = sticker[1];

        for (int i = 2; i < n; i++) {
            if (i < n - 1) {
                dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + sticker[i]);
            }

            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + sticker[i]);
        }

        return Math.max(dp1[n - 2], dp2[n - 1]);
    }
}
