package kakao_blind_2018;

import java.util.PriorityQueue;
import java.util.Queue;

public class 셔틀버스 {

    public String solution(int n, int t, int m, String[] timetable) {
        Queue<String> pq = new PriorityQueue<>();
        int start = timeToMins("09:00");
        int last = 0;
        int count = 0;

        for (String time : timetable) {
            pq.offer(time);
        }

        while (n > 0) {
            count = 0;

            while (count < m && !pq.isEmpty()) {
                int cur = timeToMins(pq.poll());

                if (cur <= start) {
                    count++;
                    last = cur;
                } else {
                    pq.offer(minsToTime(cur));
                    break;
                }
            }

            start += t;
            n--;
        }

        return count < m ? minsToTime(start - t) : minsToTime(last - 1);
    }

    private String minsToTime(int mins) {
        return String.format("%02d:%02d", mins / 60, mins % 60);
    }

    private int timeToMins(String time) {
        String[] split = time.split(":");
        int hours = Integer.parseInt(split[0]) * 60;
        int mins = Integer.parseInt(split[1]);

        return hours + mins;
    }
}
