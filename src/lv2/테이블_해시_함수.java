package lv2;

import java.util.*;

public class 테이블_해시_함수 {

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        sortData(data, col);
        return hash(data, row_begin, row_end);
    }

    private int hash(int[][] data, int begin, int end) {
        int result = 0;

        for (int r = begin; r <= end; r++) {
            int s = 0;

            for (int n : data[r - 1]) {
                s += n % r;
            }

            result ^= s;
        }

        return result;
    }

    private void sortData(int[][] data, int col) {
        Arrays.sort(data, (r1, r2) -> {
            int diff = r1[col - 1] - r2[col - 1];

            if (diff == 0) {
                return r2[0] - r1[0];
            }

            return diff;
        });
    }
}
