package lv2;

import java.util.*;

public class 프로세스 {

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            pq.offer(priorities[i]);
            queue.offer(new int[] {i, priorities[i]});
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            if (cur[1] < pq.peek()) {
                queue.offer(cur);
                continue;
            }

            pq.poll();
            answer++;

            if (cur[0] == location) {
                return answer;
            }
        }

        return answer;
    }
}
