package lv2;

import java.util.*;

public class 우박수열_정적분 {

    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> sequence = new ArrayList<>();
        collatz(k, sequence);

        double[] area = getArea(sequence);

        for (int i = 0; i < ranges.length; i++) {
            int x1 = ranges[i][0];
            int x2 = sequence.size() - 1 + ranges[i][1];

            if (x1 > x2) {
                answer[i] = -1.0;
            }

            for (int j = x1; j < x2; j++) {
                answer[i] += area[j];
            }
        }

        return answer;
    }

    private double[] getArea(List<Integer> sequence) {
        double[] area = new double[sequence.size()];

        for (int i = 0; i < sequence.size() - 1; i++) {
            area[i] = (sequence.get(i) + sequence.get(i + 1)) / 2.0;
        }

        return area;
    }

    private void collatz(int k, List<Integer> sequence) {
        sequence.add(k);

        if (k == 1) {
            return;
        } else if (k % 2 == 0) {
            collatz(k / 2, sequence);
        } else {
            collatz(k * 3 + 1, sequence);
        }
    }
}
