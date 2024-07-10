package lv2;

public class 양궁대회 {

    private int maxScoreDiff = 0;
    private int[] ryanResult = new int[] {-1};

    public int[] solution(int n, int[] info) {
        findBestResult(n, info, new int[info.length]);
        return ryanResult;
    }

    private void findBestResult(int n, int[] apeachInfo, int[] ryanInfo) {
        if (n == 0) {
            int scoreDiff = getScoreDiff(apeachInfo, ryanInfo);

            if (maxScoreDiff != 0 && maxScoreDiff == scoreDiff) {
                ryanResult = compareResult(ryanResult, ryanInfo);
            } else if (maxScoreDiff < scoreDiff) {
                maxScoreDiff = scoreDiff;
                ryanResult = ryanInfo.clone();
            }

            return;
        }

        for (int i = 0; i < apeachInfo.length && ryanInfo[i] <= apeachInfo[i]; i++) {
            ryanInfo[i]++;
            findBestResult(n - 1, apeachInfo, ryanInfo);
            ryanInfo[i]--;
        }
    }

    private int[] compareResult(int[] ryanResult, int[] ryanInfo) {
        for (int i = ryanResult.length - 1; i >= 0; i--) {
            if (ryanInfo[i] > ryanResult[i]) {
                return ryanInfo.clone();
            }
        }

        return ryanResult;
    }

    private int getScoreDiff(int[] apeachInfo, int[] ryanInfo) {
        int apeachScore = 0;
        int ryanScore = 0;

        for (int i = 0; i < ryanInfo.length; i++) {
            int a = apeachInfo[i];
            int b = ryanInfo[i];
            int k = 10 - i;

            if (a == 0 && b == 0) {
                continue;
            }

            if (a < b) {
                ryanScore += k;
            } else {
                apeachScore += k;
            }
        }

        return ryanScore - apeachScore;
    }
}
