package lv2;

public class 조이스틱 {

    public int solution(String name) {
        int n = name.length();
        int upDown = 0;
        int leftRight = n;

        for (int i = 0; i < n; i++) {
            char c = name.charAt(i);
            upDown += Math.min(c - 'A', 'Z' - c + 1);
            int j = i + 1;

            while (j < n && name.charAt(j) == 'A') {
                j++;
            }

            int left = i * 2 + (n - j);
            int right = (n - j) * 2 + i;
            leftRight = Math.min(leftRight, Math.min(left, right));
        }

        return upDown + leftRight;
    }
}
