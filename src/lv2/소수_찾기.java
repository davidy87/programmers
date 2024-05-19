package lv2;

import java.util.*;

public class 소수_찾기 {

    public int solution(String numbers) {
        int answer = 0;
        Set<Integer> perms = new HashSet<>();
        find(numbers, "", perms);

        for (int num : perms) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    private void find(String numbers, String cur, Set<Integer> perms) {
        if (!cur.isEmpty()) {
            perms.add(Integer.parseInt(cur));
        }

        for (int i = 0; i < numbers.length(); i++) {
            String newCur = cur + numbers.charAt(i);
            String newNumbers = numbers.substring(0, i) + numbers.substring(i + 1);
            find(newNumbers, newCur, perms);
        }
    }
}
