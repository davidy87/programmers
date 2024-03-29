package lv2;

import java.util.Arrays;

public class 최솟값_만들기 {

    public int solution(int[] A, int[] B) {
        int answer = 0;
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);

        for (int i = 0; i < n; i++) {
            answer += A[i] * B[n - 1 - i];
        }

        return answer;
    }
}
