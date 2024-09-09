package kakao.blind._2020;

public class 기둥과_보_설치 {

    public int[][] solution(int n, int[][] build_frame) {
        int[][][] map = new int[n + 1][n + 1][2];
        int count = 0;

        for (int[] frame : build_frame) {
            int x = frame[0];
            int y = frame[1];
            int a = frame[2];   // (0 = 기둥, 1 = 보)
            int b = frame[3];   // (0 = 삭제, 1 = 설치)

            if (b == 1 && isBuildable(map, x, y, a)) {
                map[x][y][a] = 1;
                count++;
            }

            if (b == 0) {
                map[x][y][a] = 0;

                if (isDeletable(map, x, y, a)) {
                    count--;
                } else {
                    map[x][y][a] = 1;
                }
            }
        }

        int[][] answer = new int[count][3];
        int i = 0;

        for (int x = 0; x <= n ; x++) {
            for (int y = 0; y <= n; y++) {
                for (int a = 0; a <= 1; a++) {
                    if (map[x][y][a] == 1) {
                        answer[i][0] = x;
                        answer[i][1] = y;
                        answer[i++][2] = a;
                    }
                }
            }
        }

        return answer;
    }

    private boolean isDeletable(int[][][] map, int x, int y, int a) {
        if (a == 0) {
            if (x - 1 >= 0 && y + 1 < map.length && map[x - 1][y + 1][1] == 1 && !isBuildable(map, x - 1, y + 1, 1)) {
                return false;
            }

            if (y + 1 < map.length && map[x][y + 1][1] == 1 && !isBuildable(map, x, y + 1, 1)) {
                return false;
            }

            if (y + 1 < map.length && map[x][y + 1][0] == 1 && !isBuildable(map, x, y + 1, 0)) {
                return false;
            }
        }

        if (a == 1) {
            if (map[x][y][0] == 1 && !isBuildable(map, x, y, 0)) {
                return false;
            }

            if (x + 1 < map.length && map[x + 1][y][0] == 1 && !isBuildable(map, x + 1, y, 0)) {
                return false;
            }

            if (x - 1 >= 0 && map[x - 1][y][1] == 1 && !isBuildable(map, x - 1, y, 1)) {
                return false;
            }

            if (x + 1 < map.length && map[x + 1][y][1] == 1 && !isBuildable(map, x + 1, y, 1)) {
                return false;
            }
        }

        return true;
    }

    private boolean isBuildable(int[][][] map, int x, int y, int a) {
        if (a == 0) {
            if (y == 0) {
                return true;
            }

            if (x - 1 >= 0 && map[x - 1][y][1] == 1) {
                return true;
            }

            if (x + 1 < map.length && map[x][y][1] == 1) {
                return true;
            }

            if (y - 1 >= 0 && map[x][y - 1][0] == 1) {
                return true;
            }
        }

        if (a == 1) {
            if (y - 1 >= 0 && map[x][y - 1][0] == 1) {
                return true;
            }

            if (y - 1 >= 0 && map[x + 1][y - 1][0] == 1) {
                return true;
            }

            if (x - 1 >= 0 && map[x - 1][y][1] == 1 && map[x + 1][y][1] == 1) {
                return true;
            }
        }

        return false;
    }
}
