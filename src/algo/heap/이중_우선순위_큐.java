package algo.heap;

import java.util.*;

public class 이중_우선순위_큐 {

    public int[] solution(String[] operations) {
        Set<Integer> heap = new HashSet<>();

        for (String op : operations) {
            String[] splited = op.split(" ");
            String cmd = splited[0];
            int num = Integer.parseInt(splited[1]);

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
