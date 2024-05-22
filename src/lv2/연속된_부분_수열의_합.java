package lv2;

public class 연속된_부분_수열의_합 {

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[] {0, sequence.length - 1};
        int s = 0;
        int e = 1;
        int sum = sequence[s];

        while (s < e) {
            if (sum >= k) {
                if (sum == k && e - s - 1 < answer[1] - answer[0]) {
                    answer = new int[] {s, e - 1};
                }
                sum -= sequence[s++];
            } else if (e < sequence.length){
                sum += sequence[e++];
            } else {
                break;
            }
        }

        return answer;
    }
}
