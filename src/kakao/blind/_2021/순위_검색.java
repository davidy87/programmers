package kakao.blind._2021;

import java.util.*;

public class 순위_검색 {

    private Map<String, List<Integer>> records = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (String row : info) {
            String[] split = row.split(" ");
            record(split, "", 0);
        }

        for (String key : records.keySet()) {
            Collections.sort(records.get(key));
        }

        for (int i = 0; i < query.length; i++) {
            String[] split = query[i].replace(" and ", "").split(" ");
            String key = split[0];
            int targetScore = Integer.parseInt(split[1]);
            answer[i] = binarySearch(key, targetScore);
        }

        return answer;
    }

    private int binarySearch(String key, int target) {
        if (!records.containsKey(key)) {
            return 0;
        }

        List<Integer> scores = records.get(key);
        int start = 0;
        int end = scores.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (scores.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return scores.size() - start;
    }

    private void record(String[] row, String cur, int idx) {
        if (idx == 4) {
            if (!records.containsKey(cur)) {
                records.put(cur, new ArrayList<>());
            }

            int score = Integer.parseInt(row[idx]);
            records.get(cur).add(score);
            return;
        }

        record(row, cur + "-", idx + 1);
        record(row, cur + row[idx], idx + 1);
    }
}
