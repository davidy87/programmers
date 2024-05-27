package lv2;

public class 마법의_엘리베이터 {

    public int solution(int storey) {
        int answer = 0;

        while (storey > 0) {
            int r = storey % 10;
            storey /= 10;
            int nextR = storey % 10;

            if (r > 5 || (r == 5 && nextR >= 5)) {
                answer += 10 - r;
                storey++;
            } else {
                answer += r;
            }
        }

        return answer;
    }
}
