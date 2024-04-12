package lv2;

public class n2_배열_자르기 {

    public int[] solution(int n, long left, long right) {
        int[] answer = new int[(int) (right - left + 1)];

        for (long i = left; i <= right; i++) {
            answer[(int) (i - left)] = (int) Math.max(i / n, i % n) + 1;
        }

        return answer;
    }
}
