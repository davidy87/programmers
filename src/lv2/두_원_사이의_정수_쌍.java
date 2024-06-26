package lv2;

public class 두_원_사이의_정수_쌍 {

    public long solution(int r1, int r2) {
        long answer = 0;

        for (int x = 1; x <= r2; x++) {
            long minY = (long) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(x, 2)));
            long maxY = (long) Math.sqrt(Math.pow(r2, 2) - Math.pow(x, 2));
            answer += maxY - minY + 1;
        }

        return answer * 4;
    }
}
