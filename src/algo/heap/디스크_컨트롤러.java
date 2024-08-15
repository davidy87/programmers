package algo.heap;

import java.util.*;

public class 디스크_컨트롤러 {
    public int solution(int[][] jobs) {
        Queue<int[]> schedule = new PriorityQueue<>((j1, j2) -> j1[1] - j2[1]);
        Arrays.sort(jobs, (j1, j2) -> j1[0] - j2[0]);

        int i = 0;
        int numFinished = 0;
        int totalTime = 0;
        int curTime = 0;

        while (numFinished < jobs.length) {
            while (i < jobs.length && jobs[i][0] <= curTime) {
                schedule.offer(jobs[i++]);
            }

            if (!schedule.isEmpty()) {
                int[] job = schedule.poll();
                totalTime += curTime - job[0] + job[1];
                curTime += job[1];
                numFinished++;
            } else {
                curTime = jobs[i][0];
            }
        }

        return totalTime / numFinished;
    }
}
