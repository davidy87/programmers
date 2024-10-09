package lv3;

import java.util.*;

public class N으로_표현 {

    public int solution(int N, int number) {
        Set<Integer>[] nSet = new HashSet[8];
        String nStr = String.valueOf(N);

        for (int i = 0; i < nSet.length; i++) {
            int count = i + 1;
            nSet[i] = new HashSet<>();
            nSet[i].add(Integer.parseInt(nStr.repeat(count)));

            for (int j = 0; j < i; j++) {
                for (int op1 : nSet[j]) {
                    for (int op2 : nSet[i - j - 1]) {
                        nSet[i].add(op1 + op2);
                        nSet[i].add(op1 - op2);
                        nSet[i].add(op1 * op2);

                        if (op2 != 0) {
                            nSet[i].add(op1 / op2);
                        }
                    }
                }
            }

            if (nSet[i].contains(number)) {
                return count;
            }
        }

        return -1;
    }
}
