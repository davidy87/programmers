package kakao.blind._2023.lv3;

import java.util.*;

public class 표_병합 {

    private static final int N = 50;

    private static final String EMPTY_VALUE = "EMPTY";

    private String[][] cell;

    private int[] merged;

    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        cell = new String[N][N];
        merged = new int[N * N];

        for (String[] row : cell) {
            Arrays.fill(row, EMPTY_VALUE);
        }

        for (int i = 0; i < merged.length; i++) {
            merged[i] = i;
        }

        for (String command : commands) {
            String[] split = command.split(" ");
            String op = split[0];

            switch (op) {
                case "UPDATE" -> update(split);
                case "MERGE" -> merge(split);
                case "UNMERGE" -> unmerge(split);
                case "PRINT" -> print(split, answer);
            }
        }

        return answer.toArray(String[]::new);
    }

    private void print(String[] split, List<String> answer) {
        int r = Integer.parseInt(split[1]) - 1;
        int c = Integer.parseInt(split[2]) - 1;
        answer.add(cell[r][c]);
    }

    private void unmerge(String[] split) {
        int r = Integer.parseInt(split[1]) - 1;
        int c = Integer.parseInt(split[2]) - 1;
        String value = cell[r][c];
        int root = find(r * N + c);

        for (int i = 0; i < merged.length; i++) {
            if (merged[i] == root) {
                merged[i] = i;
                cell[i / N][i % N] = EMPTY_VALUE;
            }
        }

        cell[r][c] = value;
    }

    private void merge(String[] split) {
        int r1 = Integer.parseInt(split[1]) - 1;
        int c1 = Integer.parseInt(split[2]) - 1;
        int r2 = Integer.parseInt(split[3]) - 1;
        int c2 = Integer.parseInt(split[4]) - 1;

        int root1 = find(r1 * N + c1);
        int root2 = find(r2 * N + c2);
        union(root1, root2);

        int root = find(root1);
        String value = cell[r1][c1];

        if (cell[r1][c1].equals(EMPTY_VALUE) && !cell[r2][c2].equals(EMPTY_VALUE)) {
            value = cell[r2][c2];
        }

        for (int i = 0; i < merged.length; i++) {
            if (merged[i] == root1 || merged[i] == root2 || merged[i] == root) {
                merged[i] = root;
                cell[i / N][i % N] = value;
            }
        }
    }

    private void update(String[] split) {
        if (split.length == 4) {
            int r = Integer.parseInt(split[1]) - 1;
            int c = Integer.parseInt(split[2]) - 1;
            int root = find(r * N + c);

            for(int i = 0; i < merged.length; i++){
                if (merged[i] == root) {
                    cell[i / N][i % N] = split[3];
                }
            }
        } else {
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (split[1].equals(cell[r][c])) {
                        cell[r][c] = split[2];
                    }
                }
            }
        }
    }

    private int find(int x){
        if(x == merged[x]){
            return x;
        }

        return merged[x] = find(merged[x]);
    }

    private void union(int x, int y){
        x = find(x);
        y = find(y);

        if (x > y) {
            merged[x] = y;
        } else if (x < y) {
            merged[y] = x;
        }
    }
}
