package PCCP_모의고사;

public class 실습용_로봇 {

    private static final int[] dx = {0, 1, 0, -1};
    private static final int[] dy = {1, 0, -1, 0};

    public int[] solution(String command) {
        int[] answer = new int[2];
        int dir = 0;

        for (char c : command.toCharArray()) {
            if (c == 'R') {
                dir = (dir + 1) % 4;
            } else if (c == 'L') {
                dir = (dir + 3) % 4;
            } else if (c == 'G') {
                answer[0] += dx[dir];
                answer[1] += dy[dir];
            } else {
                answer[0] -= dx[dir];
                answer[1] -= dy[dir];
            }
        }

        return answer;
    }
}
