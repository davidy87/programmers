package lv2;

import java.util.Arrays;

public class 구명보트 {

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int s = 0;
        int e = people.length - 1;

        while (s < e) {
            if (people[s] + people[e] <= limit) {
                s++;
                e--;
            } else {
                e--;
            }
        }

        return people.length - s;
    }
}
