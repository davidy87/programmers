package kakao.blind._2021;

import java.util.*;

public class 메뉴_리뉴얼 {

    private Map<String, Integer> counter = new HashMap<>();

    private List<String> newMenuList = new ArrayList<>();

    public String[] solution(String[] orders, int[] course) {
        findNewMenu(orders, course);
        Collections.sort(newMenuList);

        return newMenuList.toArray(new String[0]);
    }

    private void findNewMenu(String[] orders, int[] course) {
        for (int c : course) {
            for (String o : orders) {
                combination(sortOrder(o), "", c);
            }

            chooseBestMenu();
        }
    }

    private void chooseBestMenu() {
        int maxCount = Collections.max(counter.values());

        if (maxCount < 2) {
            return;
        }

        for (String newMenu : counter.keySet()) {
            if (counter.get(newMenu) == maxCount) {
                newMenuList.add(newMenu);
            }
        }

        counter.clear();
    }

    private void combination(String order, String cur, int c) {
        if (cur.length() == c) {
            counter.put(cur, counter.getOrDefault(cur, 0) + 1);
            return;
        }

        for (int i = 0; i < order.length(); i++) {
            combination(order.substring(i + 1), cur + order.charAt(i), c);
        }
    }

    private String sortOrder(String order) {
        String[] split = order.split("");
        Arrays.sort(split);
        return String.join("", split);
    }
}
