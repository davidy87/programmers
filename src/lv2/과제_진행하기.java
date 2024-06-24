package lv2;

import java.util.*;

public class 과제_진행하기 {
    private final List<String> answer = new ArrayList<>();
    private final Queue<String[]> schedule = new PriorityQueue<>((p1, p2) -> convertTime(p1[1]) - convertTime(p2[1]));
    private final Deque<String[]> pending = new ArrayDeque<>();

    public String[] solution(String[][] plans) {
        makeSchedule(plans);
        startProjects();

        return answer.toArray(new String[plans.length]);
    }

    private void startProjects() {
        while (schedule.size() >= 2) {
            String[] curPlan = schedule.poll();
            String name = curPlan[0];
            int start = convertTime(curPlan[1]);
            int playtime = Integer.parseInt(curPlan[2]);
            int nextStart = convertTime(schedule.peek()[1]);
            int timeGap = nextStart - (start + playtime);

            if (timeGap < 0) {
                pending.offer(new String[] {name, String.valueOf(playtime - (nextStart - start))});
                continue;
            }

            answer.add(name);

            while (!pending.isEmpty() && timeGap > 0) {
                String[] p = pending.pollLast();
                int leftover = Integer.parseInt(p[1]);

                if (timeGap >= leftover) {
                    timeGap -= leftover;
                    answer.add(p[0]);
                } else {
                    p[1] = String.valueOf(leftover - timeGap);
                    pending.offer(p);
                    break;
                }
            }
        }

        answer.add(schedule.poll()[0]);

        while (!pending.isEmpty()) {
            answer.add(pending.pollLast()[0]);
        }
    }

    private void makeSchedule(String[][] plans) {
        for (String[] plan : plans) {
            schedule.offer(plan);
        }
    }

    private int convertTime(String time) {
        String[] split = time.split(":");
        int hours = Integer.parseInt(split[0]);
        int mins = Integer.parseInt(split[1]);

        return hours * 60 + mins;
    }
}
