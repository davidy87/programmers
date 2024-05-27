package lv2;

public class 호텔_대실 {

    private static final int MAX_TIME = 24 * 60 + 10;

    public int solution(String[][] book_time) {
        int answer = 0;
        int[] records = new int[MAX_TIME];

        for (String[] time : book_time) {
            int in = convertTime(time[0]);
            int out = convertTime(time[1]);
            records[in] += 1;
            records[out + 10] -= 1;
        }

        for (int i = 1; i < MAX_TIME; i++) {
            records[i] += records[i - 1];
            answer = Math.max(records[i], answer);
        }

        return answer;
    }

    private int convertTime(String time) {
        String[] split = time.split(":");
        int hours = Integer.parseInt(split[0]);
        int mins = Integer.parseInt(split[1]);

        return hours * 60 + mins;
    }
}
