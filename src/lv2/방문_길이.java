package lv2;

import java.util.*;

public class 방문_길이 {

    private static final Map<String, int[]> moves = Map.of(
            "U", new int[] {0, 1},
            "D", new int[] {0, -1},
            "R", new int[] {1, 0},
            "L", new int[] {-1, 0}
    );

    public int solution(String dirs) {
        int answer = 0;
        Map<Point, Set<Point>> routes = new HashMap<>();
        Point cur = new Point(0, 0);
        routes.put(cur, new HashSet<>());

        for (String d : dirs.split("")) {
            int[] move = moves.get(d);
            Point next = new Point(cur.getX() + move[0], cur.getY() + move[1]);

            if (!next.inBound()) {
                continue;
            }

            if (!routes.containsKey(next)) {
                routes.put(next, new HashSet<>());
            }

            routes.get(cur).add(next);
            routes.get(next).add(cur);
            cur = next;
        }

        for (Point p : routes.keySet()) {
            answer += routes.get(p).size();
        }

        return answer / 2;
    }

    private static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public boolean inBound() {
            return x >= -5 && x <= 5 && y >= -5 && y <= 5;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }

            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }

            Point p = (Point) obj;
            return x == p.getX() && y == p.getY();
        }

        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
