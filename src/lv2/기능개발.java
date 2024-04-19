package lv2;

import java.util.ArrayList;
import java.util.List;

public class 기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int max = 0;
        int numDeploy = 0;

        for (int i = 0; i < progresses.length; i++) {
            int daysLeft = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);

            if (daysLeft > max) {
                if (numDeploy > 0) {
                    answer.add(numDeploy);
                }
                max = daysLeft;
                numDeploy = 0;
            }

            numDeploy++;
        }

        answer.add(numDeploy);

        return answer.stream().mapToInt(Integer::valueOf).toArray();
    }
}
