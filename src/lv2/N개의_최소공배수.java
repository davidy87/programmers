package lv2;

public class N개의_최소공배수 {

    public int solution(int[] arr) {
        int answer = arr[0];

        for (int num : arr) {
            answer = lcm(answer, num);
        }

        return answer;
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return gcd(b, a % b);
    }

    private int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
}
