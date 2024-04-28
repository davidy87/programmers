package lv2;

import java.util.*;

public class 압축 {

    public int[] solution(String msg) {
        List<Integer> indices = new ArrayList<>();
        Map<String, Integer> dict = initDict();
        Queue<Character> queue = getCharQueue(msg);
        int nextIdx = 'Z' - 'A' + 2;

        while (!queue.isEmpty()) {
            StringBuilder w = new StringBuilder();

            while (!queue.isEmpty() && dict.containsKey(w.toString() + queue.peek())) {
                w.append(queue.poll());
            }

            indices.add(dict.get(w.toString()));

            if (!queue.isEmpty()) {
                dict.put(w.toString() + queue.peek(), nextIdx++);
            }
        }

        return indices.stream().mapToInt(Integer::intValue).toArray();
    }

    private Queue<Character> getCharQueue(String msg) {
        Queue<Character> queue = new LinkedList<>();

        for (char c : msg.toCharArray()) {
            queue.offer(c);
        }

        return queue;
    }

    private Map<String, Integer> initDict() {
        Map<String, Integer> dict = new HashMap<>();
        char c = 'A';

        while (c <= 'Z') {
            dict.put(Character.toString(c), c - 'A' + 1);
            c += 1;
        }

        return dict;
    }
}
