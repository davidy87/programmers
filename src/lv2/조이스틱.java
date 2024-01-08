package lv2;

public class 조이스틱 {

    public int solution(String name) {
        int upDown = 0;
        int leftRight = name.length();

        for (int i = 0; i < name.length(); i++) {
            char cur = name.charAt(i);
            upDown += Math.min(cur - 'A', 'Z' - cur + 1);
            int nextIdx = i + 1;

            while (nextIdx < name.length() && name.charAt(nextIdx) == 'A') {
                nextIdx++;
            }

            int moveL = i * 2 + name.length() - nextIdx;
            int moveR = (name.length() - nextIdx) * 2 + i;
            leftRight = Math.min(leftRight, Math.min(moveL, moveR));
        }

        return upDown + leftRight;
    }
}
