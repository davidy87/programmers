package lv3;

import java.util.*;

public class 불량_사용자 {

    private String[] userId;
    private String[] bannedId;
    private boolean[] visited;
    private Set<String> resultSet;

    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        userId = user_id;
        bannedId = banned_id;
        visited = new boolean[userId.length];
        resultSet = new HashSet<>();

        for (int i = 0; i < bannedId.length; i++) {
            bannedId[i] = bannedId[i].replace("*", ".");
        }

        search(0, "");

        return resultSet.size();
    }

    private void search(int idx, String cur) {
        if (idx == bannedId.length) {
            String[] users = cur.split(" ");
            Arrays.sort(users);
            resultSet.add(String.join("", users));
            return;
        }

        for (int i = 0; i < userId.length; i++) {
            if (!visited[i] && userId[i].matches(bannedId[idx])) {
                visited[i] = true;
                search(idx + 1, cur + " " + userId[i]);
                visited[i] = false;
            }
        }
    }
}
