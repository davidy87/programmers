package bfs_dfs;

import java.util.*;

public class 여행경로 {

    private boolean[] visited;
    private Queue<String> routes;

    public String[] solution(String[][] tickets) {
        String[] answer = {};
        visited = new boolean[tickets.length];
        routes = new PriorityQueue<>();
        findRoutes(tickets, "ICN", new StringBuilder("ICN"), 0);

        return routes.peek().split(" ");
    }

    private void findRoutes(String[][] tickets, String cur, StringBuilder route, int count) {
        if (count == tickets.length) {
            routes.offer(route.toString());
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(cur)) {
                visited[i] = true;
                route.append(" ").append(tickets[i][1]);
                findRoutes(tickets, tickets[i][1], route, count + 1);
                route.delete(route.length() - 4, route.length());
                visited[i] = false;
            }
        }
    }
}
