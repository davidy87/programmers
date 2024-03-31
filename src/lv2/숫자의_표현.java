package lv2;

public class 숫자의_표현 {

    public int solution(int n) {
        int answer = 1;

        for (int i = 1; i <= n / 2; i++) {
            int temp = i;
            int sum = 0;

            while (sum < n) {
                sum += temp++;
            }

            if (sum == n) {
                answer++;
            }
        }

        return answer;
    }
}
