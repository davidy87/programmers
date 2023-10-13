package graph;

import java.util.*;

public class 호텔_방_배정하기 {

    public long[] solution(long k, long[] room_number) {
        Map<Long, Long> reserved = new LinkedHashMap<>();

        for (long room : room_number) {
            List<Long> visited = new ArrayList<>();
            visited.add(room);

            while (reserved.containsKey(room)) {
                room = reserved.get(room);
                visited.add(room);
            }

            for (long prev : visited) {
                reserved.put(prev, room + 1);
            }
        }

        return reserved.keySet().stream().mapToLong(Long::longValue).toArray();
    }
}
