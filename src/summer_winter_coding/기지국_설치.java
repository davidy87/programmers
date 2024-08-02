package summer_winter_coding;

public class 기지국_설치 {

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int s = 0;
        int apt = 1;

        while (apt <= n) {
            if (s < stations.length && apt >= stations[s] - w) {
                apt = stations[s++] + w + 1;
            } else {
                apt += w * 2 + 1;
                answer++;
            }
        }

        return answer;
    }
}
