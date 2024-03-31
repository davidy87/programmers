package lv2;

public class 이진_변환_반복하기 {

    public int[] solution(String s) {
        int[] answer = new int[2];

        while (!s.equals("1")) {
            int newSLength = s.replace("0", "").length();
            answer[0]++;
            answer[1] += s.length() - newSLength;
            s = Integer.toBinaryString(newSLength);
        }

        return answer;
    }
}
