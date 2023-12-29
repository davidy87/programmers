package lv2;

import java.util.*;

public class 우박수열_정적분 {

    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> collatzList = new ArrayList<>();
        collatz(collatzList, k);
        collatzList.add(1);

        double[] area = new double[collatzList.size() - 1];

        for (int i = 0; i < area.length; i++) {
            area[i] = (collatzList.get(i) + collatzList.get(i + 1)) / 2.0;
        }

        for (int i = 0; i < ranges.length; i++) {
            int start = ranges[i][0];
            int end = area.length + ranges[i][1];

            if (start > end) {
                answer[i] = -1.0;
                continue;
            }

            for (int j = start; j < end; j++) {
                answer[i] += area[j];
            }
        }

        return answer;
    }

    private void collatz(List<Integer> list, int k) {
        list.add(k);
        k = k % 2 == 0 ? k / 2 : k * 3 + 1;

        if (k > 1) {
            collatz(list, k);
        }
    }
}
