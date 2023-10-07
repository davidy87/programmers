package heap;

import java.util.*;

public class 디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);
        PriorityQueue<int[]> queue = new PriorityQueue<>((j1, j2) -> j1[1] - j2[1]);

        int i = 0;
        int endTime = 0;
        int numFinished = 0;

        while (numFinished < jobs.length) {
            while (i < jobs.length && jobs[i][0] <= endTime) {
                queue.offer(jobs[i++]);
            }

            if (queue.isEmpty()) {
                endTime = jobs[i][0];
            } else {
                int[] request = queue.poll();
                answer += request[1] + endTime - request[0];
                endTime += request[1];
                numFinished++;
            }
        }

        return answer / jobs.length;
    }
}
