package lv3;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(r -> r[1]));
        int answer = 1;
        int cam = routes[0][1];

        for (int[] r : routes) {
            if (cam < r[0]) {
                cam = r[1];
                answer++;
            }
        }

        return answer;
    }
}
