package etc;

public class 키패드_누르기 {

    private static final String L = "L";
    private static final String R = "R";
    private static final int[][] pad = new int[][] {
            {0, 0}, {0, 1}, {0, 2},
            {1, 0}, {1, 1}, {1, 2},
            {2, 0}, {2, 1}, {2, 2},
            {3, 0}, {3, 1}, {3, 2}
    };

    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int[] curL = pad[9];
        int[] curR = pad[11];

        for (int num : numbers) {
            if (num == 0) {
                num = 11;
            }

            if (num == 1 || num == 4 || num == 7) {
                answer.append(L);
                curL = pad[num - 1];
            } else if (num == 3 || num == 6 || num == 9) {
                answer.append(R);
                curR = pad[num - 1];
            } else {
                int[] dest = pad[num - 1];
                int distL = getDist(curL, dest);
                int distR = getDist(curR, dest);

                if (distL < distR) {
                    answer.append(L);
                    curL = dest;
                } else if (distR < distL) {
                    answer.append(R);
                    curR = dest;
                } else {
                    char c = Character.toUpperCase(hand.charAt(0));
                    answer.append(c);

                    if (c == 'L') {
                        curL = dest;
                    } else {
                        curR = dest;
                    }
                }
            }
        }

        return answer.toString();
    }

    private int getDist(int[] from, int[] to) {
        return Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]);
    }
}
