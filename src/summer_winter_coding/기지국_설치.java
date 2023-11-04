package summer_winter_coding;

public class 기지국_설치 {

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int apt = 1;
        int i = 0;

        while (apt <= n) {
            if (i < stations.length && stations[i] - w <= apt) {
                apt = stations[i] + w + 1;
                i++;
            } else {
                apt += w * 2 + 1;
                answer++;
            }
        }

        return answer;
    }
}
