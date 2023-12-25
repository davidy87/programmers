package lv2;

public class 하노이의_탑 {

    private int[][] answer;
    private int idx;

    public int[][] solution(int n) {
        answer = new int[(int) Math.pow(2, n) - 1][2];
        idx = 0;
        hanoi(n, 1, 3, 2);

        return answer;
    }

    private void hanoi(int n, int from, int to, int mid) {
        if (n == 1) {
            answer[idx++] = new int[] {from, to};
            return;
        }

        hanoi(n - 1, from, mid, to);
        answer[idx++] = new int[] {from, to};
        hanoi(n - 1, mid, to, from);
    }
}
