package kakao.intern._2022;

import java.util.*;

public class 두_큐_합_같게_만들기 {

    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        long sum1 = 0L;
        long sum2 = 0L;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
        }

        while (sum1 != sum2) {
            if (answer > queue1.length * 3) {
                return -1;
            }

            if (sum1 > sum2) {
                int moved = updateQueue(q1, q2);
                sum1 -= moved;
                sum2 += moved;
            } else {
                int moved = updateQueue(q2, q1);
                sum2 -= moved;
                sum1 += moved;
            }

            answer++;
        }

        return answer;
    }

    private int updateQueue(Queue<Integer> from, Queue<Integer> to) {
        int cur = from.poll();
        to.offer(cur);
        return cur;
    }
}
