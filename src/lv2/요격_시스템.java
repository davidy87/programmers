package lv2;

import java.util.*;

public class 요격_시스템 {

    public int solution(int[][] targets) {
        Arrays.sort(targets, Comparator.comparingInt(t -> t[1]));
        int answer = 0;
        int x = 0;

        for (int[] target : targets) {
            if (x <= target[0]) {
                x = target[1];
                answer++;
            }
        }

        return answer;
    }
}
