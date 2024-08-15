package algo.binary_search;

import java.util.Arrays;

public class 입국심사 {

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long min = 0L;
        long max = (long) times[times.length - 1] * n;

        while (min < max) {
            long mid = (min + max) / 2;
            long numVisited = 0L;

            for (int time : times) {
                numVisited += mid / time;
            }

            if (numVisited < n) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }
}
