package kakao_blind_2020;

public class 문자열_압축 {

    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String base = s.substring(0, i);
            int count = 1;

            for (int j = i; j <= s.length(); j += i) {
                String compare = s.substring(j, Math.min(j + i, s.length()));

                if (compare.equals(base)) {
                    count++;
                    continue;
                }

                if (count >= 2) {
                    sb.append(count);
                }

                sb.append(base);
                base = compare;
                count = 1;
            }

            sb.append(base);
            answer = Math.min(answer, sb.length());
        }

        return answer;
    }
}
