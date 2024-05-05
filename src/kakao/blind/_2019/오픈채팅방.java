package kakao.blind._2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 오픈채팅방 {

    public String[] solution(String[] record) {
        Map<String, String> usernames = new HashMap<>();
        List<String[]> actions = new ArrayList<>();

        for (String r : record) {
            String[] split = r.split(" ");

            switch (split[0]) {
                case "Leave":
                    actions.add(new String[] {split[0], split[1]});
                    break;
                case "Enter":
                    actions.add(new String[] {split[0], split[1]});
                case "Change":
                    usernames.put(split[1], split[2]);
            }
        }

        String[] answer = new String[actions.size()];

        for (int i = 0; i < actions.size(); i++) {
            answer[i] = getMessage(actions.get(i), usernames);
        }

        return answer;
    }

    private String getMessage(String[] action, Map<String, String> usernames) {
        String message = usernames.get(action[1]) + "님이 ";

        if (action[0].equals("Enter")) {
            message += "들어왔습니다.";
        } else {
            message += "나갔습니다.";
        }

        return message;
    }
}
