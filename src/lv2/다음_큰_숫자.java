package lv2;

public class 다음_큰_숫자 {

    public int solution(int n) {
        int cur = Integer.bitCount(n++);

        while (Integer.bitCount(n) != cur) {
            n++;
        }

        return n;
    }
}
