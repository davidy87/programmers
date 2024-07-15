package lv2;

public class 택배_배달과_수거하기 {

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int i = n - 1;

        while (i >= 0) {
            if (deliveries[i] == 0 && pickups[i] == 0) {
                i--;
                continue;
            }

            calculate(deliveries, i, cap);
            calculate(pickups, i, cap);

            answer += (i + 1) * 2;
        }

        return answer;
    }

    private void calculate(int[] arr, int i, int cap) {
        while (i >= 0) {
            if (arr[i] <= cap) {
                cap -= arr[i];
                arr[i--] = 0;
            } else {
                arr[i] -= cap;
                break;
            }
        }
    }
}
