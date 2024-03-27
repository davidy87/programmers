package lv2;

public class 최댓값과_최솟값 {

    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        String[] split = s.split(" ");

        for (String numStr : split) {
            int num = Integer.parseInt(numStr);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }

        return min + " " + max;
    }
}
