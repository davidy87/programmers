package lv3;

import java.util.*;

public class 야근_지수 {

    public long solution(int n, int[] works) {
        long answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int w : works) {
            pq.offer(w);
        }

        for (int i = 0; i < n; i++) {
            int curWork = pq.remove();

            if (curWork == 0) {
                return 0;
            }

            pq.offer(--curWork);
        }

        while (!pq.isEmpty()) {
            answer += (long) Math.pow(pq.poll(), 2);
        }

        return answer;
    }
}
