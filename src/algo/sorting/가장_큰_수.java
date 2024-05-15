package algo.sorting;

import java.util.Arrays;

public class 가장_큰_수 {

    public String solution(int[] numbers) {
        String[] numStrs = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            numStrs[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numStrs, (n1, n2) -> (n2 + n1).compareTo(n1 + n2));

        if (numStrs[0].equals("0")) {
            return numStrs[0];
        }

        return String.join("", numStrs);
    }
}
