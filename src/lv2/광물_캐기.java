package lv2;

import java.util.*;

public class 광물_캐기 {

    private static final int[][] fatigue = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};
    private static final Map<String, Integer> idxMap = Map.of("diamond", 0, "iron", 1, "stone", 2);

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int totalPicks = picks[0] + picks[1] + picks[2];
        List<int[]> recordList = new ArrayList<>();

        for (int i = 0; i < minerals.length; i += 5) {
            if (totalPicks == 0) {
                break;
            }

            int[] record = new int[3];

            for (int j = i; j < i + 5 && j < minerals.length; j++) {
                String m = minerals[j];

                for (int p = 0; p < 3; p++) {
                    record[p] += fatigue[p][idxMap.get(m)];
                }
            }

            recordList.add(record);
            totalPicks--;
        }

        recordList.sort((r1, r2) -> r2[2] - r1[2]);

        for (int[] record : recordList) {
            for (int p = 0; p < 3; p++) {
                if (picks[p] > 0) {
                    answer += record[p];
                    picks[p]--;
                    break;
                }
            }
        }

        return answer;
    }
}
