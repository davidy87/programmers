package lv2;

public class 점_찍기 {

    public long solution(int k, int d) {
        long answer = 0;
        double dSquared = Math.pow(d, 2);

        for (int x = 0; x <= d; x += k) {
            int y = (int) Math.sqrt(dSquared - Math.pow(x, 2));
            answer += y / k + 1;
        }

        return answer;
    }
}
