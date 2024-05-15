package algo.stack_queue;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를_지나는_트럭 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> bridge = new LinkedList<>();

        for (int i = 0; i < bridge_length; i++) {
            bridge.offer(0);
        }

        int i = 0;
        int bridgeWeight = 0;

        while (i < truck_weights.length) {
            answer++;
            bridgeWeight -= bridge.poll();
            int curTruck = truck_weights[i];

            if (bridgeWeight + curTruck > weight) {
                bridge.offer(0);
                continue;
            }

            bridge.offer(curTruck);
            bridgeWeight += curTruck;
            i++;
        }

        return answer + bridge_length;
    }
}
