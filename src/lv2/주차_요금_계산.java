package lv2;

import java.util.*;

public class 주차_요금_계산 {

    private static final String MAX_TIME = "23:59";

    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> cost = new TreeMap<>();
        Map<String, Integer> parking = new HashMap<>();

        for (String r : records) {
            String[] record = r.split(" ");
            String time = record[0];
            String number = record[1];
            String status = record[2];

            if (status.equals("IN")) {
                parking.put(number, toMinutes(time));
            } else {
                int duration = toMinutes(time) - parking.get(number);
                cost.put(number, cost.getOrDefault(number, 0) + duration);
                parking.remove(number);
            }
        }

        for (String number : parking.keySet()) {
            int duration = toMinutes(MAX_TIME) - parking.get(number);
            cost.put(number, cost.getOrDefault(number, 0) + duration);
        }

        cost.replaceAll((number, duration) -> calculateFee(fees, duration));

        return cost.values().stream().mapToInt(Integer::intValue).toArray();
    }

    private int calculateFee(int[] fees, int duration) {
        int totalFee = fees[1];

        if (duration > fees[0]) {
            totalFee += ((int) Math.ceil(((double) (duration - fees[0])) / fees[2])) * fees[3];
        }

        return totalFee;
    }

    private int toMinutes(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}
