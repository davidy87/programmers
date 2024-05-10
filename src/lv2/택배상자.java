package lv2;

import java.util.*;

public class 택배상자 {

    public int solution(int[] order) {
        int answer = 0;
        int i = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int box = 1; box <= order.length; box++) {
            stack.offerLast(box);

            while (!stack.isEmpty() && stack.peekLast() == order[i]) {
                stack.pollLast();
                answer++;
                i++;
            }
        }

        return answer;
    }
}
