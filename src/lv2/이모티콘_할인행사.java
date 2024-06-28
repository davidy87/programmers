package lv2;

import java.util.PriorityQueue;
import java.util.Queue;

public class 이모티콘_할인행사 {

    private static final int[] DISCOUNT_RATES = {10, 20, 30, 40};
    private int[] discounted;
    private Queue<int[]> records;

    public int[] solution(int[][] users, int[] emoticons) {
        discounted = new int[emoticons.length];
        records = new PriorityQueue<>((r1, r2) -> r1[0] == r2[0] ? r2[1] - r1[1] : r2[0] - r1[0]);
        findResults(0, users, emoticons);

        return records.poll();
    }

    private void findResults(int n, int[][] users, int[] emoticons) {
        if (n == emoticons.length) {
            int numSubscribed = 0;
            int sales = 0;

            for (int[] user : users) {
                int total = 0;

                for (int i = 0; i < n; i++) {
                    if (discounted[i] >= user[0]) {
                        total += emoticons[i] * (100 - discounted[i]) / 100;
                    }
                }

                if (total >= user[1]) {
                    numSubscribed++;
                } else {
                    sales += total;
                }
            }

            records.offer(new int[] {numSubscribed, sales});
            return;
        }

        for (int rate : DISCOUNT_RATES) {
            discounted[n] = rate;
            findResults(n + 1, users, emoticons);
        }
    }
}
