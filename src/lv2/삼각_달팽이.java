package lv2;

public class 삼각_달팽이 {

    public int[] solution(int n) {
        return getAnswer(makeSnail(n));
    }

    private int[] getAnswer(int[][] snail) {
        int n = snail.length;
        int[] answer = new int[n * (n + 1) / 2];
        int i = 0;

        for (int[] row : snail) {
            for (int num : row) {
                if (num == 0) {
                    break;
                }

                answer[i++] = num;
            }
        }

        return answer;
    }

    private int[][] makeSnail(int n) {
        int[][] snail = new int[n][n];
        int r = -1;
        int c = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    r++;
                } else if (i % 3 == 1) {
                    c++;
                } else {
                    r--;
                    c--;
                }

                snail[r][c] = num++;
            }
        }

        return snail;
    }
}
