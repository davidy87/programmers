package 월간_코드_챌린지_시즌2.lv3;

import java.util.*;

public class 모두_0으로_만들기 {

    public long solution(int[] a, int[][] edges) {
        int n = a.length;
        List<Integer>[] map = new ArrayList[n];
        long[] aCopy = new long[n];
        int[] counter = new int[n];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
            aCopy[i] = a[i];
            sum += a[i];
        }

        if (sum != 0) {
            return -1;
        }

        for (int[] e : edges) {
            map[e[0]].add(e[1]);
            map[e[1]].add(e[0]);
            counter[e[0]]++;
            counter[e[1]]++;
        }

        return bfs(map, aCopy, counter);
    }

    private long bfs(List<Integer>[] map, long[] aCopy, int[] counter) {
        long answer = 0L;
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[map.length];

        for (int i = 0; i < map.length; i++) {
            if (counter[i] == 1) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            visited[cur] = true;

            for (int next : map[cur]) {
                if (visited[next]) {
                    continue;
                }

                counter[next]--;
                answer += Math.abs(aCopy[cur]);
                aCopy[next] += aCopy[cur];
                aCopy[cur] = 0;

                if (counter[next] == 1) {
                    queue.offer(next);
                }
            }
        }

        return answer;
    }
}
