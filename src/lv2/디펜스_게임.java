package lv2;

import java.util.*;

public class 디펜스_게임 {

    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int e : enemy) {
            n -= e;
            pq.offer(e);

            if (n < 0) {
                if (k == 0 || pq.isEmpty()) {
                    return answer;
                }

                n += pq.poll();
                k--;
            }

            answer++;
        }

        return answer;
    }
}
