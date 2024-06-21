package summer_winter_coding;

public class 멀쩡한_사각형 {

    public long solution(int w, int h) {
        return (long) w * h - (w + h - gcd(w, h));
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
