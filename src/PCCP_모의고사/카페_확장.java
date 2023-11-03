package PCCP_모의고사;

import java.util.*;

public class 카페_확장 {

    public int solution(int[] menu, int[] order, int k) {
        int answer = 0;
        int endTime = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < order.length; i++) {
            while (!pq.isEmpty() && pq.peek() <= i * k) {
                pq.poll();
            }

            if (pq.isEmpty()) {
                endTime = i * k + menu[order[i]];
            } else {
                endTime += menu[order[i]];
            }

            pq.offer(endTime);
            answer = Math.max(answer, pq.size());
        }

        return answer;
    }
}
