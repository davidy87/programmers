package lv2;

public class JadenCase_문자열_만들기 {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        for (String c : s.toLowerCase().split("")) {
            sb.append(isFirst ? c.toUpperCase() : c);
            isFirst = c.equals(" ");
        }

        return sb.toString();
    }
}
