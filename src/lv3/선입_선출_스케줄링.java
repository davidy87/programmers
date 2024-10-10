package lv3;

public class 선입_선출_스케줄링 {

    private static final int MAX_CORE_TIME = 10_000;

    public int solution(int n, int[] cores) {
        int answer = 0;
        int minTime = 1;
        int maxTime = MAX_CORE_TIME * n;
        int numJobsDone = 0;

        while (minTime < maxTime) {
            int mid = (minTime + maxTime) / 2;
            int count = countJobsDone(cores, mid);

            if (count < n) {
                numJobsDone = count;
                minTime = mid + 1;
            } else {
                maxTime = mid;
            }
        }

        n -= numJobsDone;

        for (int i = 0; i < cores.length; i++) {
            if (minTime % cores[i] != 0) {
                continue;
            }

            if (--n == 0) {
                answer = i + 1;
                break;
            }
        }

        return answer;
    }

    private int countJobsDone(int[] cores, int time) {
        int count = cores.length;

        for (int core : cores) {
            count += time / core;
        }

        return count;
    }
}
