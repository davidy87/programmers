package kakao.blind._2022;

public class k진수에서_소수_개수_구하기 {

    public int solution(int n, int k) {
        int answer = 0;
        String[] split = Integer.toString(n, k).split("0+");

        for (String numStr : split) {
            answer += isPrime(Long.parseLong(numStr)) ? 1 : 0;
        }

        return answer;
    }

    private boolean isPrime(long target) {
        if (target < 2) {
            return false;
        }

        for (long n = 2; n <= Math.sqrt(target); n++) {
            if (target % n == 0) {
                return false;
            }
        }

        return true;
    }
}
