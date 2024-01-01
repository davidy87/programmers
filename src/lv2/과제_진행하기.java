package lv2;

import java.util.*;

public class 과제_진행하기 {

    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        Stack<String[]> pending = new Stack<>();
        PriorityQueue<String[]> pq = new PriorityQueue<>((p1, p2) -> convertTime(p1[1]) - convertTime(p2[1]));

        for (String[] plan : plans) {
            pq.offer(plan);
        }

        int answerIdx = 0;

        while (pq.size() >= 2) {
            String[] cur = pq.poll();
            String name = cur[0];
            int start = convertTime(cur[1]);
            int playtime = Integer.parseInt(cur[2]);
            int nextStart = convertTime(pq.peek()[1]);
            int timeLeft = nextStart - (start + playtime);

            if (timeLeft < 0) {
                pending.push(new String[] {name, String.valueOf(playtime - (nextStart - start))});
                continue;
            }

            answer[answerIdx++] = name;

            while (!pending.isEmpty() && timeLeft > 0) {
                int pendingTime = Integer.parseInt(pending.peek()[1]);

                if (timeLeft >= pendingTime) {
                    timeLeft -= pendingTime;
                    answer[answerIdx++] = pending.pop()[0];
                } else {
                    String[] p = pending.pop();
                    p[1] = String.valueOf(Integer.parseInt(p[1]) - timeLeft);
                    pending.push(p);
                    break;
                }
            }
        }

        answer[answerIdx++] = pq.poll()[0];

        while (!pending.isEmpty()) {
            answer[answerIdx++] = pending.pop()[0];
        }

        return answer;
    }

    private int convertTime(String t) {
        String[] splited = t.split(":");
        int hours = Integer.parseInt(splited[0]);
        int mins = Integer.parseInt(splited[1]);

        return hours * 60 + mins;
    }
}
