package kakao.blind._2018;

public class 방금그곡 {

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = 0;
        m = convertChords(m);

        for (String info : musicinfos) {
            String[] split = info.split(",");
            int startTime = convertTimeToMin(split[0]);
            int endTime = convertTimeToMin(split[1]);
            int playTime = endTime - startTime;
            String title = split[2];
            String chords = getAllChords(convertChords(split[3]), playTime);

            if (chords.contains(m) && maxPlayTime < playTime) {
                answer = title;
                maxPlayTime = playTime;
            }
        }

        return answer;
    }

    private String getAllChords(String chords, int playTime) {
        int numPlay = playTime / chords.length();
        int rest = playTime % chords.length();

        return chords.repeat(numPlay) + chords.substring(0, rest);
    }

    private String convertChords(String chords) {
        String[] high = {"C", "D", "F", "G", "A", "B"};

        for (String h : high) {
            chords = chords.replace(h + "#", h.toLowerCase());
        }

        return chords;
    }

    private int convertTimeToMin(String time) {
        String[] split = time.split(":");
        int hours = Integer.parseInt(split[0]);
        int mins = Integer.parseInt(split[1]);

        return hours * 60 + mins;
    }
}
