package lv2;

public class 큰_수_만들기 {

    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number.length() - k);

        for (char c : number.toCharArray()) {
            while (sb.length() > 0 && k > 0 && sb.charAt(sb.length() - 1) < c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }

            sb.append(c);
        }

        return sb.delete(sb.length() - k, sb.length()).toString();
    }
}
