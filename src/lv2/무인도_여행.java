package lv2;

import java.util.*;

public class 무인도_여행 {

    private static final int[][] MOVES = {
            {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };

    public int[] solution(String[] maps) {
        List<Integer> answer = new ArrayList<>();
        String[][] map = createMap(maps);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (!map[i][j].equals("X")) {
                    answer.add(bfs(map, new int[] {i, j}));
                }
            }
        }

        if (answer.isEmpty()) {
            return new int[] {-1};
        }

        return answer.stream().sorted().mapToInt(Integer::intValue).toArray();
    }

    private int bfs(String[][] map, int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        int sum = 0;

        if (!map[start[0]][start[1]].equals("X")) {
            sum += Integer.parseInt(map[start[0]][start[1]]);
            map[start[0]][start[1]] = "X";
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int[] move : MOVES) {
                int newR = cur[0] + move[0];
                int newC = cur[1] + move[1];

                if (isValid(map, newR, newC)) {
                    sum += Integer.parseInt(map[newR][newC]);
                    map[newR][newC] = "X";
                    queue.offer(new int[] {newR, newC});
                }
            }
        }

        return sum;
    }

    private boolean isValid(String[][] map, int r, int c) {
        boolean inBound = r >= 0 && r < map.length && c >= 0 && c < map[0].length;
        return inBound && !map[r][c].equals("X");
    }

    private String[][] createMap(String[] maps) {
        String[][] map = new String[maps.length][maps[0].length()];

        for (int i = 0; i < map.length; i++) {
            map[i] = maps[i].split("");
        }

        return map;
    }
}
