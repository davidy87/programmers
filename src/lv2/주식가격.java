package lv2;

public class 주식가격 {

    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                answer[i]++;

                if (prices[i] > prices[j]) {
                    break;
                }
            }
        }

        return answer;
    }
}
