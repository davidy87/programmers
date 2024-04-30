package algo.heap;

import java.util.PriorityQueue;

public class 더_맵게 {

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int s : scoville) {
            pq.offer(s);
        }

        while (pq.peek() < K && pq.size() >= 2) {
            int s1 = pq.poll();
            int s2 = pq.poll();
            pq.offer(s1 + s2 * 2);
            answer++;
        }

        return pq.peek() >= K ? answer : -1;
    }
}
