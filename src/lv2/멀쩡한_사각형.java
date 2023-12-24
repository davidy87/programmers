package lv2;

public class 멀쩡한_사각형 {

    public long solution(int w, int h) {
        return (long) w * h - (w + h - gcd(w, h));
    }

    private int gcd(int w, int h) {
        if (h == 0) {
            return w;
        }

        return gcd(h, w % h);
    }
}
