package lv2;

import java.util.*;

public class 연속_부분_수열_합의_개수 {

    public int solution(int[] elements) {
        int size = elements.length;
        int[] temp = new int[size];
        Set<Integer> sumSet = new HashSet<>();

        for (int n = 1; n <= size; n++) {
            for (int i = 0; i < size; i++) {
                temp[i] += elements[(i + n - 1) % size];
                sumSet.add(temp[i]);
            }
        }

        return sumSet.size();
    }
}
