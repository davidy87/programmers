package lv2;

import java.util.*;

public class 하노이의_탑 {

    public int[][] solution(int n) {
        List<int[]> answer = new ArrayList<>();
        hanoi(answer, n, 1, 3, 2);

        return answer.toArray(new int[answer.size()][2]);
    }

    private void hanoi(List<int[]> move, int n, int from, int to, int mid) {
        if (n == 1) {
            move.add(new int[] {from, to});
            return;
        }

        hanoi(move, n - 1, from, mid, to);
        move.add(new int[] {from, to});
        hanoi(move, n - 1, mid, to, from);
    }
}
