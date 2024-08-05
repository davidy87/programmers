package lv3;

import java.util.*;

public class 베스트앨범 {

    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> counter = new HashMap<>();
        Map<String, Queue<int[]>> albumMap = new HashMap<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < plays.length; i++) {
            if (!albumMap.containsKey(genres[i])) {
                Queue<int[]> albums = new PriorityQueue<>((a1, a2) -> {
                    if (a1[1] == a2[1]) {
                        return a1[0] - a2[0];
                    }

                    return a2[1] - a1[1];
                });

                albumMap.put(genres[i], albums);
            }

            albumMap.get(genres[i]).offer(new int[] {i, plays[i]});
            counter.put(genres[i], counter.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> keys = new ArrayList<>(counter.keySet());
        keys.sort((g1, g2) -> counter.get(g2) - counter.get(g1));

        for (String genre : keys) {
            Queue<int[]> albums = albumMap.get(genre);
            int count = 0;

            while (!albums.isEmpty() && count < 2) {
                answer.add(albums.poll()[0]);
                count++;
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
