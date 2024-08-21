package lv3;

public class 가장_긴_팰린드롬 {

    public int solution(String s) {
        for (int range = s.length(); range >= 1; range--) {
            for (int start = 0; start + range <= s.length(); start++) {
                if (isPalindrome(s, start, start + range - 1)) {
                    return range;
                }
            }
        }

        return 1;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
}
