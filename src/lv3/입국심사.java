package lv3;

import java.util.Arrays;

public class 입국심사 {

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long low = 0;
        long high = (long) times[times.length - 1] * n;

        while (low < high) {
            long mid = (low + high) / 2;
            long numVisit = 0;

            for (int t : times) {
                numVisit += mid / t;
            }

            if (numVisit >= n) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
