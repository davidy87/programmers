package lv3;

import java.util.PriorityQueue;
import java.util.Queue;

public class 여행경로 {

    public String[] solution(String[][] tickets) {
        Queue<String> routes = new PriorityQueue<>();
        dfs(tickets, routes, new StringBuilder("ICN"), "ICN", 0);

        return routes.poll().split(" ");
    }

    private void dfs(String[][] tickets, Queue<String> routes, StringBuilder curRoute, String depart, int count) {
        if (count == tickets.length) {
            routes.offer(curRoute.toString());
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i][0].equals(depart)) {
                tickets[i][0] = "";
                curRoute.append(" ").append(tickets[i][1]);
                dfs(tickets, routes, curRoute, tickets[i][1], count + 1);
                curRoute.delete(curRoute.length() - 4, curRoute.length());
                tickets[i][0] = depart;
            }
        }
    }
}
