package lv2;

public class _2개_이하로_다른_비트 {

    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            answer[i] = f(numbers[i]);
        }

        return answer;
    }

    private long f(long x) {
        for(long n = 1; ; n <<= 1) {
            if ((x & n) == 0) {
                x |= n;
                x ^= (n >> 1);
                break;
            }
        }

        return x;
    }
}
