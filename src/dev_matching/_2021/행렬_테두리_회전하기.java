package dev_matching._2021;

public class 행렬_테두리_회전하기 {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] arr = createArr(rows, columns);

        for (int i = 0; i < queries.length; i++) {
            answer[i] = rotate(arr, queries[i]);
        }

        return answer;
    }

    private int rotate(int[][] arr, int[] query) {
        int x1 = query[0] - 1;
        int y1 = query[1] - 1;
        int x2 = query[2] - 1;
        int y2 = query[3] - 1;
        int start = arr[x1][y2];
        int min = start;

        for (int y = y2 - 1; y >= y1; y--) {
            min = Math.min(arr[x1][y], min);
            arr[x1][y + 1] = arr[x1][y];
        }

        for (int x = x1 + 1; x <= x2; x++) {
            min = Math.min(arr[x][y1], min);
            arr[x - 1][y1] = arr[x][y1];
        }

        for (int y = y1 + 1; y <= y2; y++) {
            min = Math.min(arr[x2][y], min);
            arr[x2][y - 1] = arr[x2][y];
        }

        for (int x = x2 - 1; x >= x1; x--) {
            min = Math.min(arr[x][y2], min);
            arr[x + 1][y2] = arr[x][y2];
        }

        arr[x1 + 1][y2] = start;
        return min;
    }

    private int[][] createArr(int rows, int columns) {
        int[][] arr = new int[rows][columns];
        int n = 1;

        for (int r = 0; r < arr.length; r++) {
            for (int c = 0; c < arr[0].length; c++) {
                arr[r][c] = n++;
            }
        }

        return arr;
    }
}
