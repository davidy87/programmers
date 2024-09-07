package kakao.intern._2021;

import java.util.*;

public class 표_편집 {

    public String solution(int n, int k, String[] cmd) {
        Deque<Integer> deleted = new ArrayDeque<>();

        for (String c : cmd) {
            String[] split = c.split(" ");

            switch (split[0]) {
                case "U" -> k -= Integer.parseInt(split[1]);
                case "D" -> k += Integer.parseInt(split[1]);
                case "C" -> {
                    deleted.offerLast(k);
                    if (k == n - deleted.size()) {
                        k--;
                    }
                }
                case "Z" -> {
                    if (deleted.pollLast() <= k) {
                        k++;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder(n);
        sb.append("O".repeat(n - deleted.size()));

        while (!deleted.isEmpty()) {
            sb.insert(deleted.pollLast(), "X");
        }

        return sb.toString();
    }
}
