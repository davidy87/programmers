package graph;

import java.util.*;

public class 방의_개수 {
    private static final int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    private static final int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

    public int solution(int[] arrows) {
        int answer = 0;
        Map<Node, Set<Node>> route = new HashMap<>();
        Node cur = new Node(0, 0);

        route.put(cur, new HashSet<>());

        for (int arrow : arrows) {
            for (int i = 0; i < 2; i++) {
                Node next = new Node(cur.x + dx[arrow], cur.y + dy[arrow]);

                if (route.containsKey(next) && !route.get(cur).contains(next)) {
                    answer++;
                }

                if (!route.containsKey(next)) {
                    route.put(next, new HashSet<>());
                }

                route.get(cur).add(next);
                route.get(next).add(cur);
                cur = next;
            }
        }

        return answer;
    }

    private static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object other) {
            if (!(other instanceof Node)) {
                return false;
            }

            return this.x == ((Node) other).x && this.y == ((Node) other).y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
