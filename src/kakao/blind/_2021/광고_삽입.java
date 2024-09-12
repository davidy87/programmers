package kakao.blind._2021;

import java.util.Arrays;

public class 광고_삽입 {

    public String solution(String play_time, String adv_time, String[] logs) {
        int[] time = new int[convertTime(play_time) + 1];
        int advTime = convertTime(adv_time);
        int playTime = convertTime(play_time);

        for (String log : logs) {
            String[] split = log.split("-");
            int startTime = convertTime(split[0]);
            int endTime = convertTime(split[1]);

            for (int t = startTime; t < endTime; t++) {
                time[t]++;
            }
        }

        int insertTime = 0;
        long totalTime = 0;
        long maxTotalTime = totalTime;

        for (int t = 0; t < advTime; t++) {
            totalTime += time[t];
        }

        for (int t = advTime; t < playTime; t++) {
            totalTime += time[t] - time[t - advTime];

            if (totalTime > maxTotalTime) {
                maxTotalTime = totalTime;
                insertTime = t - advTime + 1;
            }
        }

        return convertTime(insertTime);
    }

    private String convertTime(int time) {
        int hour = time / 3600;
        int min = time % 3600 / 60;
        int sec = time % 3600 % 60;

        return String.format("%02d:%02d:%02d", hour, min, sec);
    }

    private int convertTime(String time) {
        int[] split = Arrays.stream(time.split(":"))
                .mapToInt(Integer::parseInt)
                .toArray();

        return split[0] * 3600 + split[1] * 60 + split[2];
    }
}
