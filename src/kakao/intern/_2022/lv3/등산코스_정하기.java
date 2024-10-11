package kakao.intern._2022.lv3;

import java.util.*;

public class 등산코스_정하기 {

    private static final int MAX_SUMMIT = 50_001;

    private static final int MAX_INTENSITY = 10_000_001;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[] {MAX_SUMMIT, MAX_INTENSITY};
        Set<int[]>[] map = createMap(n, paths, gates, summits);
        int[] intensity = findAllIntensity(map, gates, n);

        Arrays.sort(summits);

        for (int summit : summits) {
            if (intensity[summit] < answer[1]) {
                answer[0] = summit;
                answer[1] = intensity[summit];
            }
        }

        return answer;
    }

    private int[] findAllIntensity(Set<int[]>[] map, int[] gates, int n) {
        Queue<int[]> queue = new LinkedList<>();
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, MAX_INTENSITY);

        for (int gate : gates) {
            queue.offer(new int[] {gate, 0});
            intensity[gate] = 0;
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int i = cur[0];
            int w = cur[1];

            if (cur[1] > intensity[i]) {
                continue;
            }

            for (int[] next : map[i]) {
                int j = next[0];
                int newW = Math.max(intensity[i], next[1]);

                if (newW < intensity[j]) {
                    queue.offer(new int[] {j, newW});
                    intensity[j] = newW;
                }
            }
        }

        return intensity;
    }

    private Set<int[]>[] createMap(int n, int[][] paths, int[] gates, int[] summits) {
        Set<int[]>[] map = new HashSet[n + 1];

        for (int i = 0; i < map.length; i++) {
            map[i] = new HashSet<>();
        }

        for (int[] path : paths) {
            int i = path[0];
            int j = path[1];
            int w = path[2];

            if (isGate(gates, i) || isSummit(summits, j)) {
                map[i].add(new int[] {j, w});
            } else if (isGate(gates, j) || isSummit(summits, i)) {
                map[j].add(new int[] {i, w});
            } else {
                map[i].add(new int[] {j, w});
                map[j].add(new int[] {i, w});
            }
        }

        return map;
    }

    private boolean isSummit(int[] summits, int target) {
        for (int s : summits) {
            if (s == target) {
                return true;
            }
        }

        return false;
    }

    private boolean isGate(int[] gates, int target) {
        for (int g : gates) {
            if (g == target) {
                return true;
            }
        }

        return false;
    }
}
