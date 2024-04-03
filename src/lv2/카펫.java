package lv2;

public class 카펫 {

    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int h = 3;
        int w = total / h;

        while ((w - 2) * (h - 2) != yellow) {
            w = total / ++h;
        }

        return new int[] {w, h};
    }
}
