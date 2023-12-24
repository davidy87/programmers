package lv2;

public class 점_찍기 {

    public long solution(int k, int d) {
        long answer = 0;

        for (int x = 0; x <= d; x += k) {
            double y =  Math.sqrt(Math.pow(d, 2) - Math.pow(x, 2));
            answer += (long) (Math.ceil(y / k) + (y % k == 0 ? 1 : 0));
        }

        return answer;
    }
}
