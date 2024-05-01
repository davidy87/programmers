package lv2;

import java.util.*;

public class 뒤에_있는_큰_수_찾기 {

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!deque.isEmpty() && numbers[deque.peekLast()] < numbers[i]) {
                answer[deque.pollLast()] = numbers[i];
            }

            if (answer[i] == 0) {
                answer[i] = -1;
            }

            deque.offerLast(i);
        }

        return answer;
    }
}
