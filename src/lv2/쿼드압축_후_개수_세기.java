package lv2;

public class 쿼드압축_후_개수_세기 {

    public int[] solution(int[][] arr) {
        int[] answer = new int[2];
        compress(arr, answer, 0, 0, arr.length);
        return answer;
    }

    private void compress(int[][] arr, int[] answer, int r, int c, int n) {
        int[] count = new int[2];

        for (int i = r; i < r + n; i++) {
            for (int j = c; j < c + n; j++) {
                count[arr[i][j]]++;
            }
        }

        if (count[0] == 0) {
            answer[1]++;
            return;
        }

        if (count[1] == 0) {
            answer[0]++;
            return;
        }

        n /= 2;

        compress(arr, answer, r, c, n);
        compress(arr, answer, r + n, c, n);
        compress(arr, answer, r, c + n, n);
        compress(arr, answer, r + n, c + n, n);
    }
}
