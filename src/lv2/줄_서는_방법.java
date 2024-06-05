package lv2;

import java.util.*;

public class 줄_서는_방법 {

    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> people = new ArrayList<>();
        long fac = 1;

        for (int i = 1; i <= n; i++) {
            fac *= i;
            people.add(i);
        }

        int i = 0;
        k--;

        while (i < n) {
            fac /= n - i;
            answer[i++] = people.remove((int) (k / fac));
            k %= fac;
        }

        return answer;
    }
}
