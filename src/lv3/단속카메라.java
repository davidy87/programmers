package lv3;

import java.util.*;

public class 단속카메라 {

    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(r -> r[1]));
        int answer = 1;
        int cam = routes[0][1];

        for (int i = 1; i < routes.length; i++) {
            if (routes[i][0] > cam) {
                cam = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}
