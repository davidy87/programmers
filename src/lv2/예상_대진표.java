package lv2;

public class 예상_대진표 {

    public int solution1(int n, int a, int b) {
        int answer = 0;

        while (a != b) {
            a = (int) Math.ceil(a / 2.0);
            b = (int) Math.ceil(b / 2.0);
            answer++;
        }

        return answer;
    }

    public int solution2(int n, int a, int b) {
        return Integer.toBinaryString((a - 1) ^ (b - 1)).length();
    }
}
