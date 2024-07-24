package lv3;

import java.util.*;

public class 이중우선순위큐 {

    public int[] solution1(String[] operations) {
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

    public int[] solution2(String[] operations) {
        Queue<Integer> minHeap = new PriorityQueue<>();
        Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (String op : operations) {
            String[] split = op.split(" ");
            String cmd = split[0];
            int num = Integer.parseInt(split[1]);

            if (cmd.equals("I")) {
                minHeap.offer(num);
                maxHeap.offer(num);
                continue;
            }

            if (num == 1 && !maxHeap.isEmpty()) {
                int removed = maxHeap.poll();
                minHeap.remove(removed);
            } else if (num == -1 && !minHeap.isEmpty()) {
                int removed = minHeap.poll();
                maxHeap.remove(removed);
            }
        }

        if (maxHeap.isEmpty() || minHeap.isEmpty()) {
            return new int[2];
        }

        return new int[] {maxHeap.peek(), minHeap.peek()};
    }
}
