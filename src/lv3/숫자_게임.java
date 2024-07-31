package lv3;

import java.util.Arrays;

public class 숫자_게임 {

    public int solution(int[] A, int[] B) {
        int answer = 0;
        int idxA = 0;
        int idxB = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        while (idxB < B.length) {
            if (A[idxA] < B[idxB]) {
                answer++;
                idxA++;
            }

            idxB++;
        }

        return answer;
    }
}
