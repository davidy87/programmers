package kakao.blind._2018;

import java.util.*;

public class 셔틀버스 {

    public String solution(int n, int t, int m, String[] timetable) {
        int start = timeToMins("09:00");
        int count = 0;
        int last = 0;
        int i = 0;
        Arrays.sort(timetable);

        while (n > 0) {
            count = 0;

            while (count < m && i < timetable.length) {
                int cur = timeToMins(timetable[i]);

                if (cur > start) {
                    break;
                }

                count++;
                i++;
                last = cur;
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
        int hours = Integer.parseInt(split[0]);
        int mins = Integer.parseInt(split[1]);

        return hours * 60 + mins;
    }
}
