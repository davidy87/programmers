package lv3;

public class 풍선_터트리기 {

    public int solution(int[] a) {
        if (a.length <= 2) {
            return a.length;
        }

        int answer = 2;
        int l = 0;
        int r = a.length - 1;

        for (int i = 1; i < a.length - 1; i++) {
            if (a[i] < a[l]) {
                answer++;
                l = i;
            }

            if (a[a.length - 1 - i] < a[r]) {
                answer++;
                r = a.length - 1 - i;
            }
        }

        return a[l] == a[r] ? answer - 1 : answer;
    }
}
