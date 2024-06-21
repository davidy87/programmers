package lv2;

import java.util.*;

public class 광물_캐기 {

    private static final int[][] FATIGUES = {{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

    private static final Map<String, Integer> idxMap = Map.of("diamond", 0, "iron", 1, "stone", 2);

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        Queue<int[]> records = getRecords(picks, minerals);

        while (!records.isEmpty()) {
            for (int p = 0; p < 3; p++) {
                if (picks[p] > 0) {
                    answer += records.poll()[p];
                    picks[p]--;
                    break;
                }
            }
        }

        return answer;
    }

    private Queue<int[]> getRecords(int[] picks, String[] minerals) {
        int totalPicks = picks[0] + picks[1] + picks[2];
        Queue<int[]> records = new PriorityQueue<>((r1, r2) -> r2[2] - r1[2]);

        for (int i = 0; i < minerals.length; i += 5) {
            if (totalPicks == 0) {
                break;
            }

            int[] record = new int[3];

            for (int m = i; m < i + 5 && m < minerals.length; m++) {
                for (int p = 0; p < 3; p++) {
                    record[p] += FATIGUES[p][idxMap.get(minerals[m])];
                }
            }

            records.offer(record);
            totalPicks--;
        }

        return records;
    }
}
