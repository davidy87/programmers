package lv2;

import java.util.*;

public class 혼자_놀기의_달인 {

    public int solution(int[] cards) {
        boolean[] opened = new boolean[cards.length];
        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < cards.length; i++) {
            int cur = i;
            int count = 0;

            while (!opened[cur]) {
                opened[cur] = true;
                cur = cards[cur] - 1;
                count++;
            }

            if (count > 0) {
                counts.add(count);
            }
        }

        counts.sort((c1, c2) -> c2 - c1);

        return counts.size() == 1 ? 0 : counts.get(0) * counts.get(1);
    }
}
