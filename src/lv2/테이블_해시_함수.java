package lv2;

import java.util.*;

public class 테이블_해시_함수 {

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;

        Arrays.sort(data, (r1, r2) -> {
            if (r1[col - 1] != r2[col - 1]) {
                return r1[col - 1] - r2[col - 1];
            }

            return r2[0] - r1[0];
        });

        for (int r = row_begin; r <= row_end; r++) {
            answer ^= calc(data, r);
        }

        return answer;
    }

    private int calc(int[][] data, int r) {
        int result = 0;

        for (int col : data[r - 1]) {
            result += col % r;
        }

        return result;
    }
}
