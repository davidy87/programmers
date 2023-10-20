package greedy;

public class 큰_수_만들기 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        for (char n : number.toCharArray()) {
            while (sb.length() > 0 && sb.charAt(sb.length() - 1) < n && k > 0) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }

            sb.append(n);
        }

        return sb.delete(sb.length() - k, sb.length()).toString();
    }
}
