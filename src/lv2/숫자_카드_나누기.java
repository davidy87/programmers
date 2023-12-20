package lv2;

public class 숫자_카드_나누기 {

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = arrayA[0];
        int gcdB = arrayB[0];

        for (int i = 1; i < arrayA.length; i++) {
            gcdA = gcd(gcdA, arrayA[i]);
            gcdB = gcd(gcdB, arrayB[i]);
        }

        if (isNotDiv(arrayA, gcdB)) {
            answer = Math.max(answer, gcdB);
        }

        if (isNotDiv(arrayB, gcdA)) {
            answer = Math.max(answer, gcdA);
        }

        return answer;
    }

    private boolean isNotDiv(int[] arr, int d) {
        for (int n : arr) {
            if (n % d == 0) {
                return false;
            }
        }

        return true;
    }

    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }
}
