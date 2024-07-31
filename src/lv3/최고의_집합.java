package lv3;

import java.util.*;

public class 최고의_집합 {

    public int[] solution(int n, int s) {
        if (n >= s) {
            return new int[] {-1};
        }

        int[] answer = new int[n];
        int leftOver = s % n;
        int i = n - 1;
        Arrays.fill(answer, s / n);

        while (leftOver > 0) {
            answer[i--]++;
            leftOver--;
        }

        return answer;
    }
}
