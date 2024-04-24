package lv2;

public class 피로도 {

    public int solution(int k, int[][] dungeons) {
        int answer = 0;

        for (int[] d : dungeons) {
            int a = d[0];
            int b = d[1];

            if (k >= a) {
                d[0] = 5001;
                answer = Math.max(answer, solution(k - b, dungeons) + 1);
                d[0] = a;
            }
        }

        return answer;
    }
}
