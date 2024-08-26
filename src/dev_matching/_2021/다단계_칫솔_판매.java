package dev_matching._2021;

import java.util.*;

public class 다단계_칫솔_판매 {

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, String> group = new HashMap<>();
        Map<String, Integer> record = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            group.put(enroll[i], referral[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            int total = amount[i] * 100;
            String s = seller[i];

            while (!"-".equals(s) && total > 0) {
                int profit = total * 0.1 < 1 ? total : (int) Math.ceil(total * 0.9);
                record.put(s, record.getOrDefault(s, 0) + profit);
                s = group.get(s);
                total -= profit;
            }
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = record.getOrDefault(enroll[i], 0);
        }

        return answer;
    }
}
