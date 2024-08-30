package kakao.blind._2020;

public class 자물쇠와_열쇠 {

    public boolean solution(int[][] key, int[][] lock) {
        int M = key.length;
        int N = lock.length;

        for (int x = 0; x < M + N - 1; x++) {
            for (int y = 0; y < M + N - 1; y++) {
                int[][] rotatedKey = key.clone();

                for (int r = 0; r < 4; r++) {
                    int[][] extendedLock = extendLock(lock, M, N);
                    rotatedKey = rotate(rotatedKey, M);

                    if (check(rotatedKey, extendedLock, M, N, x, y)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean check(int[][] key, int[][] lock, int M, int N, int x, int y) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                lock[x + i][y + j] += key[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (lock[i + M - 1][j + M - 1] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    private int[][] rotate(int[][] key, int M) {
        int[][] result = new int[M][M];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                result[i][j] = key[M - 1 - j][i];
            }
        }

        return result;
    }

    private int[][] extendLock(int[][] lock, int M, int N) {
        int[][] result = new int[M * 2 - 2 + N][M * 2 - 2 + N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result[i + M - 1][j + M - 1] = lock[i][j];
            }
        }

        return result;
    }
}
