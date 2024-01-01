package lv2;

public class 두_원_사이의_정수_쌍 {

    public long solution(int r1, int r2) {
        long answer = 0;

        for (int x = 1; x <= r2; x++) {
            double y1 = Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2));
            double y2 = Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2));
            answer += (long) y2 - (long) Math.ceil(y1) + 1;
        }

        return answer * 4;
    }
}
