package kakao.blind._2020;

import java.util.*;

public class 주차_요금_계산 {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> parking = new HashMap<>();
        Map<String, Integer> carFees = new TreeMap<>();

        for (String record : records) {
            String[] splited = record.split(" ");
            String time = splited[0];
            String car = splited[1];
            String action = splited[2];

            if (action.equals("IN")) {
                parking.put(car, timeInMins(time));
                carFees.put(car, carFees.getOrDefault(car, 0));
            } else {
                int totalTime = timeInMins(time) - parking.get(car);
                carFees.put(car, carFees.get(car) + totalTime);
                parking.remove(car);
            }
        }

        for (String car : parking.keySet()) {
            int totalTime = timeInMins("23:59") - parking.get(car);
            carFees.put(car, carFees.get(car) + totalTime);
        }

        for (String car : carFees.keySet()) {
            int fee = fees[1];

            if (carFees.get(car) > fees[0]) {
                fee += (int) (Math.ceil((double) (carFees.get(car) - fees[0]) / fees[2]) * fees[3]);
            }

            carFees.put(car, fee);
        }

        return carFees.values().stream().mapToInt(Integer::intValue).toArray();
    }

    private int timeInMins(String time) {
        String[] splited = time.split(":");
        int hoursInMins = Integer.parseInt(splited[0]) * 60;
        int mins = Integer.parseInt(splited[1]);

        return hoursInMins + mins;
    }
}
