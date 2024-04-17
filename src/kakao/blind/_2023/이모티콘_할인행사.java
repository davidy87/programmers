package kakao.blind._2023;

import java.util.*;

public class 이모티콘_할인행사 {

    private static final int[] discounts = {10, 20, 30, 40};
    private int[] nums;
    private Queue<int[]> pq;

    public int[] solution(int[][] users, int[] emoticons) {
        nums = new int[emoticons.length];
        pq = new PriorityQueue<>((info1, info2) -> {
            return info1[0] == info2[0] ? info2[1] - info1[1] : info2[0] - info1[0];
        });

        findResults(0, users, emoticons);

        return pq.poll();
    }

    private void findResults(int r, int[][] users, int[] emoticons) {
        if (r == nums.length) {
            int numSubscribed = 0;
            int total = 0;

            for (int[] user : users) {
                int userTotal = 0;

                for (int j = 0; j < emoticons.length; j++) {
                    if (nums[j] >= user[0]) {
                        userTotal += emoticons[j] * (100 - nums[j]) / 100;
                    }
                }

                if (userTotal >= user[1]) {
                    numSubscribed++;
                } else {
                    total += userTotal;
                }
            }

            pq.offer(new int[] {numSubscribed, total});
            return;
        }

        for (int discount : discounts) {
            nums[r] = discount;
            findResults(r + 1, users, emoticons);
        }
    }
}
