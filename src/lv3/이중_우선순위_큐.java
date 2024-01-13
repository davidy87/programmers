package lv3;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class 이중_우선순위_큐 {

    public int[] solution(String[] operations) {
        Set<Integer> heap = new HashSet<>();

        for (String op : operations) {
            String[] split = op.split(" ");
            String cmd = split[0];
            int num = Integer.parseInt(split[1]);

            if (cmd.equals("I")) {
                heap.add(num);
                continue;
            }

            if (!heap.isEmpty()) {
                if (num == 1) {
                    heap.remove(Collections.max(heap));
                } else {
                    heap.remove(Collections.min(heap));
                }
            }
        }

        if (heap.isEmpty()) {
            return new int[2];
        }

        return new int[] {Collections.max(heap), Collections.min(heap)};
    }
}
