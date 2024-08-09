package lv3;

public class 징검다리_건너기 {

    public int solution(int[] stones, int k) {
        int answer = 0;
        int[] minMax = getMinMax(stones);
        int low = minMax[0];
        int high = minMax[1];

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canCross(stones, k, mid)) {
                answer = Math.max(mid, answer);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    private boolean canCross(int[] stones, int k, int n) {
        int zeroRange = 0;
        int maxZeroRange = 0;

        for (int stone : stones) {
            if (stone < n) {
                zeroRange++;
            } else {
                maxZeroRange = Math.max(zeroRange, maxZeroRange);
                zeroRange = 0;
            }
        }

        maxZeroRange = Math.max(zeroRange, maxZeroRange);

        return maxZeroRange < k;
    }

    private int[] getMinMax(int[] stones) {
        int minStone = Integer.MAX_VALUE;
        int maxStone = 0;

        for (int stone : stones) {
            minStone = Math.min(stone, minStone);
            maxStone = Math.max(stone, maxStone);
        }

        return new int[] {minStone, maxStone};
    }
}
