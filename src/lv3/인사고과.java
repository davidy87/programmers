package lv3;

import java.util.*;

public class 인사고과 {

    public int solution(int[][] scores) {
        int answer = 1;
        int[] targetScore = scores[0];

        Arrays.sort(scores, (s1, s2) -> {
            if (s1[0] == s2[0]) {
                return s1[1] - s2[1];
            }

            return s2[0] - s1[0];
        });

        int prevScore = 0;

        for (int[] score : scores) {
            if (score[1] < prevScore) {
                if (Arrays.equals(score, targetScore)) {
                    return -1;
                }

                continue;
            }

            if (score[0] + score[1] > targetScore[0] + targetScore[1]) {
                answer++;
            }

            prevScore = score[1];
        }

        return answer;
    }
}
