package 월간_코드_챌린지_시즌2.lv3;

public class _110_옮기기 {

    public String[] solution(String[] s) {
        String[] answer = new String[s.length];

        for (int i = 0; i < s.length; i++) {
            String x = s[i];
            StringBuilder sb = new StringBuilder();
            StringBuilder targets = new StringBuilder();

            for (char c : x.toCharArray()) {
                sb.append(c);

                if (sb.length() >= 3 && "110".equals(sb.substring(sb.length() - 3))) {
                    targets.append("110");
                    sb.delete(sb.length() - 3, sb.length());
                }
            }

            sb.insert(sb.lastIndexOf("0") + 1, targets);
            answer[i] = sb.toString();
        }

        return answer;
    }
}
