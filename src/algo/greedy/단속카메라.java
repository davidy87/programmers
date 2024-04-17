package algo.greedy;

import java.util.Arrays;

public class 단속카메라 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (r1, r2) -> r1[1] - r2[1]);
        int answer = 1;
        int cam = routes[0][1];

        for (int i = 1; i < routes.length; i++) {
            if (cam < routes[i][0]) {
                cam = routes[i][1];
                answer++;
            }
        }

        return answer;
    }
}
