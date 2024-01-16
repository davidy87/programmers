package lv3;

import java.util.*;

public class 최고의_집합 {

    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[] {-1};
        }

        int[] answer = new int[n];
        int remainder = s % n;
        int idx = 0;
        Arrays.fill(answer, s / n);

        while (remainder > 0) {
            if (idx == n) {
                idx = 0;
            }

            answer[idx++]++;
            remainder--;
        }

        Arrays.sort(answer);

        return answer;
    }
}
