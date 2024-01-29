package lv3;

import java.util.*;

public class 디스크_컨트롤러 {

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(j -> j[0]));
        Queue<int[]> schedule = new PriorityQueue<>(Comparator.comparingInt(j -> j[1]));

        int i = 0;
        int totalTime = 0;
        int endTime = 0;
        int numFinished = 0;

        while (numFinished < jobs.length) {
            while (i < jobs.length && jobs[i][0] <= endTime) {
                schedule.offer(jobs[i++]);
            }

            if (schedule.isEmpty()) {
                endTime = jobs[i][0];
            } else {
                int[] curJob = schedule.poll();
                endTime += curJob[1];
                totalTime += endTime - curJob[0];
                numFinished++;
            }
        }

        return totalTime / numFinished;
    }
}
