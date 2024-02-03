package lv3;

public class 가장_긴_팰린드롬 {

    public int solution(String s) {
        for (int i = s.length(); i >= 1; i--) {
            for (int j = 0; j + i <= s.length(); j++) {
                if (isPalindrome(s, j, j + i - 1)) {
                    return i;
                }
            }
        }

        return 0;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
}
