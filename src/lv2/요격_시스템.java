package lv2;

import java.util.*;

public class 요격_시스템 {

    public int solution(int[][] targets) {
        int answer = 0;
        int x = 0;
        Arrays.sort(targets, Comparator.comparingInt(t -> t[1]));

        for (int i = 0; i < targets.length; i++) {
            if (x <= targets[i][0]) {
                x = targets[i][1];
                answer++;
            }
        }

        return answer;
    }
}
