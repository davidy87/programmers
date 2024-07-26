package lv3;

import java.util.*;

public class 야근_지수 {

    public long solution(int n, int[] works) {
        long answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int w : works) {
            pq.offer(w);
        }

        while (n > 0 && !pq.isEmpty()) {
            int cur = pq.poll();
            cur--;
            n--;

            if (cur > 0) {
                pq.offer(cur);
            }
        }

        while (!pq.isEmpty()) {
            answer += Math.pow(pq.poll(), 2);
        }

        return answer;
    }
}
