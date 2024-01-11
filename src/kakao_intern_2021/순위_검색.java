package kakao_intern_2021;

import java.util.*;

public class 순위_검색 {

    private Map<String, List<Integer>> records = new HashMap<>();

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        for (String i : info) {
            String[] row = i.split(" ");
            getRecords(row, "", 0);
        }

        for (String record : records.keySet()) {
            Collections.sort(records.get(record));
        }

        for (int i = 0; i < query.length; i++) {
            String[] splited = query[i].replace(" and ", "").split(" ");
            answer[i] = binarySearch(splited[0], Integer.parseInt(splited[1]));
        }

        return answer;
    }

    private int binarySearch(String q, int targetScore) {
        if (!records.containsKey(q)) {
            return 0;
        }

        List<Integer> scores = records.get(q);
        int start = 0;
        int end = scores.size() - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (scores.get(mid) < targetScore) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return scores.size() - start;
    }

    private void getRecords(String[] row, String cur, int idx) {
        if (idx == 4) {
            if (!records.containsKey(cur)) {
                records.put(cur, new ArrayList<>());
            }

            int score = Integer.parseInt(row[idx]);
            records.get(cur).add(score);
            return;
        }

        getRecords(row, cur + "-", idx + 1);
        getRecords(row, cur + row[idx], idx + 1);
    }
}
