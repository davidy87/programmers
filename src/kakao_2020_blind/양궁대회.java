package kakao_2020_blind;

import java.util.*;

public class 양궁대회 {
    private static int[] ryan;
    private static int maxDiff = -1;

    public int[] solution(int n, int[] info) {
        int[] ryanInfo = new int[info.length];
        findBestScore(0, n, info, ryanInfo);

        if (maxDiff == -1) {
            return new int[] {-1};
        }

        return ryan;
    }

    private void findBestScore(int count, int n, int[] apeachInfo, int[] ryanInfo) {
        if (count == n) {
            int diff = getDiff(apeachInfo, ryanInfo);

            if (maxDiff <= diff) {
                maxDiff = diff;
                ryan = Arrays.copyOf(ryanInfo, ryanInfo.length);
            }

            return;
        }

        for (int i = 0; i < apeachInfo.length && ryanInfo[i] <= apeachInfo[i]; i++) {
            ryanInfo[i]++;
            findBestScore(count + 1, n, apeachInfo, ryanInfo);
            ryanInfo[i]--;
        }
    }

    private int getDiff(int[] apeachInfo, int[] ryanInfo) {
        int ryanScore = 0;
        int apeachScore = 0;

        for (int i = 0; i < ryanInfo.length; i++) {
            if (apeachInfo[i] == 0 && ryanInfo[i] == 0) {
                continue;
            }

            if (apeachInfo[i] < ryanInfo[i]) {
                ryanScore += 10 - i;
            } else {
                apeachScore += 10 - i;
            }
        }

        int diff = ryanScore - apeachScore;

        return diff <= 0 ? -1 : diff;
    }
}
