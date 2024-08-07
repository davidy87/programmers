package kakao.intern._2019;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 불량_사용자 {

    private String[] userId;
    private String[] bannedId;
    private boolean[] visited;
    private Set<String> resultSet;

    public int solution(String[] user_id, String[] banned_id) {
        userId = user_id;
        bannedId = banned_id;
        visited = new boolean[userId.length];
        resultSet = new HashSet<>();

        for (int i = 0 ; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace("*", ".");
        }

        search(0, "");

        return resultSet.size();
    }

    private void search(int idx, String cur) {
        if (idx == bannedId.length) {
            String[] split = cur.split(" ");
            Arrays.sort(split);
            resultSet.add(String.join("", split));
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
