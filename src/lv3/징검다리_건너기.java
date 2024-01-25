package lv3;

public class 징검다리_건너기 {

    public int solution(int[] stones, int k) {
        int answer = 0;
        int low = 0;
        int high = 0;

        for (int stone : stones) {
            high = Math.max(high, stone);
        }

        while (low <= high) {
            int mid = (low + high) / 2;

            if (canCross(stones, k, mid)) {
                answer = Math.max(answer, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return answer;
    }

    private boolean canCross(int[] stones, int k, int n) {
        int numZero = 0;
        int maxZero = 0;

        for (int stone : stones) {
            if (stone < n) {
                numZero++;
            } else {
                maxZero = Math.max(maxZero, numZero);
                numZero = 0;
            }
        }

        maxZero = Math.max(maxZero, numZero);

        return maxZero < k;
    }
}
