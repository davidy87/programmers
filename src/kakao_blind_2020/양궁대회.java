package kakao_blind_2020;

public class 양궁대회 {
    private static int[] ryan;
    private static int maxDiff = -1;

    public int[] solution(int n, int[] info) {
        findBestResult(0, n, info, new int[info.length]);

        if (maxDiff == -1) {
            return new int[] {-1};
        }

        return ryan;
    }

    private void findBestResult(int count, int n, int[] apeachInfo, int[] ryanInfo) {
        if (count == n) {
            int diff = getDiff(apeachInfo, ryanInfo);

            if (maxDiff <= diff) {
                ryan = ryanInfo.clone();
                maxDiff = diff;
            }

            return;
        }

        for (int i = 0; i < apeachInfo.length && ryanInfo[i] <= apeachInfo[i]; i++) {
            ryanInfo[i]++;
            findBestResult(count + 1, n, apeachInfo, ryanInfo);
            ryanInfo[i]--;
        }
    }

    private int getDiff(int[] apeachInfo, int[] ryanInfo) {
        int apeachScore = 0;
        int ryanScore = 0;

        for (int i = 0; i < apeachInfo.length; i++) {
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
