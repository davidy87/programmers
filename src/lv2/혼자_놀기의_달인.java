package lv2;

import java.util.*;

public class 혼자_놀기의_달인 {

    public int solution(int[] cards) {
        boolean[] isOpened = new boolean[cards.length + 1];
        List<Integer> counts = new ArrayList<>();

        for (int n : cards) {
            int count = 0;

            while (!isOpened[n]) {
                isOpened[n] = true;
                n = cards[n - 1];
                count++;
            }

            counts.add(count);
        }

        counts.sort(Collections.reverseOrder());

        return counts.get(0) * counts.get(1);
    }
}
